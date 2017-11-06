package cn.lcy.lookfor.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class UserBasicInfo {
	
	private String identifyId;
	
	private String selfIntroduction;
	
	private String phone;
	
	private String email;
	
	private String popularityValue;
	
	private String creditValue;
	
	private Date creditTime;
	
	public String getIdentifyId() {
		return identifyId;
	}
	public void setIdentifyId(String identifyId) {
		this.identifyId = identifyId;
	}
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
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
	public String getPopularityValue() {
		return popularityValue;
	}
	public void setPopularityValue(String popularityValue) {
		this.popularityValue = popularityValue;
	}
	public String getCreditValue() {
		return creditValue;
	}
	public void setCreditValue(String creditValue) {
		this.creditValue = creditValue;
	}
	public Date getCreditTime() {
		return creditTime;
	}
	public void setCreditTime(Date creditTime) {
		this.creditTime = creditTime;
	}
}
