<%@ page contentType="text/javascript;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

window.app = window.app || {};

+function($, app) {
//电核初核进件历史：
   app.pathArray=[
         {"code":"nextPage","flag": <spring:eval expression="@FN_CB.checkPath('/cb/loandetailapply/viewPeoplesForInput/*')" />}
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
                text: '电核/初审',
                 url: '/cb/nucleus-nucleus/nucleus-nucleus-list.html'
            },
            {
                text: '进件历史',
                url: '#'
            }
        ]
    };
    
	
} (window.jQuery, window.app);

