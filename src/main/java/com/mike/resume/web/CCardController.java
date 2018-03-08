package com.mike.resume.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.CCard;
import com.mike.resume.entity.COrder;
import com.mike.resume.service.impl.CCardServiceImpl;
import com.mike.resume.service.impl.COrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class CCardController {


    @Autowired
    private CCardServiceImpl cCardService;

    /**
     * @param request
     * @param json
     * @return
     */
    @RequestMapping(value = "/getCards", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String getCards(HttpServletRequest request, @RequestBody String json) {
        ResponseResult<CCard> result = new ResponseResult<>();
        if (StringUtil.isNotNull(json)) {
            JSONObject sUser = JSON.parseObject(json);
            String openId = sUser.getString("openId");
            if (StringUtil.isNotNull(openId)){
                CCard cCard = new CCard();
                cCard.setOpenId(openId);
                result = cCardService.selectSelective(cCard);
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
    @RequestMapping(value = "/addCard", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String addCard(HttpServletRequest request, @RequestBody String json) {
        ResponseResult<CCard> result = new ResponseResult<>();
        if (StringUtil.isNotNull(json)) {
            CCard cCard = JSON.parseObject(json,CCard.class);
            if (StringUtil.isNotNull(cCard)&&StringUtil.isNotNull(cCard.getOpenId())){
                result = cCardService.insertCCard(cCard);
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
     * 删除购物车
     * @param request
     * @param json
     * @return
     */
    @RequestMapping(value = "/delCard", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public
    @ResponseBody
    String delCard(HttpServletRequest request, @RequestBody String json) {
        ResponseResult<CCard> result = new ResponseResult<>();
        if (StringUtil.isNotNull(json)) {
            JSONObject cCard = JSON.parseObject(json);
            Integer id = cCard.getInteger("id");
            if (StringUtil.isNotNull(id)){
                result = cCardService.deleteByPrimaryKey(id);
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