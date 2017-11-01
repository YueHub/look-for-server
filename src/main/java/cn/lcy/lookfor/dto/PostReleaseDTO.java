package cn.lcy.lookfor.dto;

import org.springframework.web.multipart.MultipartFile;

import cn.lcy.lookfor.model.PostRelease;
import cn.lcy.lookfor.model.User;

public class PostReleaseDTO {
	
//	private PostRelease postRelease;
	
	private User user;
    private String title;
    private String content;
    private String description;
    private String reward;
    private String phone;
    private String email;
    private String selfIntroduce;
	
	
	
	private MultipartFile[] file;

	

//	public PostRelease getPostRelease() {
//		return postRelease;
//	}
//
//	public void setPostRelease(PostRelease postRelease) {
//		this.postRelease = postRelease;
//	}

	public MultipartFile[] getFile() {
		return file;
	}

	public void setFile(MultipartFile[] file) {
		this.file = file;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
//
//	
	
	
}
