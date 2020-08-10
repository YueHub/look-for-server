package cn.lcy.lookfor.neo4j.dao;

import cn.lcy.lookfor.neo4j.model.PostForward;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostForwardRepository extends GraphRepository<PostForward> {


}
