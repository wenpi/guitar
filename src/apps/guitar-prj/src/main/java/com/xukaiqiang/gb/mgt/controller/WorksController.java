package com.xukaiqiang.gb.mgt.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xukaiqiang.shared.SharedVars;
import com.xukaiqiang.shared.controller.BaseController;
import com.xukaiqiang.shared.protocol.OutputMessage;
import com.xukaiqiang.shared.util.Executor;
import com.xukaiqiang.gb.mgt.protocol.WorksCreateRequest;
import com.xukaiqiang.gb.mgt.protocol.WorksListResponse;
import com.xukaiqiang.gb.mgt.protocol.WorksPageResponse;
import com.xukaiqiang.gb.mgt.protocol.WorksResponse;
import com.xukaiqiang.gb.mgt.protocol.WorksUpdateRequest;
import com.xukaiqiang.gb.mgt.service.WorksService;
import com.xukaiqiang.gb.mgt.util.Urls;
import com.xukaiqiang.gb.mgt.util.Views;
import com.xukaiqiang.gb.orm.entity.Works;
import com.xukaiqiang.gb.orm.protocol.WorksFilterRequest;

/**
 * 作品管理控制器
 */
@Controller
public class WorksController extends BaseController {

	private static final String BINDING = "WORKS_BINDING";

	@Autowired
	private WorksService worksService;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private SharedVars appVars;

	/**
	 * 所有进入该控制器的请求都先执行此方法，用于数据二次绑定
	 * 
	 * @param id
	 * @return
	 */
	@ModelAttribute(BINDING)
	public Works getBinding(@RequestParam(value = "id", required = false) Integer id) {
		if (!isBindingRequest()) {
			return new Works();
		}
		return worksService.findWorks(id);
	}

	/**
	 * 作品管理首页
	 * 
	 * @param filter
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Urls.WORKS_INDEX, method = RequestMethod.GET)
	public String index() {
		return Views.WORKS_INDEX;
	}

	/**
	 * 作品首页／首屏数据
	 * 
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.SCRIPT_WORKS, method = RequestMethod.GET)
	public String index(Model model, Locale locale) {
		listPage(null, null, null, locale).addAttributeTo(model);

		return Views.SCRIPT_WORKS;
	}

	/**
	 * 作品列表分页
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param filter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = Urls.WORKS_PAGE, method = RequestMethod.GET)
	@ResponseBody
	public WorksPageResponse listPage(@PathVariable("pageNumber") final Integer pageNumber,
			@RequestParam(value = "pageSize", required = false) final Integer pageSize, final WorksFilterRequest filter, Locale locale) {
		WorksPageResponse pageResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return worksService.findWorksPage(pageNumber, pageSize, filter);
			}
		}, messageSource, null, locale, WorksPageResponse.class);

		if (!pageResponse.isSuccess()) {
			return pageResponse;
		}

		Page<Works> payload = (Page<Works>) pageResponse.getPayload();
		if(payload == null) {
			return pageResponse;
		}

		pageResponse.setPayload(null);
		return WorksPageResponse.buildPageResponse(pageResponse, payload, appVars.displayPages);
	}

	/**
	 * 作品列表
	 * 
	 * @param filter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = Urls.WORKS_LIST, method = RequestMethod.GET)
	@ResponseBody
	public WorksListResponse list(final WorksFilterRequest filter, Locale locale) {
		WorksListResponse listResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return worksService.findWorkss(filter);
			}
		}, messageSource, null, locale, WorksListResponse.class);

		if (!listResponse.isSuccess()) {
			return listResponse;
		}

		List<Works> payload = (List<Works>) listResponse.getPayload();
		if(payload == null) {
			return listResponse;
		}

		listResponse.setPayload(null);
		return WorksListResponse.buildListResponse(listResponse, payload);
	}

	/**
	 * 查看作品
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = Urls.WORKS_VIEW, method = RequestMethod.GET)
	@ResponseBody
	public WorksResponse view(@PathVariable("id") final Integer id, Locale locale) {
		WorksResponse worksResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return worksService.findWorks(id);
			}
		}, messageSource, null, locale, WorksResponse.class);

		if (!worksResponse.isSuccess()) {
			return worksResponse;
		}

		Works payload = (Works) worksResponse.getPayload();
		if(payload == null) {
			return worksResponse;
		}

		worksResponse.setPayload(null);
		return WorksResponse.buildResponse(worksResponse, payload);
	}

	/**
	 * 创建作品
	 * 
	 * @param works
	 * @param result
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.WORKS_CREATE, method = RequestMethod.POST)
	@ResponseBody
	public WorksResponse create(@Valid WorksCreateRequest createRequtest, BindingResult result, final Works works, Locale locale) {
		WorksResponse worksResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return worksService.createWorks(works);
			}
		}, messageSource, result, locale, WorksResponse.class);

		if (!worksResponse.isSuccess()) {
			return worksResponse;
		}

		Works payload = (Works) worksResponse.getPayload();
		if(payload == null) {
			return worksResponse;
		}

		worksResponse.setId(payload.getId());
		worksResponse.setPayload(null);
		return worksResponse;
	}

	/**
	 * 修改作品
	 * 
	 * @param works
	 * @param result
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.WORKS_UPDATE, method = RequestMethod.POST)
	@ResponseBody
	public WorksResponse update(@Valid WorksUpdateRequest updateRequtest, BindingResult result, @ModelAttribute(BINDING) final Works works, Locale locale) {
		WorksResponse worksResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return worksService.updateWorks(works);
			}
		}, messageSource, result, locale, WorksResponse.class);

		if (!worksResponse.isSuccess()) {
			return worksResponse;
		}

		Works payload = (Works) worksResponse.getPayload();
		if(payload == null) {
			return worksResponse;
		}

		worksResponse.setId(payload.getId());
		worksResponse.setPayload(null);
		return worksResponse;
	}

	/**
	 * 删除作品
	 * 
	 * @param id
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.WORKS_REMOVE, method = RequestMethod.POST)
	@ResponseBody
	public OutputMessage remove(@PathVariable("id") final Integer id, Locale locale) {
		return Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				worksService.removeWorks(id);
				return null;
			}
		}, messageSource, null, locale);
	}

}
