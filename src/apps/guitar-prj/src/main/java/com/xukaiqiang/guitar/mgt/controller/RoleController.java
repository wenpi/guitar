package com.xukaiqiang.guitar.mgt.controller;

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
import com.xukaiqiang.guitar.mgt.protocol.RoleCreateRequest;
import com.xukaiqiang.guitar.mgt.protocol.RoleListResponse;
import com.xukaiqiang.guitar.mgt.protocol.RolePageResponse;
import com.xukaiqiang.guitar.mgt.protocol.RoleResponse;
import com.xukaiqiang.guitar.mgt.protocol.RoleUpdateRequest;
import com.xukaiqiang.guitar.mgt.service.RoleService;
import com.xukaiqiang.guitar.mgt.util.Urls;
import com.xukaiqiang.guitar.mgt.util.Views;
import com.xukaiqiang.guitar.orm.entity.Role;
import com.xukaiqiang.guitar.orm.protocol.RoleFilterRequest;

/**
 * 角色管理控制器
 */
@Controller
public class RoleController extends BaseController {

	private static final String BINDING = "ROLE_BINDING";

	@Autowired
	private RoleService roleService;
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
	public Role getBinding(@RequestParam(value = "id", required = false) Integer id) {
		if (!isBindingRequest()) {
			return new Role();
		}
		return roleService.findRole(id);
	}

	/**
	 * 角色管理首页
	 * 
	 * @param filter
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Urls.ROLE_INDEX, method = RequestMethod.GET)
	public String index() {
		return Views.ROLE_INDEX;
	}

	/**
	 * 角色首页／首屏数据
	 * 
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.SCRIPT_ROLE, method = RequestMethod.GET)
	public String index(Model model, Locale locale) {
		listPage(null, null, null, locale).addAttributeTo(model);

		return Views.SCRIPT_ROLE;
	}

	/**
	 * 角色列表分页
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param filter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = Urls.ROLE_PAGE, method = RequestMethod.GET)
	@ResponseBody
	public RolePageResponse listPage(@PathVariable("pageNumber") final Integer pageNumber,
			@RequestParam(value = "pageSize", required = false) final Integer pageSize, final RoleFilterRequest filter, Locale locale) {
		RolePageResponse pageResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return roleService.findRolePage(pageNumber, pageSize, filter);
			}
		}, messageSource, null, locale, RolePageResponse.class);

		if (!pageResponse.isSuccess()) {
			return pageResponse;
		}

		Page<Role> payload = (Page<Role>) pageResponse.getPayload();
		if(payload == null) {
			return pageResponse;
		}

		pageResponse.setPayload(null);
		return RolePageResponse.buildPageResponse(pageResponse, payload, appVars.displayPages);
	}

	/**
	 * 角色列表
	 * 
	 * @param filter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = Urls.ROLE_LIST, method = RequestMethod.GET)
	@ResponseBody
	public RoleListResponse list(final RoleFilterRequest filter, Locale locale) {
		RoleListResponse listResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return roleService.findRoles(filter);
			}
		}, messageSource, null, locale, RoleListResponse.class);

		if (!listResponse.isSuccess()) {
			return listResponse;
		}

		List<Role> payload = (List<Role>) listResponse.getPayload();
		if(payload == null) {
			return listResponse;
		}

		listResponse.setPayload(null);
		return RoleListResponse.buildListResponse(listResponse, payload);
	}

	/**
	 * 查看角色
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = Urls.ROLE_VIEW, method = RequestMethod.GET)
	@ResponseBody
	public RoleResponse view(@PathVariable("id") final Integer id, Locale locale) {
		RoleResponse roleResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return roleService.findRole(id);
			}
		}, messageSource, null, locale, RoleResponse.class);

		if (!roleResponse.isSuccess()) {
			return roleResponse;
		}

		Role payload = (Role) roleResponse.getPayload();
		if(payload == null) {
			return roleResponse;
		}

		roleResponse.setPayload(null);
		return RoleResponse.buildResponse(roleResponse, payload);
	}

	/**
	 * 创建角色
	 * 
	 * @param role
	 * @param result
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.ROLE_CREATE, method = RequestMethod.POST)
	@ResponseBody
	public RoleResponse create(@Valid RoleCreateRequest createRequtest, BindingResult result, final Role role, Locale locale) {
		RoleResponse roleResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return roleService.createRole(role);
			}
		}, messageSource, result, locale, RoleResponse.class);

		if (!roleResponse.isSuccess()) {
			return roleResponse;
		}

		Role payload = (Role) roleResponse.getPayload();
		if(payload == null) {
			return roleResponse;
		}

		roleResponse.setId(payload.getId());
		roleResponse.setPayload(null);
		return roleResponse;
	}

	/**
	 * 修改角色
	 * 
	 * @param role
	 * @param result
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.ROLE_UPDATE, method = RequestMethod.POST)
	@ResponseBody
	public RoleResponse update(@Valid RoleUpdateRequest updateRequtest, BindingResult result, @ModelAttribute(BINDING) final Role role, Locale locale) {
		RoleResponse roleResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return roleService.updateRole(role);
			}
		}, messageSource, result, locale, RoleResponse.class);

		if (!roleResponse.isSuccess()) {
			return roleResponse;
		}

		Role payload = (Role) roleResponse.getPayload();
		if(payload == null) {
			return roleResponse;
		}

		roleResponse.setId(payload.getId());
		roleResponse.setPayload(null);
		return roleResponse;
	}

	/**
	 * 删除角色
	 * 
	 * @param id
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.ROLE_REMOVE, method = RequestMethod.POST)
	@ResponseBody
	public OutputMessage remove(@PathVariable("id") final Integer id, Locale locale) {
		return Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				roleService.removeRole(id);
				return null;
			}
		}, messageSource, null, locale);
	}

}