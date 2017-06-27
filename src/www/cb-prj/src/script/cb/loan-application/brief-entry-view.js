/**
 * Created by Administrator on 2017/1/7 0007.
 */
/**
 * 数据模拟
 */
+function ($, app) {

    var urlSearch = function(url){
        var param = {};
        var num = url.indexOf("?")
        url = url.substr(num + 1);

        var arr = url.split("&");
        $.each(arr, function(i, v){
            num = v.indexOf("=");
            if (num > 0) {
                var name = v.substring(0, num);
                var value = v.substr(num + 1);
                param[name] = value;
            }
        });

        return param;
    }

    var request = new urlSearch(window.location.href);

    $.extend(app, { request: request });

} (window.jQuery, window.app);

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
                text: '贷款申请简要录入',
                url: '/cb/loan-application/brief-entry.html'
            },
            {
                text: '查看',
                url: '/cb/loan-application/brieft-entry-view.html'
            }
        ]
    };
}(window.jQuery, window.app);