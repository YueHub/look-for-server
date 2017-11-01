package cn.lcy.lookfor.dto;

import org.springframework.web.multipart.MultipartFile;

import cn.lcy.lookfor.model.PostRelease;
import cn.lcy.lookfor.model.User;

public class PostReleaseDTO2 {
	
//	private PostRelease postRelease;
	
	
	
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

	
	
}
