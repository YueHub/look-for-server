package cn.lcy.lookfor.controller;

import cn.lcy.lookfor.enums.ErrorEnum;
import cn.lcy.lookfor.model.User;
import cn.lcy.lookfor.service.UserService;
import cn.lcy.lookfor.vo.ErrorMessage;
import cn.lcy.lookfor.vo.ResultVO;
import cn.lcy.lookfor.vo.UserBasicInfo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserController {

    /**
     * 返回的结果
     */
    @Autowired
    private ResultVO resultVO;

    @Autowired
    private UserBasicInfo userBasicInfo;

    /**
     * 返回的异常和错误
     */
    @Autowired
    private ErrorMessage errorMessage;

    @Autowired
    private UserService userService;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    /**
     * 根据用户 id 更新用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public String updateUser(@RequestBody User user) {
        resultVO.setRequestTime(new Date(System.currentTimeMillis()).toString());
        User newUser = this.userService.getUserById(user.getIdentifyId());
        if (newUser == null) {
            errorMessage.setErrorCode(ErrorEnum.DATABASEERROR.getCode());
            errorMessage.setMessage(ErrorEnum.DATABASEERROR.getMessage());
            resultVO.setResult(errorMessage);
        } else {
            newUser.setPhone(user.getPhone());
            newUser.setEmail(user.getEmail());
            newUser.setSelfIntroduction(user.getSelfIntroduction());
            User resultUser = this.userService.updateUser(newUser);
            userBasicInfo.setIdentifyId(resultUser.getIdentifyId());
            userBasicInfo.setSelfIntroduction(resultUser.getSelfIntroduction());
            userBasicInfo.setPhone(resultUser.getPhone());
            userBasicInfo.setEmail(resultUser.getEmail());
            userBasicInfo.setPopularityValue(resultUser.getPopularityValue());
            userBasicInfo.setCreditValue(resultUser.getCreditValue());
            resultVO.setResult(userBasicInfo);
        }

        resultVO.setResponseTime(new Date(System.currentTimeMillis()).toString());
        return JSON.toJSONStringWithDateFormat(resultVO, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 根据用户 id 获取用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{identifyId}", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(@PathVariable("identifyId") String identifyId) {
        resultVO.setRequestTime(new Date(System.currentTimeMillis()).toString());
        if (identifyId == null || identifyId.equals("")) {
            errorMessage.setErrorCode(ErrorEnum.PARAMERROR.getCode());
            errorMessage.setMessage(ErrorEnum.PARAMERROR.getMessage());
            resultVO.setResult(errorMessage);
        } else {
            resultVO.setResult(this.userService.getUserById(identifyId));
        }
        resultVO.setResponseTime(new Date(System.currentTimeMillis()).toString());
        return JSON.toJSONStringWithDateFormat(resultVO, "yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping(value = "/userbasicinfo/{identifyId}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserBasicInfo(@PathVariable("identifyId") String identifyId) {
        resultVO.setRequestTime(new Date(System.currentTimeMillis()).toString());
        if (identifyId == null || identifyId.equals("")) {
            errorMessage.setErrorCode(ErrorEnum.PARAMERROR.getCode());
            errorMessage.setMessage(ErrorEnum.PARAMERROR.getMessage());
            resultVO.setResult(errorMessage);
        } else {
            User resultUser = this.userService.getUserById(identifyId);
            userBasicInfo.setIdentifyId(resultUser.getIdentifyId());
            userBasicInfo.setSelfIntroduction(resultUser.getSelfIntroduction());
            userBasicInfo.setPhone(resultUser.getPhone());
            userBasicInfo.setEmail(resultUser.getEmail());
            userBasicInfo.setPopularityValue(resultUser.getPopularityValue());
            userBasicInfo.setCreditValue(resultUser.getCreditValue());
            resultVO.setResult(userBasicInfo);
        }

        resultVO.setResponseTime(new Date(System.currentTimeMillis()).toString());
        return JSON.toJSONStringWithDateFormat(resultVO, "yyyy-MM-dd HH:mm:ss");
    }


}