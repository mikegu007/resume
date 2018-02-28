package com.mike.resume.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.SUser;
import com.mike.resume.entity.SUserToken;
import com.mike.resume.service.impl.SUserServiceImpl;
import com.mike.resume.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
public class SUserController {

    @Autowired
    private SUserServiceImpl sUserService;

    /**
     * checkLogin
     *
     * @param request
     * @param json
     * @return
     */
    @RequestMapping(value = "/checkLogin", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public
    @ResponseBody
    String login(HttpServletRequest request, @RequestBody String json) {
        ResponseResult<SUserToken> result = new ResponseResult<>();
        if (StringUtil.isNotNull(json)){
            String url = "https://api.weixin.qq.com/sns/jscode2session?";
            JSONObject sUser = JSON.parseObject(json);
            String appid = sUser.getString("appid");
            String secret = sUser.getString("secret");
            String js_code = sUser.getString("js_code");
            String authorization_code = "authorization_code";
            if (StringUtil.isNotNull(appid)&&StringUtil.isNotNull(secret)&&StringUtil.isNotNull(js_code)){
                url = url+"appid="+appid+"&secret="+secret+"&js_code="+js_code+"&grant_type="+authorization_code;
                String wxResult = HttpUtil.syncData(url);
                if (StringUtil.isNotNull(wxResult)){
                    JSONObject wxResultJobject = JSON.parseObject(wxResult);
                    String errcode = wxResultJobject.getString("errcode");
                    String errmsg = wxResultJobject.getString("errmsg");
                    String openid = wxResultJobject.getString("openid");
                    String session_key = wxResultJobject.getString("session_key");
                    String unionid = wxResultJobject.getString("unionid");

                    if (StringUtil.isNotNull(errcode)||StringUtil.isNotNull(errmsg)){
                        result.setCode(false);
                        result.setMsg("调用wx接口错误时");
                    }else if (StringUtil.isNotNull(openid)&&StringUtil.isNotNull(session_key)&&StringUtil.isNotNull(unionid)){
                        SUserToken sUserToken = new SUserToken();
                        sUserToken.setOpenId(openid);
//                        sUserService.insertSUserToken()
                    }
                }else {
                    result.setCode(false);
                    result.setMsg("wx返回参数为空");
                }
            }else {
                result.setCode(false);
                result.setMsg("参数不能为空");
            }
        }else {
            result.setCode(false);
            result.setMsg("参数不能为空");
        }
        return JSON.toJSONString(result);
    }
}