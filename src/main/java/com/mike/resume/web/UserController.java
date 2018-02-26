package com.mike.resume.web;

import com.alibaba.fastjson.JSON;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.SUser;
import com.mike.resume.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/getUserByOpenId")
    public String getUser(Integer openId) {
        ResponseResult<SUser> userResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(openId)) {
            userResponseResult = userService.selByIdSUser(openId);
        } else {
            userResponseResult.setCode(false);
            userResponseResult.setMsg("参数不能为空");
        }
        return JSON.toJSONString(userResponseResult);
    }

    @RequestMapping("/saveUser")
    public String getUser(SUser sUser) {
        ResponseResult<SUser> userResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(sUser)) {
            userResponseResult = userService.saveSUser(sUser);
        } else {
            userResponseResult.setCode(false);
            userResponseResult.setMsg("参数不能为空");
        }
        return JSON.toJSONString(userResponseResult);
    }

}