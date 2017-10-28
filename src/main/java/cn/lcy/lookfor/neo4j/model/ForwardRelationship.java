package cn.lcy.lookfor.neo4j.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "forward")
public class ForwardRelationship {

	@GraphId
	private Long id;
	
	@StartNode
	private UserNode startUser;
	
	@EndNode
	private UserNode endUser;
	
	public ForwardRelationship(UserNode startUser, UserNode endUser) {
		this.startUser = startUser;
		this.endUser = endUser;
	}
	
}
