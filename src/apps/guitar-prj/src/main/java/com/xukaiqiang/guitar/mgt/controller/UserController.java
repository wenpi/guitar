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

import com.xukaiqiang.guitar.mgt.protocol.UserCreateRequest;
import com.xukaiqiang.guitar.mgt.protocol.UserListResponse;
import com.xukaiqiang.guitar.mgt.protocol.UserPageResponse;
import com.xukaiqiang.guitar.mgt.protocol.UserResponse;
import com.xukaiqiang.guitar.mgt.protocol.UserUpdateRequest;
import com.xukaiqiang.guitar.mgt.service.UserService;
import com.xukaiqiang.guitar.mgt.util.Urls;
import com.xukaiqiang.guitar.mgt.util.Views;
import com.xukaiqiang.guitar.orm.entity.User;
import com.xukaiqiang.guitar.orm.protocol.UserFilterRequest;
import com.xukaiqiang.shared.SharedVars;
import com.xukaiqiang.shared.controller.BaseController;
import com.xukaiqiang.shared.protocol.OutputMessage;
import com.xukaiqiang.shared.util.Executor;

/**
 * 用户管理控制器
 */
@Controller
public class UserController extends BaseController {

	private static final String BINDING = "USER_BINDING";

	@Autowired
	private UserService userService;
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
	public User getBinding(@RequestParam(value = "id", required = false) Integer id) {
		if (!isBindingRequest()) {
			return new User();
		}
		return userService.findUser(id);
	}

	/**
	 * 用户管理首页
	 * 
	 * @param filter
	 * @param model
	 * @return
	 */
	@RequestMapping(value = Urls.USER_INDEX, method = RequestMethod.GET)
	public String index() {
		return Views.USER_INDEX;
	}

	/**
	 * 用户首页／首屏数据
	 * 
	 * @param model
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.SCRIPT_USER, method = RequestMethod.GET)
	public String index(Model model, Locale locale) {
		listPage(null, null, null, locale).addAttributeTo(model);

		return Views.SCRIPT_USER;
	}

	/**
	 * 用户列表分页
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param filter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = Urls.USER_PAGE, method = RequestMethod.GET)
	@ResponseBody
	public UserPageResponse listPage(@PathVariable("pageNumber") final Integer pageNumber,
			@RequestParam(value = "pageSize", required = false) final Integer pageSize, final UserFilterRequest filter,
			Locale locale) {
		UserPageResponse pageResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return userService.findUserPage(pageNumber, pageSize, filter);
			}
		}, messageSource, null, locale, UserPageResponse.class);

		if (!pageResponse.isSuccess()) {
			return pageResponse;
		}

		Page<User> payload = (Page<User>) pageResponse.getPayload();
		if (payload == null) {
			return pageResponse;
		}

		pageResponse.setPayload(null);
		return UserPageResponse.buildPageResponse(pageResponse, payload, appVars.displayPages);
	}

	/**
	 * 用户列表
	 * 
	 * @param filter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = Urls.USER_LIST, method = RequestMethod.GET)
	@ResponseBody
	public UserListResponse list(final UserFilterRequest filter, Locale locale) {
		UserListResponse listResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return userService.findUsers(filter);
			}
		}, messageSource, null, locale, UserListResponse.class);

		if (!listResponse.isSuccess()) {
			return listResponse;
		}

		List<User> payload = (List<User>) listResponse.getPayload();
		if (payload == null) {
			return listResponse;
		}

		listResponse.setPayload(null);
		return UserListResponse.buildListResponse(listResponse, payload);
	}

	/**
	 * 查看用户
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = Urls.USER_VIEW, method = RequestMethod.GET)
	@ResponseBody
	public UserResponse view(@PathVariable("id") final Integer id, Locale locale) {
		UserResponse userResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return userService.findUser(id);
			}
		}, messageSource, null, locale, UserResponse.class);

		if (!userResponse.isSuccess()) {
			return userResponse;
		}

		User payload = (User) userResponse.getPayload();
		if (payload == null) {
			return userResponse;
		}

		userResponse.setPayload(null);
		return UserResponse.buildResponse(userResponse, payload);
	}

	/**
	 * 创建用户
	 * 
	 * @param user
	 * @param result
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.USER_CREATE, method = RequestMethod.POST)
	@ResponseBody
	public UserResponse create(@Valid UserCreateRequest createRequtest, BindingResult result, final User user,
			Locale locale) {
		UserResponse userResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return userService.createUser(user);
			}
		}, messageSource, result, locale, UserResponse.class);

		if (!userResponse.isSuccess()) {
			return userResponse;
		}

		User payload = (User) userResponse.getPayload();
		if (payload == null) {
			return userResponse;
		}

		userResponse.setId(payload.getId());
		userResponse.setPayload(null);
		return userResponse;
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @param result
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.USER_UPDATE, method = RequestMethod.POST)
	@ResponseBody
	public UserResponse update(@Valid UserUpdateRequest updateRequtest, BindingResult result,
			@ModelAttribute(BINDING) final User user, Locale locale) {
		UserResponse userResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return userService.updateUser(user);
			}
		}, messageSource, result, locale, UserResponse.class);

		if (!userResponse.isSuccess()) {
			return userResponse;
		}

		User payload = (User) userResponse.getPayload();
		if (payload == null) {
			return userResponse;
		}

		userResponse.setId(payload.getId());
		userResponse.setPayload(null);
		return userResponse;
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.USER_REMOVE, method = RequestMethod.POST)
	@ResponseBody
	public OutputMessage remove(@PathVariable("id") final Integer id, Locale locale) {
		return Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				userService.removeUser(id);
				return null;
			}
		}, messageSource, null, locale);
	}

}
