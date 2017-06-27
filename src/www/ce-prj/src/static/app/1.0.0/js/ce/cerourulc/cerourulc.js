+ function($, app) {
    app.registerTextHelper('traTyp', app.traTyp, 'code', 'name');
    app.registerTextHelper('rulSt', app.rulSt, 'code', 'name');
    app.registerTextHelper('fieTyp', app.fieTyp, 'code', 'name');
}(window.jQuery, window.app);

$(function () {
  var $ = window.jQuery;
  var app = window.app;
  var operatingMode;

  $('.main-page').pagination({
    "first-store": app.firstStore
  });

  //交易类型
  $('#traTyp').selectloader({'traTypList': app.traTyp});
  //路由规则状态
  $('#rulSt').selectloader({'rulStList': app.rulSt});
  //字段类型
  $('#fieTyp').selectloader({'fieTypList': app.fieTyp});
  
  app.context.formHtml = $('#form-template').html();

  app.context.formInit = function (form) {
	  
	form.find('.traTyp').selectloader({traTypList:app.traTyp});
	form.find('.rulSt').selectloader({rulStList:app.rulSt});
	form.find('.fieTyp').selectloader({fieTypList:app.fieTyp});
    // 初始化时间插件
    form.find(".date-picker-page").datepicker({
      rtl: App.isRTL(),
      autoclose: !0,
    });
    app.bindFormValidation(form);
    
  	traNoExists(form);


  };

  /**
   *验证路由的交易码是否存在
   * */
  var traNoExists = function (form) {
 	     $("input[name='traNo']", form).rules("add", {
 	    	 synchronousRemote: {
 	         url: app.CEROURULC_NOTEXISTS,
 	         type: "POST",
 	         dateType: "text",
 	         data:{
 	        	 traNo:function(){
 	        		  return form.find('[name="traNo"]').val();
 	        	 }
 	         }
 	       },	
 	       messages: {
 	    	   synchronousRemote: "该交易码不存在，请在交易渠道配置！"
 	       },
 	       onkeyup: false,
            onfocusout: false
 	     });
 	  };
 	  
  /**
   * 增加操作的弹框
   */
  $('#add').getModal({
        title: '新增路由规则配置',
        body: app.context.formHtml, /* 获取form的html模板，并填充到模态框中 */
        showBefore: function (modal) {
          operatingMode='add'
          app.context.showBefore({
            modal: modal
          }, app, app.context.formInit);
        },
        hideAfter: function (modal) {
          modal.setBody(app.context.formHtml);
        }
      },
      function (modal) {
        app.context.submit({
          modal: modal,
          url: app.CEROURULC_CREATE
        }, app);
      });


  /**
   * 修改路由规则配置
   */
  $('#edit').getModal({
    title: '编辑路由规则配置',
    body: app.context.formHtml, /* 获取form的html模板，并填充到模态框中 */
    selector: function () {
      return !!$('[type=radio]:checked').length;
    },
    showBefore: function (modal) {
      var id = $('[type=radio]:checked').data('id');
      operatingMode='edit'

      if (!id) return;
      app.context.showBefore({
        url: app.CEROURULC_VIEW,
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
      url: app.CEROURULC_UPDATE
    }, app);
  });

  /**
   * 移出操作的弹框
   */
  $('#delete').getModal({
    text: '确定要删除该条路由规则配置吗？',
    size: 'modal-sm',
    selector: function () {
      return !!$('[type=radio]:checked').length;
    }
  }, function (modal) {
    var rulId=$('[type=radio]:checked').data('id');
    app.context.submit({
      modal: modal,
      url: app.CEROURULC_REMOVE+rulId,
      text: '删除成功',
      isEasyModal: true
    }, app);
  });

});
