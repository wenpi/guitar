+ function ($, app) {
  if (app.forceChangeLoginPassword) {
    return;
  }
  $(function () {

    /**
     * 检测是否已经登录
     */
    app.$getJSON(app.base + '/check-login').done(function (json) {
        console.log('checkLogin', json);
        if (app.isOK(json)) {
            console.log('已经登录.');
        } else {
          window.location.href = app.base + '/index';
        }
    });

    // app.$getJSON(app.base + '/menu/mymenu').done(function (data) {
    //   if (app.isOK(data)) {
    //     $('.page-sidebar').menusidebarloader({ "menus": data.payload });
    //   }
    // });
  });
}(window.jQuery, window.app);

+ function ($, app) {
  $(function () {
    $('[data-change-menu-location-url]').click(function () {
      app.$get($(this).data("changeMenuLocationUrl"), {}, 'text').done(function () {
        window.location.href = app.requestUrl;
      });
    });
  });
}(window.jQuery, window.app);

+ function ($, app) {
  if (!app.forceChangeLoginPassword) {
    return;
  }
  var modal = $('#chgloginpwd-modal');
  modal.find('[data-dismiss="modal"]').hide();
  modal.find('#chgloginpwd-msg').html("首次登录，请修改登录密码");
  modal.modal({ backdrop: 'static', keyboard: false });
}(window.jQuery, window.app);
