package com.mike.resume.web;

import com.alibaba.fastjson.JSON;
import com.mike.common.ResponseResult;
import com.mike.resume.entity.CProduct;
import com.mike.resume.service.impl.CProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


@RestController
public class CProductController {


    @Autowired
    private CProductServiceImpl cProductService;

    /**
     * 获取产品
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getAllProduct", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String getAllProduct(HttpServletRequest request) {
        ResponseResult<CProduct> result = new ResponseResult<>();
        result = cProductService.selectSelective(new CProduct());
        return JSON.toJSONString(result);
    }





}