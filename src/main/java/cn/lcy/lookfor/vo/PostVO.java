package cn.lcy.lookfor.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

import cn.lcy.lookfor.model.PostRelease;

public class PostVO {
	
	/**
	 * 帖子 ID
	 */
	private String identifyId;
	
	/**
	 * 发帖者 ID
	 */
	private String releaseUserId;
	
	// TODO 发帖者其他信息

	/**
	 * 发布时间
	 */
	private Date releaseTime;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 需求描述
	 */
	private String description;
	
	/**
	 * 奖金
	 */
	private String reward;
	
	/**
	 * 联系电话
	 */
	private String phone;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 自我介绍
	 */
	private String selfIntroduce;
	
	/**
	 * 帖子图片
	 */
	private String postImgUrls;
	
	/**
	 * 浏览次数
	 */
	private Long viewCount;
	
	/**
	 * 揭榜次数
	 */
	private Long uncoverCount;
	
	/**
	 * 中标次数
	 */
	private Long successCount;
	
	/**
	 * 已支付奖金
	 */
	private String paidReward;
	
	/**
	 * 帖子状态 
	 */
	private Integer status;
	
	public PostVO(PostRelease postRelease) {
		this.identifyId = postRelease.getIdentifyId();
		this.releaseUserId = postRelease.getUser().getIdentifyId();
		this.releaseTime = postRelease.getReleaseTime();
		this.title = postRelease.getTitle();
		this.content = postRelease.getContent();
		this.description = postRelease.getDescription();
		this.reward = postRelease.getReward();
		this.phone = postRelease.getPhone();
		this.email = postRelease.getEmail();
		this.selfIntroduce = postRelease.getSelfIntroduce();
		this.postImgUrls = postRelease.getPostImgUrls();
		this.viewCount = postRelease.getViewCount();
		this.uncoverCount = postRelease.getUncoverCount();
		this.successCount = postRelease.getSuccessCount();
		this.paidReward = postRelease.getPaidReward();
		this.status = postRelease.getStatus();
	}

	public String getIdentifyId() {
		return identifyId;
	}

	public void setIdentifyId(String identifyId) {
		this.identifyId = identifyId;
	}

	public String getReleaseUserId() {
		return releaseUserId;
	}

	public void setReleaseUserId(String releaseUserId) {
		this.releaseUserId = releaseUserId;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSelfIntroduce() {
		return selfIntroduce;
	}

	public void setSelfIntroduce(String selfIntroduce) {
		this.selfIntroduce = selfIntroduce;
	}

	public String getPostImgUrls() {
		return postImgUrls;
	}

	public void setPostImgUrls(String postImgUrls) {
		this.postImgUrls = postImgUrls;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	public Long getUncoverCount() {
		return uncoverCount;
	}

	public void setUncoverCount(Long uncoverCount) {
		this.uncoverCount = uncoverCount;
	}

	public Long getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(Long successCount) {
		this.successCount = successCount;
	}

	public String getPaidReward() {
		return paidReward;
	}

	public void setPaidReward(String paidReward) {
		this.paidReward = paidReward;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
