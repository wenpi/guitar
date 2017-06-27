<%@ page contentType="text/javascript;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

window.app = window.app || {};

+function($, app) {
 //电话回访贷款信息：
      app.pathArray=[
            {"code":"saveData","flag": <spring:eval expression="@FN_CB.checkPath('/cb/loandetailapply/viewAll/*')" />}
          ];
	app.loanKindCodeList =app.dicts.dict_44; /*贷款分类*/
	app.loanUseCodeList =app.dicts.dict_137; /*贷款用途*/
	app.paymentMethodIdList=app.dicts.dict_37;/*还款类型*/
	app.feeTypeCodeList=app.dicts.dict_1;		/*费用类型*/
	app.materialTypeCodeList=app.dicts.dict_52;/*材料类型代码*/
	app.marryCodeTypeList = app.dicts.dict_11;   /*婚姻状况代码*/
	app.papersTypeList = app.dicts.dict_17;   /*证件类型代码*/
	app.paymentFromList = app.dicts.dict_15;   /*还款来源*/
	app.homeLiveList = app.dicts.dict_12;   /*地址类型*/
	app.paymentMethodIdList=app.dicts.dict_41;/*还款方式*/
	app.makeloanmethodList=app.dicts.dict_125;/*放款方式*/
	app.paymentmethodList=app.dicts.dict_66;/*付款方式*/
	app.paydays=app.dicts.dict_62;/*每期还款日*/
	app.accountuseList=app.dicts.dict_65;/*账号用途*/
	app.feecollctTypeList=app.dicts.dict_2;/*费用收取类型*/
	app.goodsTypeList=app.dicts.dict_138;/*商品类型*/
	app.loanTypeList = '<%=request.getAttribute("loanType")%>';   /*贷款产品*/
	/*申请期限*/
	   app.deadlineForApplicationList=[
        {"code": "1", "name": "1"},
        {"code": "2", "name": "2"},
        {"code": "3", "name": "3"},
        {"code": "4", "name": "4"},
        {"code": "5", "name": "5"},
        {"code": "6", "name": "6"},
        {"code": "7", "name": "7"},
        {"code": "8", "name": "8"},
        {"code": "9", "name": "9"},
        {"code": "10", "name": "10"},
        {"code": "11", "name": "11"},
        {"code": "12", "name": "12"}
    ];
    /*贷款品种*/
    app.loanKindList=[
        {"code": "11", "name": "方案一"}
    ];
	/*贷款利率*/
	  app.executionRateFirstLoanList=[
        {"code": "0.01", "name": "0.01"}
    ];
		/*还款间隔*/
	  app.payFreQtList=[
        {"code": "1", "name": "1"}
    ];
	/*客户经理*/
	  app.cuMaNaList=[
        {"code": "1", "name": "张三"}
    ];
    
    /*促销方案*/
	app.applySubPromNaList=[
        {"code": "1", "name": "降息"}
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
                text: '贷款信息',
                url: '#'
            }
        ]
    };
} (window.jQuery, window.app);

