package com.mike.resume.web;

import com.alibaba.fastjson.JSON;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.SUser;
import com.mike.resume.service.impl.SUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SUserController {

    @Autowired
    private SUserServiceImpl sUserService;


}