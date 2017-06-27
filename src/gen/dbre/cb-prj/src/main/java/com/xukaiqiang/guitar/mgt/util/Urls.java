package com.xukaiqiang.guitar.mgt.util;

public abstract class Urls {

	/** 
	 * 用户管理首页
	 *
	 * @see com.xukaiqiang.guitar.mgt.controller.UserController#index()
	 */
	public static final String USER_INDEX = "/guitar/user/index";
	/** 
	 * 用户首页／首屏数据
	 *
	 * @see com.xukaiqiang.guitar.mgt.controller.UserController#index(org.springframework.ui.Model, java.util.Locale)
	 */
	public static final String SCRIPT_USER = "/script/guitar/user";
	/** 
	 * 用户列表分页
	 * 
	 * @see com.xukaiqiang.guitar.mgt.controller.UserController#listPage(Integer, Integer, com.xukaiqiang.guitar.mgt.protocol.UserFilterRequest, java.util.Locale)
	 */
	public static final String USER_PAGE = "/guitar/user/page/{pageNumber}";
	/** 
	 * 用户列表
	 * 
	 * @see com.xukaiqiang.guitar.mgt.controller.UserController#list(com.xukaiqiang.guitar.mgt.protocol.UserFilterRequest, java.util.Locale)
	 */
	public static final String USER_LIST = "/guitar/user/list";
	/** 
	 * 查看用户
	 * 
	 * @see com.xukaiqiang.guitar.mgt.controller.UserController#view(Integer, java.util.Locale)
	 */
	public static final String USER_VIEW = "/guitar/user/view/{id}";
	/** 
	 * 创建用户
	 * 
	 * @see com.xukaiqiang.guitar.mgt.controller.UserController#create(com.xukaiqiang.guitar.mgt.protocol.UserCreateRequest, org.springframework.validation.BindingResult, com.xukaiqiang.guitar.orm.entity.User, java.util.Locale)
	 */
	public static final String USER_CREATE = "/guitar/user/create";
	/** 
	 * 修改用户
	 * 
	 * @see com.xukaiqiang.guitar.mgt.controller.UserController#update(com.xukaiqiang.guitar.mgt.protocol.UserUpdateRequest, org.springframework.validation.BindingResult, com.xukaiqiang.guitar.orm.entity.User, java.util.Locale)
	 */
	public static final String USER_UPDATE = "/guitar/user/update";
	/** 
	 * 删除用户
	 * 
	 * @see com.xukaiqiang.guitar.mgt.controller.UserController#remove(Integer, java.util.Locale)
	 */
	public static final String USER_REMOVE = "/guitar/user/remove/{id}";

}
