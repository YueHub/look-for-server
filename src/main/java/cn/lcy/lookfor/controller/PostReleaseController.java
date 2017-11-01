package cn.lcy.lookfor.controller;

import java.io.IOException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lcy.lookfor.dto.PostReleaseDTO2;
import cn.lcy.lookfor.model.PostRelease;
import cn.lcy.lookfor.service.PostReleaseService;

@RestController
public class PostReleaseController {
	
	@Autowired
	private PostReleaseService postReleaseService;

	
	/**
	 * 添加
	 * @param postRelease
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/postrelease", method = RequestMethod.POST)
	@ResponseBody
	public PostRelease addPostRelease(@ModelAttribute("postRelease") PostRelease postRelease, @ModelAttribute("file") PostReleaseDTO2 postReleaseDTO2) throws IOException {
		System.out.println("###################################\n" + postRelease.getPhone());
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" + postReleaseDTO2.getFile().length);
//		byte[] bytes = null;
//		try {
//			bytes = postReleaseDTO.getImgs().getBytes();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		};
//        Path path = Paths.get("/upload" + postReleaseDTO.getImgs()[0].getOriginalFilename());
//        Files.write(path, bytes);
//		return this.postReleaseService.addPostRelease(postReleaseDTO.getPostRelease());
		return null;
	}
	
	/**
	 * 更新帖子
	 * @param postRelease
	 * @return
	 */
	@RequestMapping(value = "/postrelease", method = RequestMethod.PUT)
	@ResponseBody
	public PostRelease updatePostRelease(PostRelease postRelease) {
		return this.postReleaseService.updatePostRelease(postRelease);
	}
	
	/**
	 * 根据帖子 ID 获取帖子信息
	 * @param identifyId
	 * @return
	 */
	@RequestMapping(value = "/postrelease/{ identifyId }", method = RequestMethod.GET)
	@ResponseBody
	public PostRelease getPostReleaseById(@PathVariable("identifyId") String identifyId) {
		if (identifyId == null || identifyId.equals("")) {
			return null;
		}
		return this.postReleaseService.getPostReleaseById(identifyId);
	}
	
	/**
	 * 根据状态获取帖子信息
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/postrelease", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<PostRelease> getPostReleasesByStatus(@RequestParam(value="status",required = false) Integer status, 
			@RequestParam(value="startDate",required = false) Timestamp startDate, 
			@RequestParam(value="endDate",required = false) Timestamp endDate) {
		if (status == null || status.equals("")) {
			return null;
		}
		if (startDate == null || endDate == null || startDate.equals("") || endDate.equals("")) {
			return this.postReleaseService.getPostReleasesByStatus(status);
		}
		return this.postReleaseService.getPostReleasesByTime(startDate, endDate); 
	}	
	
}
