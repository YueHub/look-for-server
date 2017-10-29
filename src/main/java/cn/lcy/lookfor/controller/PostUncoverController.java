package cn.lcy.lookfor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lcy.lookfor.model.PostUncover;
import cn.lcy.lookfor.model.User;
import cn.lcy.lookfor.service.PostUncoverService;

@RestController
public class PostUncoverController {

	@Autowired
	private PostUncoverService postUncoverService;
	
	
	@RequestMapping(value = "/postuncover", method = RequestMethod.POST)
	@ResponseBody
	public PostUncover addPostUncover(@RequestBody PostUncover postUncover) {
		return this.postUncoverService.addPostUncover(postUncover);
	}
	
	@RequestMapping(value = "/postuncover", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<PostUncover> getPostUncoversByUserId(@RequestParam(value="userId", required = true) String userId) {
		if (userId == null || userId.equals("")) {
			return null;
		}
		User user = new User();
		user.setIdentifyId(userId);
		return this.postUncoverService.getPostUncovers(user);
	}
	
}
