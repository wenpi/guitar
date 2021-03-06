package com.xukaiqiang.shiro.util;

import org.apache.shiro.session.Session;

import com.xukaiqiang.shiro.entity.ShiroUser;

public class SessionUtils {

	private static String getAttributeName(String name) {
		return "com.xukaiqiang.shiro.session." + name;
	}

	private static final String LOGIN_USER = getAttributeName("LoginUser");

	public static ShiroUser getLoginUser(Session session) {
		return (ShiroUser) session.getAttribute(LOGIN_USER);
	}

	public static void setLoginUser(ShiroUser loginUser, Session session) {
		session.setAttribute(LOGIN_USER, loginUser);
	}
}
