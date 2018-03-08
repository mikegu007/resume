package com.mike.resume.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.SUser;
import com.mike.resume.entity.SUserToken;
import com.mike.resume.mapper.SUserMapper;
import com.mike.resume.mapper.SUserTokenMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2017/7/19.
 */
@Service("sUserService")
public class SUserServiceImpl {
    private static Logger logger = Logger.getLogger(SUserServiceImpl.class);

    @Autowired
    private SUserMapper sUserMapper;

    @Autowired
    private SUserTokenMapper sUserTokenMapper;

    public ResponseResult<SUser> deleteByPrimaryKey(int id) {
        logger.info("方法 deleteByPrimaryKey 开始");
        logger.debug("方法 deleteByPrimaryKey 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<SUser> result = new ResponseResult<>();
        int flag = sUserMapper.deleteByPrimaryKey(id);
        if (flag>0){
            result.setCode(true);
            result.setMsg("删除成功！");
        }else {
            result.setCode(false);
            result.setMsg("删除失败！");
        }
        logger.debug("方法 deleteByPrimaryKey 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 deleteByPrimaryKey 结束");
        return result;
    }

    
    public ResponseResult<SUser> insertSUser(SUser sUser) {
        logger.info("方法 insertSUser 开始");
        logger.debug("方法 insertSUser 开始,参数 sUser:" + JSON.toJSONString(sUser));
        ResponseResult<SUser> result = new ResponseResult<>();
        if (StringUtil.isNotNull(sUser)&&StringUtil.isNotNull(sUser.getOpenId())){
            SUser sUserOld = sUserMapper.selectByPrimaryKey(sUser.getOpenId());
            if (StringUtil.isNotNull(sUserOld)){
                result.setCode(false);
                result.setMsg("用户信息已存在，请勿重复添加！");
            }else {
                int flag = sUserMapper.insertSelective(sUser);
                if (flag>0){
                    result.setCode(true);
                    result.setMsg("加入用户信息成功！");
                    result.setContent(sUser);
                }else {
                    result.setCode(false);
                    result.setMsg("加入用户信息失败！");
                }
            }
        }else {
            result.setCode(false);
            result.setMsg("数据有误，加入用户信息失败！");
        }
        logger.debug("方法 insertSUser 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertSUser 结束");
        return result;
    }



    public ResponseResult<SUser> updateSUser(SUser sUser) {
        logger.info("方法 updateSUser 开始");
        logger.debug("方法 updateSUser 开始,参数 sUser:" + JSON.toJSONString(sUser));
        ResponseResult<SUser> result = new ResponseResult<>();
        if (StringUtil.isNotNull(sUser) && StringUtil.isNotNull(sUser.getOpenId())) {
            int flag = sUserMapper.updateByPrimaryKeySelective(sUser);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("更新用户成功！");
                result.setContent(sUser);
            } else {
                result.setCode(false);
                result.setMsg("更新用户败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("数据有误，更新用户失败！");
        }
        logger.debug("方法 updateSUser 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 updateSUser 结束");
        return result;
    }
    

    
    public BootGrid<SUser> selSUser(BootGrid<SUser> grid, SUser sUser) {
        logger.info("方法 selSUser 开始");
        logger.debug("方法 selSUser 开始,参数 grid:" + JSON.toJSONString(grid)+"参数 sUser:" + JSON.toJSONString(sUser));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(sUserMapper.selectSelective(sUser));
        grid.setTotal(sUserMapper.selectSelective(sUser).size());
        grid.setResult(true);
        logger.debug("方法 selSUser 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selSUser 结束");
        return grid;
    }

    
    public ResponseResult<SUser> selSUserById(String openId) {
        logger.info("方法 selSUserById 开始");
        logger.debug("方法 selSUserById 开始,参数 id:" + JSON.toJSONString(openId));
        ResponseResult<SUser> result = new ResponseResult<>();
        SUser sUser = sUserMapper.selectByPrimaryKey(openId);
        if (StringUtil.isNotNull(sUser)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(sUser);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selSUserById 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selSUserById 结束");
        return result;
    }

    
    public ResponseResult<SUser> selectSelective(SUser sUser) {
        logger.info("方法 selectSelective 开始");
        logger.debug("方法 selectSelective 开始,参数 sUser:" + JSON.toJSONString(sUser));
        ResponseResult<SUser> result = new ResponseResult<>();
        List<SUser> sUsers = sUserMapper.selectSelective(sUser);
        if (StringUtil.isNotNull(sUsers)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(sUsers);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectSelective 结束");
        return result;
    }



    public ResponseResult<SUser> deleteTokenByPrimaryKey(int id) {
        logger.info("方法 deleteTokenByPrimaryKey 开始");
        logger.debug("方法 deleteTokenByPrimaryKey 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<SUser> result = new ResponseResult<>();
        int flag = sUserTokenMapper.deleteByPrimaryKey(id);
        if (flag>0){
            result.setCode(true);
            result.setMsg("删除成功！");
        }else {
            result.setCode(false);
            result.setMsg("删除失败！");
        }
        logger.debug("方法 deleteTokenByPrimaryKey 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 deleteTokenByPrimaryKey 结束");
        return result;
    }


    public ResponseResult<SUserToken> insertSUserToken(SUserToken sUserToken) {
        logger.info("方法 insertSUserToken 开始");
        logger.debug("方法 insertSUserToken 开始,参数 sUserToken:" + JSON.toJSONString(sUserToken));
        ResponseResult<SUserToken> result = new ResponseResult<>();
        if (StringUtil.isNotNull(sUserToken)&&StringUtil.isNotNull(sUserToken.getOpenId())){
            SUserToken sUserTokenOld = sUserTokenMapper.selectByOpenId(sUserToken.getOpenId());
            if (StringUtil.isNotNull(sUserTokenOld)){
                result.setContent(sUserTokenOld);
                result.setCode(false);
                result.setMsg("用户信息已存在，请勿重复添加！");
            }else {
                int flag = sUserTokenMapper.insertSelective(sUserToken);
                if (flag>0){
                    result.setCode(true);
                    result.setMsg("加入用户信息成功！");
                    result.setContent(sUserToken);
                }else {
                    result.setCode(false);
                    result.setMsg("加入用户信息失败！");
                }
            }
        }else {
            result.setCode(false);
            result.setMsg("数据有误，加入用户信息失败！");
        }
        logger.debug("方法 insertSUserToken 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertSUserToken 结束");
        return result;
    }


    public ResponseResult<SUserToken> updateSUserToken(SUserToken sUserToken) {
        logger.info("方法 updateSUserToken 开始");
        logger.debug("方法 updateSUserToken 开始,参数 sUserToken:" + JSON.toJSONString(sUserToken));
        ResponseResult<SUserToken> result = new ResponseResult<>();
        if (StringUtil.isNotNull(sUserToken) && StringUtil.isNotNull(sUserToken.getId())) {
            int flag = sUserTokenMapper.updateByPrimaryKeySelective(sUserToken);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("更新用户状态成功！");
                result.setContent(sUserToken);
            } else {
                result.setCode(false);
                result.setMsg("更新用户状态败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("数据有误，更新用户状态失败！");
        }
        logger.debug("方法 updateSUserToken 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 updateSUserToken 结束");
        return result;
    }
    
    
    


    public BootGrid<SUserToken> selSUserToken(BootGrid<SUserToken> grid, SUserToken sUserToken) {
        logger.info("方法 selSUserToken 开始");
        logger.debug("方法 selSUserToken 开始,参数 grid:" + JSON.toJSONString(grid)+"参数 sUserToken:" + JSON.toJSONString(sUserToken));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(sUserTokenMapper.selectSelective(sUserToken));
        grid.setTotal(sUserTokenMapper.selectSelective(sUserToken).size());
        grid.setResult(true);
        logger.debug("方法 selSUserToken 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selSUserToken 结束");
        return grid;
    }


    public ResponseResult<SUserToken> selSUserTokenById(int id) {
        logger.info("方法 selSUserTokenById 开始");
        logger.debug("方法 selSUserTokenById 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<SUserToken> result = new ResponseResult<>();
        SUserToken sUserToken = sUserTokenMapper.selectByPrimaryKey(id);
        if (StringUtil.isNotNull(sUserToken)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(sUserToken);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selSUserTokenById 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selSUserTokenById 结束");
        return result;
    }

    public ResponseResult<SUserToken> selSUserTokenByOpenId(String openId) {
        logger.info("方法 selSUserTokenByOpenId 开始");
        logger.debug("方法 selSUserTokenByOpenId 开始,参数 id:" + JSON.toJSONString(openId));
        ResponseResult<SUserToken> result = new ResponseResult<>();
        SUserToken sUserToken = sUserTokenMapper.selectByOpenId(openId);
        if (StringUtil.isNotNull(sUserToken)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(sUserToken);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selSUserTokenByOpenId 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selSUserTokenByOpenId 结束");
        return result;
    }


    public ResponseResult<SUserToken> selectTokenSelective(SUserToken sUserToken) {
        logger.info("方法 selectTokenSelective 开始");
        logger.debug("方法 selectTokenSelective 开始,参数 sUserToken:" + JSON.toJSONString(sUserToken));
        ResponseResult<SUserToken> result = new ResponseResult<>();
        List<SUserToken> sUsersToken = sUserTokenMapper.selectSelective(sUserToken);
        if (StringUtil.isNotNull(sUsersToken)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(sUsersToken);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectTokenSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectTokenSelective 结束");
        return result;
    }





}
