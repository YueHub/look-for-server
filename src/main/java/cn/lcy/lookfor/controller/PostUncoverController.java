package cn.lcy.lookfor.controller;

import cn.lcy.lookfor.enums.ErrorEnum;
import cn.lcy.lookfor.model.PostRelease;
import cn.lcy.lookfor.model.PostUncover;
import cn.lcy.lookfor.model.User;
import cn.lcy.lookfor.service.PostReleaseService;
import cn.lcy.lookfor.service.PostUncoverService;
import cn.lcy.lookfor.vo.ErrorMessage;
import cn.lcy.lookfor.vo.ResultVO;
import cn.lcy.lookfor.vo.SuccessMessage;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class PostUncoverController {

    /**
     * 返回的结果
     */
    @Autowired
    private ResultVO resultVO;

    @Autowired
    private SuccessMessage successMessage;

    /**
     * 返回的异常和错误
     */
    @Autowired
    private ErrorMessage errorMessage;

    @Autowired
    private PostUncoverService postUncoverService;

    @Autowired
    private PostReleaseService postReleaseService;


    @RequestMapping(value = "/postuncover", method = RequestMethod.POST)
    @ResponseBody
    public String addPostUncover(@RequestBody PostUncover postUncover) {
        System.out.println(postUncover.getUncoverReason());
        resultVO.setRequestTime(new Date(System.currentTimeMillis()).toString());
        PostUncover postUncoverRet = this.postUncoverService.addPostUncover(postUncover);
        System.out.println(postUncoverRet.getUncoverTime());
        if (postUncoverRet == null) {
            errorMessage.setErrorCode(ErrorEnum.DATABASEERROR.getCode());
            errorMessage.setMessage(ErrorEnum.DATABASEERROR.getMessage());
            resultVO.setResult(errorMessage);
        } else {
            // 更新帖子状态
            PostRelease postRelease = postReleaseService.getPostReleaseById(postUncover.getPostRelease().getIdentifyId());
            postRelease.setStatus(2);
            postReleaseService.updatePostRelease(postRelease);

            successMessage.setCode(200);
            successMessage.setMessage("揭榜成功");
            successMessage.setData(postUncoverRet);
            resultVO.setResult(successMessage);
            resultVO.setResponseTime(new Date(System.currentTimeMillis()).toString());
        }

        return JSON.toJSONStringWithDateFormat(resultVO, "yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping(value = "/postuncover", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<PostUncover> getPostUncoversByUserId(@RequestParam(value = "userId", required = true) String userId) {
        if (userId == null || userId.equals("")) {
            return null;
        }
        User user = new User();
        user.setIdentifyId(userId);
        return this.postUncoverService.getPostUncovers(user);
    }

}
