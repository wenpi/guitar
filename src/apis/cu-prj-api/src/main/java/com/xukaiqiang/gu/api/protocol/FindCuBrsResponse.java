package com.xukaiqiang.gu.api.protocol;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.xukaiqiang.shared.protocol.OutputMessage;

/**
 * 查找所有机构.客户端请求
 * 
 * @author 代码生成器v1.0
 * 
 */
@JsonInclude(Include.NON_NULL)
public class FindCuBrsResponse extends OutputMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * @see com.xukaiqiang.gu.mgt.protocol.FindCuBrsResponse#getContent
	 */
	@JsonInclude(Include.NON_NULL)
	public static class Content implements Serializable {
		private static final long serialVersionUID = 1L;

		private String brNo;
		private String brNa;
		private String prevBrNo;

		/**
		 * @return 机构编号
		 */
		public String getBrNo() {
			return brNo;
		}
		/**
		 * @param brNo 机构编号
		 */
		public void setBrNo(String brNo) {
			this.brNo = brNo;
		}

		/**
		 * @return 机构名称
		 */
		public String getBrNa() {
			return brNa;
		}
		/**
		 * @param brNa 机构名称
		 */
		public void setBrNa(String brNa) {
			this.brNa = brNa;
		}

		/**
		 * @return 上级机构编号
		 */
		public String getPrevBrNo() {
			return prevBrNo;
		}
		/**
		 * @param prevBrNo 上级机构编号
		 */
		public void setPrevBrNo(String prevBrNo) {
			this.prevBrNo = prevBrNo;
		}
	}

	private List<Content> content;

	/**
	 * @return 
	 */
	public List<Content> getContent() {
		return content;
	}
	/**
	 * @param content 
	 */
	public void setContent(List<Content> content) {
		this.content = content;
	}

}