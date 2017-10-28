package cn.lcy.lookfor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.lcy.lookfor.model.PostUncover;
import cn.lcy.lookfor.model.User;

public interface PostUncoverRepository extends JpaRepository<PostUncover, String>{
	
	/**
	 * 根据用户 ID 获取用户的揭榜记录
	 * @param userId
	 * @return
	 */
	public Iterable<PostUncover> findByUser(User user);
}
