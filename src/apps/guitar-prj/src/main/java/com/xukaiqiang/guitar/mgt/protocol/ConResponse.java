package com.xukaiqiang.guitar.mgt.protocol;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.xukaiqiang.shared.protocol.OutputMessage;
import com.xukaiqiang.shared.util.CopierUtils;

@JsonInclude(Include.NON_NULL)
public class ConResponse extends OutputMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userId;
	private String phone;
	private String wechat;
	private String qq;
	private String email;
	private String liveNum;
	private String liveName;

	/**
	 * @return 
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 *
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return 用户编号
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * 用户编号
	 *
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return 手机号码
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 手机号码
	 *
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return 微信
	 */
	public String getWechat() {
		return wechat;
	}

	/**
	 * 微信
	 *
	 * @param wechat
	 */
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	/**
	 * @return qq
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * qq
	 *
	 * @param qq
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * @return 邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 邮箱
	 *
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return 直播号
	 */
	public String getLiveNum() {
		return liveNum;
	}

	/**
	 * 直播号
	 *
	 * @param liveNum
	 */
	public void setLiveNum(String liveNum) {
		this.liveNum = liveNum;
	}

	/**
	 * @return 直播平台名
	 */
	public String getLiveName() {
		return liveName;
	}

	/**
	 * 直播平台名
	 *
	 * @param liveName
	 */
	public void setLiveName(String liveName) {
		this.liveName = liveName;
	}

	public static <E> ConResponse buildResponse(ConResponse response, E e) {
		CopierUtils.copy(e, response);
		return response;
	}

}