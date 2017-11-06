package cn.lcy.lookfor.model;
// Generated 2017-11-6 22:30:05 by Hibernate Tools 5.0.6.Final

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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * PostUncover generated by hbm2java
 */
@Entity
@Table(name = "post_uncover", catalog = "lookfor")
@JsonIdentityInfo(generator=ObjectIdGenerators.StringIdGenerator.class, property="@id")
public class PostUncover implements java.io.Serializable {

	private String identifyId;
	private PostRelease postRelease;
	private User user;
	private Date uncoverTime;
	private String uncoverReason;

	public PostUncover() {
	}

	public PostUncover(String identifyId, PostRelease postRelease, User user, Date uncoverTime) {
		this.identifyId = identifyId;
		this.postRelease = postRelease;
		this.user = user;
		this.uncoverTime = uncoverTime;
	}

	public PostUncover(String identifyId, PostRelease postRelease, User user, Date uncoverTime, String uncoverReason) {
		this.identifyId = identifyId;
		this.postRelease = postRelease;
		this.user = user;
		this.uncoverTime = uncoverTime;
		this.uncoverReason = uncoverReason;
	}

	@Id

	@Column(name = "identify_id", unique = true, nullable = false, length = 32)
	public String getIdentifyId() {
		return this.identifyId;
	}

	public void setIdentifyId(String identifyId) {
		this.identifyId = identifyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uncover_post", nullable = false)
	public PostRelease getPostRelease() {
		return this.postRelease;
	}

	public void setPostRelease(PostRelease postRelease) {
		this.postRelease = postRelease;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uncover_user", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "uncover_time", nullable = false, length = 19)
	public Date getUncoverTime() {
		return this.uncoverTime;
	}

	public void setUncoverTime(Date uncoverTime) {
		this.uncoverTime = uncoverTime;
	}

	@Column(name = "uncover_reason", length = 100)
	public String getUncoverReason() {
		return this.uncoverReason;
	}

	public void setUncoverReason(String uncoverReason) {
		this.uncoverReason = uncoverReason;
	}

}
