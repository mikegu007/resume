package com.mike.resume.service.impl;

import com.github.pagehelper.PageHelper;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.SUser;
import com.mike.resume.mapper.SUserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mike on 2017/7/19.
 */
@Service("userService")
public class UserServiceImpl {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private SUserMapper sUserMapper;

     
    public ResponseResult<SUser> saveSUser(SUser sUser) {
        logger.debug("saveSUser 开始...");
        ResponseResult<SUser> sUserResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(sUser)) {
            if (sUser.getOpenId() == null || sUser.getOpenId() == 0) {
                sUser.setOpenId(null);
                sUserMapper.insertSelective(sUser);
                sUserResponseResult.setCode(true);
                sUserResponseResult.setContent(sUser);
                sUserResponseResult.setMsg("新增记录成功！");
            } else {
                sUserMapper.updateByPrimaryKeySelective(sUser);
                sUserResponseResult.setCode(true);
                sUserResponseResult.setContent(sUser);
                sUserResponseResult.setMsg("更新记录成功！");
            }
        } else {
            sUserResponseResult.setCode(false);
            sUserResponseResult.setMsg("记录不能为空或者公司名不能为空！");
        }
        logger.debug("saveSUser 结束...");
        return sUserResponseResult;
    }

     
    public ResponseResult<SUser> delSUser(SUser sUser) {
        logger.debug("delSUser 开始...");
        ResponseResult<SUser> sUserResponseResult = new ResponseResult<>();
        if (StringUtil.isNotNull(sUser)&&StringUtil.isNotNull(sUser.getOpenId())){
            sUserMapper.deleteByPrimaryKey(sUser.getOpenId());
            sUserResponseResult.setCode(true);
            sUserResponseResult.setMsg("删除成功！");
        }else {
            sUserResponseResult.setCode(false);
            sUserResponseResult.setMsg("删除失败，记录或记录Id不能为空！");
        }
        logger.debug("delSUser 结束...");
        return sUserResponseResult;
    }

    

     
    public ResponseResult<SUser> selByIdSUser(Integer sUserId) {
        logger.debug("selByIdSUser 开始...");
        ResponseResult<SUser> sUserResponseResult = new ResponseResult<>();
        SUser sUser = sUserMapper.selectByPrimaryKey(sUserId);
        if (StringUtil.isNotNull(sUser)){
            sUserResponseResult.setCode(true);
            sUserResponseResult.setContent(sUser);
        }else {
            sUserResponseResult.setCode(false);
            sUserResponseResult.setMsg("未查询到该数据！");
        }
        logger.debug("selByIdSUser 结束...");
        return sUserResponseResult;
    }


}
