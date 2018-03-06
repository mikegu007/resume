package com.mike.resume.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.COrder;
import com.mike.resume.entity.CProduct;
import com.mike.resume.service.impl.COrderServiceImpl;
import com.mike.resume.service.impl.CProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class COrderController {


    @Autowired
    private COrderServiceImpl cOrderService;

    /**
     * @param request
     * @param json
     * @return
     */
    @RequestMapping(value = "/getOrders", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String login(HttpServletRequest request, @RequestBody String json) {
        ResponseResult<COrder> result = new ResponseResult<>();
        if (StringUtil.isNotNull(json)) {
            JSONObject sUser = JSON.parseObject(json);
            String openId = sUser.getString("openId");
            if (StringUtil.isNotNull(openId)){
                COrder cOrder = new COrder();
                result = cOrderService.selectSelective(cOrder);
            }else {
                result.setCode(false);
                result.setMsg("参数不能为空");
            }
        } else {
            result.setCode(false);
            result.setMsg("参数不能为空");
        }
        return JSON.toJSONString(result);
    }


}