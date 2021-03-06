+function($,app) {"use strict ";

  app.resourceJsTreeInit = function(elem, options) {
    //获取数据源
    var store = elem.data('jstreepanelStore');
    if(store) {
      store = options[store];
    }

    $tree = elem.find("div.jstree-panel");
    if(store) {
      $tree.jstree({
        core: {
          data: [store],
          themes: {
            responsive: false
          }
        },
        types: {
          default: {
            icon: 'fa fa-folder icon-state-warning icon-lg'
          },
          file: {
            icon: 'fa fa-file icon-state-warning icon-lg'
          }
        },
        plugins: ['checkbox','types']
      });
    }

    var permissionsForm = $("#role-permissions");
    app.bindFormValidation(permissionsForm);

    //保存
    $("button.ok", permissionsForm).unbind('click').click(function(){
      $('input[name="selectedIds"]', permissionsForm).val($tree.jstree("get_selected"));
      var jqxhr = app.$submit(permissionsForm, 'json');
      if (!jqxhr) return false;
      jqxhr.done(function(result) {
        if (app.isOK(result)) {
          app.alertOK('修改成功');
          window.location.href = app.base + "/role/index";
          return;
        }
        app.alertError(data.errors.join('\n'));
      });
    });
    //取消
    $("button.cancel", permissionsForm).unbind('click').click(function(){
      window.location.href=app.base+"/role/index";
    });
  };

}(window.jQuery,window.app);
