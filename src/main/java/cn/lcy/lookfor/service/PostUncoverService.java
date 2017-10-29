package cn.lcy.lookfor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lcy.lookfor.dao.PostUncoverRepository;
import cn.lcy.lookfor.model.PostUncover;
import cn.lcy.lookfor.model.User;

@Service
public class PostUncoverService {
	
	@Autowired
	private PostUncoverRepository postUncoverRepository;
	
	@Transactional
	public PostUncover addPostUncover(PostUncover postUncover) {
		return this.postUncoverRepository.save(postUncover);
	}

	public Iterable<PostUncover> getPostUncovers(User user) {
		return this.postUncoverRepository.findByUser(user);
	}
}
