package cn.lcy.lookfor.controller;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.lcy.lookfor.config.Config;
import cn.lcy.lookfor.enums.ErrorEnum;
import cn.lcy.lookfor.model.PostRelease;
import cn.lcy.lookfor.service.PostReleaseService;
import cn.lcy.lookfor.util.Encrypt;
import cn.lcy.lookfor.util.FileIO;
import cn.lcy.lookfor.vo.ErrorMessage;
import cn.lcy.lookfor.vo.FileUpload;
import cn.lcy.lookfor.vo.PostVO;
import cn.lcy.lookfor.vo.ResultVO;

@RestController
public class PostReleaseController {
	
	/**
	 * 返回的结果
	 */
	@Autowired
	private ResultVO resultVO;
	
	/**
	 * 返回的异常和错误
	 */
	@Autowired
	private ErrorMessage errorMessage;
	
	@Autowired
	private PostReleaseService postReleaseService;
	
	private PostVO postVO;

	private String year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
	
	private String month = String.valueOf(Calendar.getInstance().get(Calendar.MONTH));
	
	private String dayOfMonth = String.valueOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
	
	
	/**
	 * 添加招聘帖子
	 * @param postRelease
	 * @return
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 */
	@RequestMapping(value = "/postrelease", method = RequestMethod.POST)
	@ResponseBody
	public PostRelease addPostRelease(@ModelAttribute PostRelease postRelease, @ModelAttribute("files") FileUpload fileUpload) throws IOException, NoSuchAlgorithmException {
		System.out.println("user: " + postRelease.getUser());
		System.out.println("phone: " + postRelease.getPhone());
		String saveDir = null;	// 存储的位置
		String fileOriginalName = null;	// 原始文件名
		String fileSuffix = null;	// 文件后缀
		String fileHashName = null; // 哈希文件名
		String fileName = null; // 加上后缀文件名
		
		String filePath = null;
		String postImgUrls = "";
		for (int i = 0; i < fileUpload.getFiles().length; i++) {
			saveDir = Config.imgUrl + year + File.separator + month + File.separator + dayOfMonth + File.separator;
			
			fileOriginalName = fileUpload.getFiles()[i].getOriginalFilename();
			String[] array = fileOriginalName.split("\\.");
			fileSuffix = array[array.length-1];
			fileHashName = Encrypt.callMD5(fileOriginalName);
			fileName = fileHashName + "." + fileSuffix;
			
			filePath = saveDir + fileName;
			FileIO.saveImg(fileUpload.getFiles()[0], saveDir, fileName);
			String splitChar = i == fileUpload.getFiles().length - 1 ? "" : ",";
			postImgUrls = filePath + splitChar;
		}
		return this.postReleaseService.addPostRelease(postRelease, postImgUrls);
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
	 * 根据状态获取帖子信息
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/postrelease", method = RequestMethod.GET)
	@ResponseBody
	public String getPostReleasesByStatus(@RequestParam(value="status",required = false) Integer status, 
			@RequestParam(value="startDate",required = false) Timestamp startDate, 
			@RequestParam(value="endDate",required = false) Timestamp endDate) {
		resultVO.setRequestTime(new Date(System.currentTimeMillis()).toString());	// 接受请求的时间
		
		if (status == null || status.equals("")) {
			errorMessage = new ErrorMessage(ErrorEnum.PARAMERROR.getCode(), ErrorEnum.PARAMERROR.getMessage());
			resultVO.setResult(errorMessage);
			resultVO.setResponseTime(new Date(System.currentTimeMillis()).toString());
			return JSON.toJSONStringWithDateFormat(resultVO, "yyyy-MM-dd HH:mm:ss");
		}
		
		// 获取指定状态的所有帖子
		if (startDate == null || endDate == null || startDate.equals("") || endDate.equals("")) {
			List<PostRelease> postReleaseList = this.postReleaseService.getPostReleasesByStatus(status);
			List<PostVO> postList = new ArrayList<PostVO>();
			for (PostRelease postRelease : postReleaseList) {
				postVO = new PostVO(postRelease);
				postList.add(postVO);
			}
			return JSON.toJSONStringWithDateFormat(postList, "yyyy-MM-dd HH:mm:ss");
		}
		
		// 获取指定日期的帖子
		List<PostRelease> postReleaseList = this.postReleaseService.getPostReleasesByTime(startDate, endDate);
		List<PostVO> postList = new ArrayList<PostVO>();
		for (PostRelease postRelease : postReleaseList) {
			postVO = new PostVO(postRelease);
			postList.add(postVO);
		}
		return JSON.toJSONStringWithDateFormat(postList, "yyyy-MM-dd HH:mm:ss");
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
	
}
