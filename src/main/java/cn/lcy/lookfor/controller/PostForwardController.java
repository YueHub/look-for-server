package cn.lcy.lookfor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lcy.lookfor.model.User;
import cn.lcy.lookfor.neo4j.model.PostForward;
import cn.lcy.lookfor.service.PostForwardService;
import cn.lcy.lookfor.vo.ForwardParamVO;

@RestController
public class PostForwardController {

	@Autowired
	private PostForwardService postForwardService;
	
	@RequestMapping(value = "/postforward/forward", method = RequestMethod.POST)
	@ResponseBody
	public PostForward addPostForward(@RequestBody ForwardParamVO forwardParamVO) {
		String postId = forwardParamVO.getPostId();
		String startUserId = forwardParamVO.getStartUserId();
		String endUserId = forwardParamVO.getEndUserId();
		return this.postForwardService.addPostForward(postId, startUserId, endUserId);
	}
	
	@RequestMapping(value = "/postforward/{postId}/{startUserId}/{endUserId}", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<User> getUserForwardPath(@PathVariable("postId")  String postId,  
			@PathVariable("startUserId")  String startUserId,
			@PathVariable("endUserId")  String postendUserIdId) {
		return this.postForwardService.getUserForwardPath(postId, startUserId, postendUserIdId);
	}
		
	
}
