package com.xukaiqiang.gb.mgt.protocol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.xukaiqiang.shared.protocol.PageResponse;
import com.xukaiqiang.shared.util.CopierUtils;

@JsonInclude(Include.NON_NULL)
public class EducationPageResponse extends PageResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	public static class Element implements Serializable {
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

	private List<Element> content = new ArrayList<Element>();

	/**
	 * 记录列表
	 * 
	 * @return
	 */
	public List<Element> getContent() {
		return content;
	}

	/**
	 * 记录列表
	 *
	 * @param content
	 */
	public void setContent(List<Element> content) {
		this.content = content;
	}

	public static <E> EducationPageResponse buildPageResponse(EducationPageResponse pageResponse, Page<E> page, int displayPages) {
		pageResponse.buildPages(page, displayPages);

		for(E e : page.getContent()) {
			Element element = new Element();
			CopierUtils.copy(e, element);
			pageResponse.getContent().add(element);
		}

		return pageResponse;
	}

}
