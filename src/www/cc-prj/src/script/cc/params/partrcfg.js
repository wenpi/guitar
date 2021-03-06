+function($, app) {
  /**
   * 面包屑导航数据
   * @type {{icon: string, dt: string, dd: Array}}
   */
  app.crumbs = {
    dt: {
      text: '主页',
      url: '#'
    },
    dd: [
      {
        text: '交易码配置管理',
        url: '#'
      }
    ]
  };

  $(function () {
   
    $('.main-page').pagination({
      "first-store": app.firstStore
    });
    $('.main-page .pagination-reload').click();
  });
} (window.jQuery, window.app);

