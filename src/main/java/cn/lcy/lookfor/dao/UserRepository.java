package cn.lcy.lookfor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.lcy.lookfor.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	
}
