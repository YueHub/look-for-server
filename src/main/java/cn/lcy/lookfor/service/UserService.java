package cn.lcy.lookfor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lcy.lookfor.dao.UserRepository;
import cn.lcy.lookfor.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 获取所有的用户列表
	 * @return
	 */
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}

}
