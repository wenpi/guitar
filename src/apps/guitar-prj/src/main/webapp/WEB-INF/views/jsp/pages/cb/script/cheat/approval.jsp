<%@ page contentType="text/javascript;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>	
	
window.app = window.app || {};	
	
	
/**
 * 数据模拟
 */
+function ($, app) {
	 app.pathArray=[
      {"code":"blackName","flag": <spring:eval expression="@FN_CB.checkPath('/cb/flowLoanApply/addToBlank/*')" />},
      {"code":"grayName","flag": <spring:eval expression="@FN_CB.checkPath('/cb/flowLoanApply/addToGray/*')" />}  
    ];
	
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
                text: '欺诈审批',
               url: '/cb/fraud-cognizance/fraud-list.html'
            },
            {
                text: '审核项信息',
                url: '/cb/fraud-cognizance/fraud-approval.html'
            }
        ]
    };

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

}(window.jQuery, window.app);