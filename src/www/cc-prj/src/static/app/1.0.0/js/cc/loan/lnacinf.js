+ function ($,app) {"use strict ";

  var validatorNotExists = function (form) {
    // $("input[name='name']", form).rules("add", {
    //   remote: {
    //     url: app.LNACINF_NOTEXISTS,
    //     type: "POST",
    //     dateType: "text",
    //     data: {
    //       id: function () {
    //         return $("input[name='id']", form).val();
    //       },
    //       name: function () {
    //         return $("input[name='name']", form).val();
    //       }
    //     }
    //   },
    //   messages: {
    //     remote: "该账号信息表已存在！"
    //   }
    // });
  };

  /**
   * 添加账号信息表
   */
  /*var addLnAcInf = function () {
    var addModal = $('#lnacinf-add-modal');
    var addForm = $("form", addModal);
    var validator = app.bindFormValidation(addForm);
    addModal.on('hidden.bs.modal', function () {
      addForm[0].reset();
      validator.resetForm();
      $.uniform.update();
    });*/

    //校验账号信息表是否已经存在
    validatorNotExists(addForm);

    /*$('.ok', addModal).click(function () {
      if (addForm.valid()) {
        App.startPageLoading({ animate: true });
        var jqxhr = app.$submit(addForm, 'json');
        if (!jqxhr) return false;
        jqxhr.done(function (data) {
          App.stopPageLoading();
          if (app.isOK(data)) {
            $('.main-page .pagination-reload').click();
            app.alertOK('已成功新增账号信息表.');
            addModal.modal('hide');
            return;
          }
          app.alertError(data.errors.join('\n'));
        });
        return false;
      }
    });
  }*/

  /**
   * 修改账号信息表
   */
  /*var eidtLnAcInf = function () {
    var editModal = $('#lnacinf-edit-modal');
    var editForm = $("form", editModal);
    var validator = app.bindFormValidation(editForm);
    editModal.on('hidden.bs.modal', function () {
      editForm[0].reset();
      validator.resetForm();
      $.uniform.update();
    });
    editModal.on('show.bs.modal', function (event) {
      var lnacinfId = $(event.relatedTarget).data('lnacinfId');
      if (!lnacinfId) return;

      App.startPageLoading({ animate: true });
      var jqxhr = app.$getJSON(app.LNACINF_VIEW + lnacinfId);
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
    });*/

    //校验账号信息表是否已经存在
    /*validatorNotExists(editForm);

    $('.ok', editModal).click(function () {
      if (editForm.valid()) {
        App.startPageLoading({ animate: true });
        var jqxhr = app.$submit(editForm, 'json');
        if (!jqxhr) return false;
        jqxhr.done(function (data) {
          App.stopPageLoading();
          if (app.isOK(data)) {
            $('.main-page .pagination-reload').click();
            app.alertOK('已成功修改账号信息表.');
            editModal.modal('hide');
            return;
          }
          app.alertError(data.errors.join('\n'));
        });
        return false;
      }
    });
  };*/

  /**
   * 删除账号信息表
   */
  /*var deleteLnAcInf = function () {
    $(".main-page").delegate('[data-delete-lnacinf-lono]', 'click', function () {
      var lnacinfLoNo = $(this).data('deleteLnacinfLono');
      var lnacinfSubNo = $(this).data('deleteLnacinfSeqno');
      bootbox.confirm({title: '提示', message: '确定删除账号信息表',
        callback: function (result) {
          if (!result) {
            return;
          }

          App.startPageLoading({ animate: true });
          var jqxhr = app.$post(app.LNACINF_REMOVE, {"loNo":lnacinfLoNo,"subNo":lnacinfSubNo}, 'json');
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
  };*/

  var init = function() {
    addLnAcInf();
    eidtLnAcInf();
    deleteLnAcInf();
  };
  init();
} (window.jQuery,window.app);
