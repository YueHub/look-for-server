package cn.lcy.lookfor.model;
// Generated 2017-11-1 14:46:43 by Hibernate Tools 5.0.6.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PostView generated by hbm2java
 */
@Entity
@Table(name = "post_view", catalog = "lookfor")
public class PostView implements java.io.Serializable {

	@Id
	private String identifyId;
	private PostRelease postRelease;
	private User user;
	private Date viewTime;

	public PostView() {
	}

	public PostView(String identifyId, PostRelease postRelease, User user, Date viewTime) {
		this.identifyId = identifyId;
		this.postRelease = postRelease;
		this.user = user;
		this.viewTime = viewTime;
	}

	@Id

	@Column(name = "identify_id", unique = true, nullable = false, length = 10)
	public String getIdentifyId() {
		return this.identifyId;
	}

	public void setIdentifyId(String identifyId) {
		this.identifyId = identifyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "view_post", nullable = false)
	public PostRelease getPostRelease() {
		return this.postRelease;
	}

	public void setPostRelease(PostRelease postRelease) {
		this.postRelease = postRelease;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "view_user", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "view_time", nullable = false, length = 19)
	public Date getViewTime() {
		return this.viewTime;
	}

	public void setViewTime(Date viewTime) {
		this.viewTime = viewTime;
	}

}
