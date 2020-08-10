package cn.lcy.lookfor.neo4j.dao;

import cn.lcy.lookfor.neo4j.model.UserNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNodeRepository extends GraphRepository<UserNode> {


    public UserNode findByPostIdentifyIdAndUserIdentifyId(String postIdentifyId, String userIdentifyId);

    @Query("MATCH p=(start)-[r:forward*]->(end) WHERE start.postIdentifyId={ postIdentifyId } AND start.userIdentifyId={ startUserIdentifyId } AND end.postIdentifyId={ postIdentifyId } AND end.userIdentifyId={ endUserIdentifyId } RETURN nodes(p)")
    public List<UserNode> getUserNodes(@Param("postIdentifyId") String postIdentifyId,
                                       @Param("startUserIdentifyId") String startUserIdentifyId,
                                       @Param("endUserIdentifyId") String endUserIdentifyId);

}
