package cn.lcy.lookfor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lcy.lookfor.model.User;
import cn.lcy.lookfor.neo4j.model.PostForward;
import cn.lcy.lookfor.service.PostForwardService;

@RestController
public class PostForwardController {

	@Autowired
	private PostForwardService postForwardService;
	
	@RequestMapping(value = "/postforward/forward", method = RequestMethod.POST)
	@ResponseBody
	public PostForward addRootUserNode(@RequestParam(value = "postId", required = true) String postId,  
            @RequestParam(value = "startUserId", required = true) String startUserId,
            @RequestParam(value = "endUserId", required = true) String endUserId) {
		return this.postForwardService.addPostForward(postId, startUserId, endUserId);
	}
	
	
	@RequestMapping(value = "/postforward", method = RequestMethod.GET)
	public Iterable<User> getUserForwardPath(@PathVariable("postId")  String postId,  
			@PathVariable("startUserId")  String startUserId, 
			@PathVariable("endUserId")  String postendUserIdId) {
		return this.postForwardService.getUserForwardPath(postId, startUserId, postendUserIdId);
	}
		
	
}
