package com.xukaiqiang.gu.mgt.protocol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.xukaiqiang.shared.protocol.OutputMessage;
import com.xukaiqiang.shared.util.CopierUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CuUsHolLListResponse extends OutputMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	public static class Element implements Serializable {
		private static final long serialVersionUID = 1L;

		private Long tr;
		private Long usId;
		private Integer ve;
		private String crDt;
		private String crTm;
		private String laUpDt;
		private Long laUpUsId;
		private String efDt;
		private String holBeDt;
		private String holEnDt;
		private String holCd;
		private String woDt;
		private String woTm;
		private String loginNa;
		private String loginTrId;
		private String co;
		private String holCauCa;

		/**
		 * 请假原因
		 * 
		 * @return
		 */
		public String getHolCauCa() {
			return holCauCa;
		}

		public void setHolCauCa(String holCauCa) {
			this.holCauCa = holCauCa;
		}

		/**
		 * 登录名
		 * 
		 * @return
		 */
		public String getLoginNa() {
			return loginNa;
		}

		public void setLoginNa(String loginNa) {
			this.loginNa = loginNa;
		}

		/**
		 * 登录流水号
		 * 
		 * @return
		 */
		public String getLoginTrId() {
			return loginTrId;
		}

		public void setLoginTrId(String loginTrId) {
			this.loginTrId = loginTrId;
		}

		/**
		 * 备注
		 * 
		 * @return
		 */
		public String getCo() {
			return co;
		}

		public void setCo(String co) {
			this.co = co;
		}

		/**
		 * 上班日期
		 * 
		 * @return
		 */
		public String getWoDt() {
			return woDt;
		}

		public void setWoDt(String woDt) {
			this.woDt = woDt;
		}

		/**
		 * 上班时间
		 * 
		 * @return
		 */
		public String getWoTm() {
			return woTm;
		}

		public void setWoTm(String woTm) {
			this.woTm = woTm;
		}

		/**
		 * @return 申请请假流水
		 */
		public Long getTr() {
			return tr;
		}

		public void setTr(Long tr) {
			this.tr = tr;
		}

		/**
		 * @return 用户标识
		 */
		public Long getUsId() {
			return usId;
		}

		public void setUsId(Long usId) {
			this.usId = usId;
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
		 * @return 生效日期<br>
		 *         休假或者上班生效日期
		 */
		public String getEfDt() {
			return efDt;
		}

		public void setEfDt(String efDt) {
			this.efDt = efDt;
		}

		/**
		 * @return 休假开始日期
		 */
		public String getHolBeDt() {
			return holBeDt;
		}

		public void setHolBeDt(String holBeDt) {
			this.holBeDt = holBeDt;
		}

		/**
		 * @return 休假结束日期
		 */
		public String getHolEnDt() {
			return holEnDt;
		}

		public void setHolEnDt(String holEnDt) {
			this.holEnDt = holEnDt;
		}

		/**
		 * @return 休假代码<br>
		 *         XJ 休假 <br>
		 *         SB 上班
		 */
		public String getHolCd() {
			return holCd;
		}

		public void setHolCd(String holCd) {
			this.holCd = holCd;
		}

	}

	private List<Element> content = new ArrayList<Element>();

	/**
	 * 记录列表
	 * 
	 * @return
	 */
	public List<Element> getContent() {
		return content;
	}

	public void setContent(List<Element> content) {
		this.content = content;
	}

	public static <E> CuUsHolLListResponse buildListResponse(
			CuUsHolLListResponse pageResponse, List<E> list) {
		for (E e : list) {
			Element element = new Element();
			CopierUtils.copy(e, element);
			pageResponse.getContent().add(element);
		}

		return pageResponse;
	}

}