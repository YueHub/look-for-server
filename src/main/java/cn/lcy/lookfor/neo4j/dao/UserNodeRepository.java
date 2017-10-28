package cn.lcy.lookfor.neo4j.dao;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import cn.lcy.lookfor.neo4j.model.UserNode;

@Repository
public interface UserNodeRepository extends GraphRepository<UserNode>{
	
	@Query("MATCH p=(:UserNode {postIdentifyId: {postIdentifyId}})->[:ForwardRelationship]->(:UserNode {userIdentifyId: {userIdentifyId}}) RETURN filter(x IN nodes(p) WHERE id(x) <> id(n1) AND id(x) <>id(n4)) AS allNodes")
	public List<UserNode> getUserNodes(String postIdentifyId, String userIdentifyId);

}
