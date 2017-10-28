package cn.lcy.lookfor.service;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lcy.lookfor.dao.PostViewRepository;
import cn.lcy.lookfor.model.PostView;
import cn.lcy.lookfor.model.User;

@Service
public class PostViewService {
	
	@Autowired
	private PostViewRepository postViewRepository;
	
	@Transactional
	public PostView addPostView(PostView postView) {
		return this.postViewRepository.save(postView);
	}
	
	public Iterable<PostView> getPostViewsByUserId(User user) {
		return this.postViewRepository.findByUser(user);
	}
	
	public Iterable<PostView> getPostViewsByUserIdAndTime(User user, Timestamp startDate, Timestamp endDate) {
		return this.postViewRepository.findByUserAndViewTimeBetween(user, startDate, endDate);
	}

}
