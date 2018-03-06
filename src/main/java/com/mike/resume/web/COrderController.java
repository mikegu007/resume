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
    String getOrders(HttpServletRequest request, @RequestBody String json) {
        ResponseResult<COrder> result = new ResponseResult<>();
        if (StringUtil.isNotNull(json)) {
            JSONObject sUser = JSON.parseObject(json);
            COrder cOrder = sUser.getObject("order",COrder.class);
            if (StringUtil.isNotNull(cOrder)&&StringUtil.isNotNull(cOrder.getOpenId())){
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

    /**
     * @param request
     * @param json
     * @return
     */
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String addOrder(HttpServletRequest request, @RequestBody String json) {
        ResponseResult<COrder> result = new ResponseResult<>();
        if (StringUtil.isNotNull(json)) {
            JSONObject sUser = JSON.parseObject(json);
            COrder cOrder = sUser.getObject("order",COrder.class);
            if (StringUtil.isNotNull(cOrder)&&StringUtil.isNotNull(cOrder.getOpenId())){
                result = cOrderService.insertCOrder(cOrder);
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