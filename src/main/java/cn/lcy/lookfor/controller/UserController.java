package cn.lcy.lookfor.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.lcy.lookfor.enums.ErrorEnum;
import cn.lcy.lookfor.model.User;
import cn.lcy.lookfor.service.UserService;
import cn.lcy.lookfor.vo.ErrorMessage;
import cn.lcy.lookfor.vo.ResultVO;

@RestController
public class UserController {
	
	/**
	 * 返回的结果
	 */
	@Autowired
	private ResultVO resultVO;
	
	/**
	 * 返回的异常和错误
	 */
	@Autowired
	private ErrorMessage errorMessage;
	
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
	public String getUser(@PathVariable("identifyId") String identifyId) {
		resultVO.setRequestTime(new Date(System.currentTimeMillis()).toString());
		if (identifyId == null || identifyId.equals("")) {
			errorMessage.setErrorCode(ErrorEnum.PARAMERROR.getCode());
			errorMessage.setMessage(ErrorEnum.PARAMERROR.getMessage());
			resultVO.setResult(errorMessage);
		} else {
			resultVO.setResult(this.userService.getUserById(identifyId));
		}
		resultVO.setResponseTime(new Date(System.currentTimeMillis()).toString());
		return JSON.toJSONStringWithDateFormat(resultVO, "yyyy-MM-dd HH:mm:ss");
	}
}