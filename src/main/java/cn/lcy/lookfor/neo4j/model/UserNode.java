package cn.lcy.lookfor.neo4j.model;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class UserNode {

	@GraphId
	private Long id;
	
	@Property(name="postIdentifyId")
	private String postIdentifyId;
	
	@Property(name="userIdentifyId")
	private String userIdentifyId;
	
	public UserNode() {}
	
	public UserNode(String userIdentifyId) {
		this.userIdentifyId = userIdentifyId;
	}
	
	@Relationship(type = "forward", direction=Relationship.OUTGOING)
	private List<ForwardRelationship> forwards;
	
}
