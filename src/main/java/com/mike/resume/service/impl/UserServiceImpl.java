package com.mike.resume.service.impl;

import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.common.UtilEncode;
import com.mike.common.UtilGenerateID;
import com.mike.resume.entity.SUser;
import com.mike.resume.mapper.SUserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Mike on 2017/7/19.
 */
@Service("userService")
public class UserServiceImpl {
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private SUserMapper sUserMapper;

    public ResponseResult<SUser> findUserByLoginCode(String code, String email, Long phone) {
        logger.info("方法findUserByLoginCode开始....");
        ResponseResult<SUser> result = new ResponseResult<>();
        SUser user = null;
        Boolean codeFlag = false;
        Boolean emailFlag = false;
        Boolean phoneFlag = false;
        if (StringUtil.isNotNull(code)) {
            codeFlag = true;
        }
        if (StringUtil.isNotNull(email)) {
            emailFlag = true;
        }
        if (StringUtil.isNotNull(phone)) {
            phoneFlag = true;
        }

        if (codeFlag) {
            user = sUserMapper.findByCode(code);
            if (StringUtil.isNotNull(user)) {
                result.setCode(true);
                result.setContent(user);
                return result;
            } else {
                result.setCode(false);
                result.setMsg("未查到该用户");
            }
        }
        if (emailFlag) {
            user = sUserMapper.findByEmail(email);
            if (StringUtil.isNotNull(user)) {
                result.setCode(true);
                result.setContent(user);
                return result;
            } else {
                result.setCode(false);
                result.setMsg("未查到该用户");
            }
        }
        if (phoneFlag) {
            user = sUserMapper.findByPhone(phone);
            if (StringUtil.isNotNull(user)) {
                result.setCode(true);
                result.setContent(user);
                return result;
            } else {
                result.setCode(false);
                result.setMsg("未查到该用户");
            }
        }
        if ((!codeFlag) && (!emailFlag) && (!phoneFlag)) {
            result.setCode(false);
            result.setMsg("用户编号、邮箱、手机至少一项不为空！");
        }

        return result;
    }

    public ResponseResult<SUser> addUser(SUser user) {
        logger.info("方法addUser开始....");
        ResponseResult<SUser> result = new ResponseResult<SUser>();
        if (StringUtil.isNotNull(user)) {
            //查找是否存在该用户
            ResponseResult<SUser> history = findUserByLoginCode(user.getCode(), user.getEmail(), user.getPhone());
            if (history.getCode() && StringUtil.isNotNull(history.getContent())) {
                result.setCode(false);
                result.setMsg("该用户已存在，添加失败！");
            } else {
                user.setSafeNumber(0);
                user.setIsBindSecur(false);
                user.setDelFlag(false);
                user.setCreateTime(new Date());
                user.setLocked(false);
                user.setEnable(true);
                user.setLoginCount(0);
                //生成的code数据库中不重复
                do {
                    user.setCode(UtilGenerateID.generateID(""));
                }
                while ((!StringUtil.isNotNull(user.getCode())) && (!StringUtil.isNotNull(findUserByLoginCode(user.getCode(), null, null).getContent())));

                //设置盐 密码加密
                user.setSalt(UtilGenerateID.generateID(""));
                user.setPassword(UtilEncode.encodeMD5(user.getPassword() + user.getSalt()));

                if (sUserMapper.insertSelective(user) > 0) {
                    result.setCode(true);
                    result.setMsg("用户添加成功！");
                    result.setContent(user);
                } else {
                    result.setCode(false);
                    result.setMsg("用户添加失败！");
                }
            }
        } else {
            result.setCode(false);
            result.setMsg("新增User不能为空！");
        }
        return result;
    }

    public ResponseResult<SUser> delUser(String code) {
        logger.info("方法delUser开始....");
        ResponseResult<SUser> result = new ResponseResult<SUser>();
        SUser user = sUserMapper.findByCode(code);
        if (StringUtil.isNotNull(user)) {
            user.setDelFlag(true);
            sUserMapper.updateByPrimaryKeySelective(user);
            result.setCode(true);
            result.setMsg("用户删除成功！");
        } else {
            result.setCode(false);
            result.setMsg("用户删除失败,未查询到该用户！");
        }
        return result;
    }

    public ResponseResult<SUser> updateUser(SUser user) {
        logger.info("方法updateUser开始....");
        ResponseResult<SUser> result = new ResponseResult<SUser>();
        user.setSalt(UtilGenerateID.generateID(""));
        user.setPassword(UtilEncode.encodeMD5(user.getPassword() + user.getSalt()));
        if (sUserMapper.updateByPrimaryKeySelective(user) > 0) {
            result.setContent(user);
            result.setCode(true);
            result.setMsg("用户更新成功！");
        } else {
            result.setCode(false);
            result.setMsg("用户更新失败！");
        }
        return result;
    }



    public ResponseResult<SUser> margeUser(SUser user) {
        logger.info("方法margeUser开始....");
        ResponseResult<SUser> result = new ResponseResult<SUser>();
        if (user != null) {
            if (StringUtil.isNotNull(user.getCode())) {
                result = updateUser(user);
            } else {
                result = addUser(user);
            }
        }
        return result;
    }


}
