package cn.lcy.lookfor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lcy.lookfor.model.User;
import cn.lcy.lookfor.service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public boolean addUser(@RequestBody User user) {
		return false;
	}
	
	/**
	 * 根据用户 id 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.DELETE)
	@ResponseBody
	public boolean removeUser(@RequestParam(value = "id", required = true) String id) {
		return false;
	}
	
	/**
	 * 根据用户 id 更新用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@ResponseBody
	public boolean updateUser(@RequestParam(value = "id", required = true) String id) {
		return false;
	}
	
	/**
	 * 获取用户列表
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<User> getUsers() {
		return userService.getUsers();
	}
	/**
	 * 根据用户 id 获取用户信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	public User getUser(@RequestParam(value = "id", required = true) String id) {
		return null;
	}
	

	
}