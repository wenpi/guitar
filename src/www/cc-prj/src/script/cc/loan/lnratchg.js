+function($, app) {
  /**
   * 面包屑导航数据
   * @type {{icon: string, dt: string, dd: Array}}
   */
  app.crumbs = {
    dt: {
      text: '主页',
      url: '/index.html'
    },
    dd: [
      {
        text: '利率变更表管理',
        url: '#'
      }
    ]
  };

  
} (window.jQuery, window.app);
