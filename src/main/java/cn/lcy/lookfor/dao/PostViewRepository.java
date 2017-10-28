package cn.lcy.lookfor.dao;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.lcy.lookfor.model.PostView;
import cn.lcy.lookfor.model.User;

public interface PostViewRepository extends JpaRepository<PostView, String>{
	
	/**
	 * 根据用户 ID 获取用户浏览的帖子
	 * @param userIdentifyId
	 * @return
	 */
	public Iterable<PostView> findByUser(User user);
	
	/**
	 * 根据用户 ID 和指定时间获取用户浏览的帖子
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Iterable<PostView> findByUserAndViewTimeBetween(User user, Timestamp startDate, Timestamp endDate);
	
}
