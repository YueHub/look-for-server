package cn.lcy.lookfor.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lcy.lookfor.model.PostView;
import cn.lcy.lookfor.model.User;
import cn.lcy.lookfor.service.PostViewService;

@RestController
public class PostViewController {
	
	@Autowired
	private PostViewService postViewService;
	
	
	@RequestMapping(value = "/postview", method = RequestMethod.POST)
	@ResponseBody
	public PostView addPostView(PostView postView) {
		return this.postViewService.addPostView(postView);
	}
	
	@RequestMapping(value = "/postview", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<PostView> getPostViewsByUserId(@RequestParam(value="userId",required = true) String userId,
			@RequestParam(value="startDate", required=true) Timestamp startDate, 
			@RequestParam(value="endDate", required=true) Timestamp endDate) {
		if (userId == null || userId.equals("")) {
			return null;
		}
		User user = new User();
		user.setIdentifyId(userId);
		if (startDate == null || endDate == null || startDate.equals("") || endDate.equals("")) {
			return this.postViewService.getPostViewsByUserId(user);
		}
		return this.postViewService.getPostViewsByUserIdAndTime(user, startDate, endDate);
	}

}
