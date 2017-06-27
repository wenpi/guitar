<%@ page contentType="text/javascript;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

window.app = window.app || {};

+function($, app) {
      //电话回访风险预警：
     app.pathArray=[
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
                text: '电话回访',
                  url: '/cb/call-return-visit/return-visit-list.html'
            },
            {
                text: '风险预警',
                url: '#'
            }
        ]
    };
    
	
} (window.jQuery, window.app);

