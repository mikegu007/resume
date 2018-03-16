package com.mike.resume.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.CCard;
import com.mike.resume.entity.COrder;
import com.mike.resume.entity.COrderDetail;
import com.mike.resume.service.impl.CCardServiceImpl;
import com.mike.resume.service.impl.COrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
public class COrderController {


    @Autowired
    private COrderServiceImpl cOrderService;

    @Autowired
    private CCardServiceImpl cCardService;

    /**
     * @param request
     * @param json
     * @return
     */
    @RequestMapping(value = "/getOrders", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
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
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String addOrder(HttpServletRequest request, @RequestBody String json) {
        ResponseResult<COrder> result = new ResponseResult<>();
        if (StringUtil.isNotNull(json)) {
            COrder cOrder = JSON.parseObject(json,COrder.class);
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

    /**
     * @param request
     * @param json
     * @return
     */
    @RequestMapping(value = "/addOrderFromCart", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String addOrderFromCart(HttpServletRequest request, @RequestBody String json) {
        ResponseResult<COrder> result = new ResponseResult<>();
        if (StringUtil.isNotNull(json)) {
            JSONObject jsonObject = JSON.parseObject(json);
            Integer id = jsonObject.getInteger("id");
            if (StringUtil.isNotNull(id)){
                ResponseResult<CCard> cCardResponseResult = cCardService.selCCardById(id);
                if (cCardResponseResult.getCode()&&StringUtil.isNotNull(cCardResponseResult.getContent())){
                    CCard cCard = cCardResponseResult.getContent();
                    List<COrderDetail> cOrderDetails = new ArrayList<>();
                    COrderDetail cOrderDetail = new COrderDetail();
                    cOrderDetail.setpCategoryName(cCard.getpCategoryName());
                    cOrderDetail.setpDes(cCard.getpDes());
                    cOrderDetail.setpName(cCard.getpName());
                    cOrderDetail.setpPrice(cCard.getpPrice());
                    cOrderDetail.setpProPicUrl(cCard.getpProPicUrl());
                    cOrderDetail.setpSizeName(cCard.getpSizeName());
                    cOrderDetail.setpTasteName(cCard.getpTasteName());
                    cOrderDetails.add(cOrderDetail);
                    COrder cOrder = new COrder();
                    cOrder.setcOrderDetails(cOrderDetails);
                    cOrder.setDetailCount(cOrderDetails.size());
                    result = cOrderService.insertCOrder(cOrder);
                    //生成订单成功，删除购物车
                    if (result.getCode()){
                        ResponseResult<CCard> cCardResponseResult1 = cCardService.deleteByPrimaryKey(id);
//                        if (cCardResponseResult1.getCode()){
//
//                        }
                    }
                }else {
                    result.setCode(false);
                    result.setMsg("未查询到该购物车");
                }


        } else {
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
    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String updateOrder(HttpServletRequest request, @RequestBody String json) {
        ResponseResult<COrder> result = new ResponseResult<>();
        if (StringUtil.isNotNull(json)) {
            JSONObject sUser = JSON.parseObject(json);
            COrder cOrder = sUser.getObject("order",COrder.class);
            if (StringUtil.isNotNull(cOrder)&&StringUtil.isNotNull(cOrder.getOpenId())&&StringUtil.isNotNull(cOrder.getOrderNo())){
                result = cOrderService.updateCOrder(cOrder);
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