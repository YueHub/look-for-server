package cn.lcy.lookfor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lcy.lookfor.model.User;
import cn.lcy.lookfor.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}

	/**
	 * 根据用户 id 更新用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@ResponseBody
	public User updateUser(@RequestBody User user) {
		return this.userService.updateUser(user);
	}
	
	/**
	 * 根据用户 id 获取用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/user/{identifyId}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("identifyId") String identifyId) {
		if (identifyId == null || identifyId.equals("")) {
			return null;
		}
		return this.userService.getUserById(identifyId);
	}
}