package cn.lcy.lookfor.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.lcy.lookfor.dao.PostReleaseRepository;
import cn.lcy.lookfor.model.PostRelease;

@Service
public class PostReleaseService {
	
	@Autowired
	private PostReleaseRepository postReleaseRepository;
	
	@Transactional
	public PostRelease addPostRelease(PostRelease postRelease) {
		// 添加 identifyId、releaseTime
		
		postRelease.setIdentifyId("12332425");
		return this.postReleaseRepository.save(postRelease);
	}
	
	@Transactional
	public PostRelease updatePostRelease(PostRelease postRelease) {
		return this.postReleaseRepository.save(postRelease);
	}
	
	
	public PostRelease getPostReleaseById(String identifyId) {
		return this.postReleaseRepository.findOne(identifyId);
	}
	
	
	public Iterable<PostRelease> getPostReleasesByStatus(int status) {
		return this.postReleaseRepository.findByStatus(status);
	}

	
	public Iterable<PostRelease> getPostReleasesByTime(Timestamp startDate, Timestamp endDate) {
		return this.postReleaseRepository.findByReleaseTimeBetween(startDate, endDate);
	}
}
