package com.mike.resume.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.SUser;
import com.mike.resume.mapper.SUserMapper;
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

    
    public ResponseResult<SUser> selSUserById(int id) {
        logger.info("方法 selSUserById 开始");
        logger.debug("方法 selSUserById 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<SUser> result = new ResponseResult<>();
        SUser sUser = sUserMapper.selectByPrimaryKey(id);
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


}
