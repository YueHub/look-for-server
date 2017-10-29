package cn.lcy.lookfor.neo4j.dao;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import cn.lcy.lookfor.neo4j.model.PostForward;

@Repository
public interface PostForwardRepository extends GraphRepository<PostForward> {
	
	
}
