package com.xukaiqiang.gu.mgt.protocol;

import java.io.Serializable;

import com.xukaiqiang.shared.protocol.OutputMessage;
import com.xukaiqiang.shared.util.CopierUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CuIconSResponse extends OutputMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private String iconNo;
	private Integer ve;
	private String crDt;
	private String crTm;
	private String laUpDt;
	private Long laUpUsId;
	private String iconNa;
	private String iconAdCa;
	private String co;
	private String queryAllParamString;
	/**
	 * 全部查询条件
	 * @return
	 */
	public String getQueryAllParamString() {
		return queryAllParamString;
	}
	/**
	 * 全部查询条件
	 * @param queryAllParamString
	 */
	public void setQueryAllParamString(String queryAllParamString) {
		this.queryAllParamString = queryAllParamString;
	}
	/**
	 * @return 图标编号
	 */
	public String getIconNo() {
		return iconNo;
	}

	public void setIconNo(String iconNo) {
		this.iconNo = iconNo;
	}

	/**
	 * @return 版本
	 */
	public Integer getVe() {
		return ve;
	}

	public void setVe(Integer ve) {
		this.ve = ve;
	}

	/**
	 * @return 创建日期
	 */
	public String getCrDt() {
		return crDt;
	}

	public void setCrDt(String crDt) {
		this.crDt = crDt;
	}

	/**
	 * @return 创建时间
	 */
	public String getCrTm() {
		return crTm;
	}

	public void setCrTm(String crTm) {
		this.crTm = crTm;
	}

	/**
	 * @return 最后更新日期
	 */
	public String getLaUpDt() {
		return laUpDt;
	}

	public void setLaUpDt(String laUpDt) {
		this.laUpDt = laUpDt;
	}

	/**
	 * @return 最新更新用户
	 */
	public Long getLaUpUsId() {
		return laUpUsId;
	}

	public void setLaUpUsId(Long laUpUsId) {
		this.laUpUsId = laUpUsId;
	}

	/**
	 * @return 图标名称
	 */
	public String getIconNa() {
		return iconNa;
	}

	public void setIconNa(String iconNa) {
		this.iconNa = iconNa;
	}

	/**
	 * @return 图标地址
	 */
	public String getIconAdCa() {
		return iconAdCa;
	}

	public void setIconAdCa(String iconAdCa) {
		this.iconAdCa = iconAdCa;
	}

	/**
	 * @return 
	 */
	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public static <E> CuIconSResponse buildResponse(CuIconSResponse response, E e) {
		CopierUtils.copy(e, response);
		return response;
	}

}
