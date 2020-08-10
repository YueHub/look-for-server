package cn.lcy.lookfor.dao;

import cn.lcy.lookfor.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {


}
