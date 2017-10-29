package cn.lcy.lookfor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lcy.lookfor.neo4j.model.UserNode;
import cn.lcy.lookfor.service.UserNodeService;

@RestController
public class UserNodeController {
	
	@Autowired
	private UserNodeService userNodeService;
	
	@RequestMapping(value = "/postforward/root", method = RequestMethod.POST)
	@ResponseBody
	public UserNode addRootUserNode(@RequestParam(value = "postId", required = true) String postId,  
            @RequestParam(value = "userId", required = true) String userId) {
		return this.userNodeService.addRootUserNode(postId, userId);
	}
	
}