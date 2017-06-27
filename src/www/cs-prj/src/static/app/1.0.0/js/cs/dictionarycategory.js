+ function ($,app) {"use strict ";

  var validatorNotExists = function (form) {
    $("input[name='name']", form).rules("add", {
      remote: {
        url: app.DICTIONARYCATEGORY_NOTEXISTS,
        type: "POST",
        dateType: "text",
        data: {
          id: function () {
            return $("input[name='id']", form).val();
          },
          name: function () {
            return $("input[name='name']", form).val();
          }
        }
      },
      messages: {
        remote: "该字典分类已存在！"
      }
    });
  };

  /**
   * 添加字典分类
   */
  var addDictionary = function () {
    var addModal = $('#dict-add-modal');
    var addForm = $("form", addModal);
    var validator = app.bindFormValidation(addForm);
    addModal.on('hidden.bs.modal', function () {
      addForm[0].reset();
      validator.resetForm();
      $.uniform.update();
    });

    //校验字典分类是否已经存在
    validatorNotExists(addForm);
    $("input[name='id']", addForm).rules("add", {
      remote: {
        url: app.DICTIONARYCATEGORY_NOTEXISTSID,
        type: "POST",
        dateType: "text",
        data: {
          id: function () {
            return $("input[name='id']", addForm).val();
          }
        }
      },
      messages: {
        remote: "该字典分类编号已存在！"
      }
    });

    $('.ok', addModal).click(function () {
      if (addForm.valid()) {
        App.startPageLoading({ animate: true });
        var jqxhr = app.$submit(addForm, 'json');
        if (!jqxhr) return false;
        jqxhr.done(function (data) {
          App.stopPageLoading();
          if (app.isOK(data)) {
            $('.main-page .pagination-reload').click();
            app.alertOK('已成功新增字典分类.');
            addModal.modal('hide');
            return;
          }
          app.alertError(data.errors.join('\n'));
        });
        return false;
      }
    });
  }

  /**
   * 修改字典分类
   */
  var eidtDictionary = function () {
    var editModal = $('#dict-edit-modal');
    var editForm = $("form", editModal);
    var validator = app.bindFormValidation(editForm);
    editModal.on('hidden.bs.modal', function () {
      editForm[0].reset();
      validator.resetForm();
      $.uniform.update();
    });
    editModal.on('show.bs.modal', function (event) {
      var dictionaryId = $(event.relatedTarget).data('dictId');
      if (!dictionaryId) return;

      App.startPageLoading({ animate: true });
      
      var jqxhr = app.$getJSON(app.DICTIONARYCATEGORY_VIEW + dictionaryId);
      if (!jqxhr) {
        return;
      }

      jqxhr.done(function (data) {
        App.stopPageLoading();
        if (data == null) {
          return;
        }
        editForm.deserializeObject(data);
      });
    });

    //校验字典分类是否已经存在
    validatorNotExists(editForm);

    $('.ok', editModal).click(function () {
      if (editForm.valid()) {
        App.startPageLoading({ animate: true });
        var jqxhr = app.$submit(editForm, 'json');
        if (!jqxhr) return false;
        jqxhr.done(function (data) {
          App.stopPageLoading();
          if (app.isOK(data)) {
            $('.main-page .pagination-reload').click();
            app.alertOK('已成功修改字典分类.');
            editModal.modal('hide');
            return;
          }
          app.alertError(data.errors.join('\n'));
        });
        return false;
      }
    });
  };

  /**
   * 删除字典分类
   */
  var deleteDictionary = function () {
    $(".main-page").delegate('[data-delete-wb-id]', 'click', function () {
      var wbId = $(this).data('deleteWbId');
      bootbox.confirm({title: '提示', message: '确定删除字典分类',
        callback: function (result) {
          if (!result) {
            return;
          }

          App.startPageLoading({ animate: true });
          var jqxhr = app.$post(app.DICTIONARYCATEGORY_REMOVE + wbId, {}, 'json');
          if (!jqxhr) {
            App.stopPageLoading();
            return;
          }

          jqxhr.done(function (data) {
            App.stopPageLoading();
            if (app.isOK(data)) {
              $('.main-page .pagination-reload').click();
              app.alertOK('删除成功.');
              return;
            }
            app.alertError(data.errors.join('\n'));
          });
        }
      });
    });
  };

  var init = function() {
    addDictionary();
    eidtDictionary();
    deleteDictionary();
  };
  init();
} (window.jQuery,window.app);
