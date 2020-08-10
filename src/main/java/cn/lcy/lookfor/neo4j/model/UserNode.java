package cn.lcy.lookfor.neo4j.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class UserNode {

    @GraphId
    private Long id;

    @Property(name = "postIdentifyId")
    private String postIdentifyId;

    @Property(name = "userIdentifyId")
    private String userIdentifyId;

    public UserNode() {
    }

    public UserNode(String postIdentifyId, String userIdentifyId) {
        this.postIdentifyId = postIdentifyId;
        this.userIdentifyId = userIdentifyId;
    }

    @Relationship(type = "forward", direction = Relationship.OUTGOING)
    private List<PostForward> forwards;

    public String getPostIdentifyId() {
        return postIdentifyId;
    }

    public void setPostIdentifyId(String postIdentifyId) {
        this.postIdentifyId = postIdentifyId;
    }

    public String getUserIdentifyId() {
        return userIdentifyId;
    }

    public void setUserIdentifyId(String userIdentifyId) {
        this.userIdentifyId = userIdentifyId;
    }
}
