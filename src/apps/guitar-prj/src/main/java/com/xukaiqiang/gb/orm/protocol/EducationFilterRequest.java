package com.xukaiqiang.gb.orm.protocol;

import java.io.Serializable;

public class EducationFilterRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userId;
	private String schoolName;

	/**
	 * @return 编号
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 编号
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
	 * @return 学校名称
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * 学校名称
	 *
	 * @param schoolName
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}
