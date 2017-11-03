package cn.lcy.lookfor.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	public List<PostView> getPostViewsByUserId(User user) {
		return this.postViewRepository.findByUser(user);
	}
	
	public List<PostView> getPostViewsByUserIdAndTime(User user, Timestamp startDate, Timestamp endDate) {
		return this.postViewRepository.findByUserAndViewTimeBetween(user, startDate, endDate);
	}

}
