package com.xukaiqiang.guitar.mgt.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xukaiqiang.guitar.mgt.protocol.UserResponse;
import com.xukaiqiang.guitar.mgt.service.UserService;
import com.xukaiqiang.guitar.mgt.util.Urls;
import com.xukaiqiang.guitar.orm.entity.User;
import com.xukaiqiang.guitar.orm.protocol.UserFilterRequest;
import com.xukaiqiang.shared.SharedVars;
import com.xukaiqiang.shared.controller.BaseController;
import com.xukaiqiang.shared.util.Executor;

/**
 * 用户管理控制器
 */
@Controller
public class LoginController extends BaseController {

	private static final String BINDING = "USER_BINDING";

	@Autowired
	private UserService userService;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private SharedVars appVars;

	/**
	 * 创建用户
	 * 
	 * @param user
	 * @param result
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = Urls.USER_LOGIN, method = RequestMethod.POST)
	@ResponseBody
	public UserResponse create(@Valid final UserFilterRequest createRequtest, BindingResult result, final User user,
			Locale locale) {
		UserResponse userResponse = Executor.execute(new Executor() {
			@Override
			protected Object execute() {
				return userService.login(createRequtest);
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

}
