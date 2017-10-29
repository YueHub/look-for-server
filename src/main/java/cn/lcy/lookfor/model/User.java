package cn.lcy.lookfor.model;
// Generated 2017-10-28 21:22:06 by Hibernate Tools 5.0.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "lookfor")
public class User implements java.io.Serializable {

	private String identifyId;
	private String selfIntroduction;
	private String popularityValue;
	private String creditValue;
	private Date creditTime;
	private Set<PostView> postViews = new HashSet<PostView>(0);
	private Set<PostUncover> postUncovers = new HashSet<PostUncover>(0);
	private Set<PostRelease> postReleases = new HashSet<PostRelease>(0);

	public User() {
	}

	public User(String identifyId, Date creditTime) {
		this.identifyId = identifyId;
		this.creditTime = creditTime;
	}

	public User(String identifyId, String selfIntroduction, String popularityValue, String creditValue, Date creditTime,
			Set<PostView> postViews, Set<PostUncover> postUncovers, Set<PostRelease> postReleases) {
		this.identifyId = identifyId;
		this.selfIntroduction = selfIntroduction;
		this.popularityValue = popularityValue;
		this.creditValue = creditValue;
		this.creditTime = creditTime;
		this.postViews = postViews;
		this.postUncovers = postUncovers;
		this.postReleases = postReleases;
	}

	@Id

	@Column(name = "identify_id", unique = true, nullable = false, length = 10)
	public String getIdentifyId() {
		return this.identifyId;
	}

	public void setIdentifyId(String identifyId) {
		this.identifyId = identifyId;
	}

	@Column(name = "self_introduction", length = 100)
	public String getSelfIntroduction() {
		return this.selfIntroduction;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	@Column(name = "popularity_value", length = 8)
	public String getPopularityValue() {
		return this.popularityValue;
	}

	public void setPopularityValue(String popularityValue) {
		this.popularityValue = popularityValue;
	}

	@Column(name = "credit_value", length = 8)
	public String getCreditValue() {
		return this.creditValue;
	}

	public void setCreditValue(String creditValue) {
		this.creditValue = creditValue;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "credit_time", nullable = false, length = 19)
	public Date getCreditTime() {
		return this.creditTime;
	}

	public void setCreditTime(Date creditTime) {
		this.creditTime = creditTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<PostView> getPostViews() {
		return this.postViews;
	}

	public void setPostViews(Set<PostView> postViews) {
		this.postViews = postViews;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<PostUncover> getPostUncovers() {
		return this.postUncovers;
	}

	public void setPostUncovers(Set<PostUncover> postUncovers) {
		this.postUncovers = postUncovers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<PostRelease> getPostReleases() {
		return this.postReleases;
	}

	public void setPostReleases(Set<PostRelease> postReleases) {
		this.postReleases = postReleases;
	}

}