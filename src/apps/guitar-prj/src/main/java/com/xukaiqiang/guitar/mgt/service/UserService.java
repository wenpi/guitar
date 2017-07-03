package com.xukaiqiang.guitar.mgt.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.xukaiqiang.guitar.mgt.protocol.UserResponse;
import com.xukaiqiang.guitar.orm.entity.User;
import com.xukaiqiang.guitar.orm.protocol.UserFilterRequest;

public interface UserService {

	/**
	 * 分页筛选用户
	 * 
	 * @param pageNumber
	 * @param pageSize
	 * @param filter
	 * @return
	 */
	Page<User> findUserPage(Integer pageNumber, Integer pageSize, UserFilterRequest filter);

	/**
	 * 筛选用户列表
	 * 
	 * @param filter
	 * @return
	 */
	List<User> findUsers(UserFilterRequest filter);

	/**
	 * 使用唯一标识查询用户对象
	 * 
	 * @param id
	 * @return
	 */
	User findUser(Integer id);

	/**
	 * 新建用户
	 * 
	 * @param user
	 * @return
	 */
	User createUser(User user);

	/**
	 * 修改用户
	 * 
	 * @param user
	 * @return
	 */
	User updateUser(User user);

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	void removeUser(Integer id);

	UserResponse login(UserFilterRequest request);

}
