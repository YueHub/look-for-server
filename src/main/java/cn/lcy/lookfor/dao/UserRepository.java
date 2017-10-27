package cn.lcy.lookfor.dao;

import org.springframework.data.repository.CrudRepository;

import cn.lcy.lookfor.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
}
