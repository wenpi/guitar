/**
 * 数据模拟
 */
+function ($, app) {
    /**
     * 面包屑导航数据
     * @type {{icon: string, dt: string, dd: Array}}
     */
    app.crumbs = {
        icon: 'business-processing',
        dt: {
            text: '业务办理',
            url: '#'
        },
        dd: [
            {
                text: '贷款申请处理',
                url: '#'
            },
            {
                text: '上级电话回访',
                url: '/cb/superior-telephone-return/superior-telephone-return-list.html'
            },
            {
                text: '进件历史',
                url: '/cb/superior-telephone-return/superior-history-into-pieces.html'
            }
        ]
    }
}(window.jQuery, window.app);