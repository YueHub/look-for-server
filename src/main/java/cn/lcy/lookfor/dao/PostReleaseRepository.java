package cn.lcy.lookfor.dao;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.lcy.lookfor.model.PostRelease;

public interface PostReleaseRepository extends JpaRepository<PostRelease, String>{
	
	/**
	 * 根据指定状态获取招聘帖子
	 * @return
	 */
	public Iterable<PostRelease> findByStatus(int status);
	
	/**
	 * 查找一定时间范围内的帖子
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Iterable<PostRelease> findByReleaseTimeBetween(Timestamp startDate, Timestamp endDate);
	
	
	
}
