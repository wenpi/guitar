
$(function () {
  var $ = window.jQuery;
  var app = window.app;
  $('.main-page').pagination({
    "first-store": app.firstStore
  });

  app.context.formHtml = $('#form-template').html();
  app.context.formInit = function (form) {
    // 初始化时间插件
    form.find(".date-picker-page").datepicker({
      rtl: App.isRTL(),
      orientation: "left",
      autoclose: !0,
      format: "yyyy-mm-dd",
      'start-date': "+0d",
      language: 'zh-CN'
    });
    app.bindFormValidation(form);

  };

  /**
   * 增加操作的弹框
   */
  $('#add').getModal({
    title: '新增文件日志表',
    body: app.context.formHtml, /* 获取form的html模板，并填充到模态框中 */
    showBefore: function (modal) {
      app.context.showBefore({
        modal: modal
      }, app, app.context.formInit);
    },
    hideAfter: function (modal) {
      modal.setBody(app.context.formHtml);
    }
  }, function (modal) {
    app.context.submit({
      modal: modal,
      url: app.CEFIRCD_CREATE
    }, app);
  });


  /**
   * 修改文件日志表
   */
  $('#edit').getModal({
    title: '编辑文件日志表',
    body: app.context.formHtml, /* 获取form的html模板，并填充到模态框中 */
    selector: function () {
      return !!$('[type=radio]:checked').length;
    },
    showBefore: function (modal) {
      var id = $('[type=radio]:checked').data('id');
      if (!id) return;
      app.context.showBefore({
        url: app.CEFIRCD_VIEW,
        modal: modal,
        param: id
      }, app, app.context.formInit);
    },
    hideAfter: function (modal) {
      modal.setBody(app.context.formHtml);
    }
  }, function (modal) {
    app.context.submit({
      modal: modal,
      url: app.CEFIRCD_UPDATE
    }, app);
  });


  $('#delete').getModal({
    text: '确定要删除该条文件日志表吗？',
    size: 'modal-sm',
    selector: function () {
      return !!$('[type=radio]:checked').length;
    }
  }, function (modal) {
    var fiNo=$('[type=radio]:checked').data('id');
    app.context.submit({
      modal: modal,
      url: app.CEFIRCD_REMOVE+fiNo,
      text: '删除成功',
      isEasyModal: true
    }, app);
  });
});