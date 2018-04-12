package com.mike.OOFO.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.OOFO.entity.OUser;
import com.mike.OOFO.mapper.OUserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2018/4/12.
 */
@Service("oUserService")
public class OUserServiceImpl {
    private static Logger logger = Logger.getLogger(OUserServiceImpl.class);

    @Autowired
    private OUserMapper oUserMapper;

    public ResponseResult<OUser> deleteByPrimaryKey(int id) {
        logger.info("方法 deleteByPrimaryKey 开始");
        logger.debug("方法 deleteByPrimaryKey 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<OUser> result = new ResponseResult<>();
        int flag = oUserMapper.deleteByPrimaryKey(id);
        if (flag > 0) {
            result.setCode(true);
            result.setMsg("删除成功！");
        } else {
            result.setCode(false);
            result.setMsg("删除失败！");
        }
        logger.debug("方法 deleteByPrimaryKey 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 deleteByPrimaryKey 结束");
        return result;
    }


    public ResponseResult<OUser> insertOUser(OUser oUser) {
        logger.info("方法 insertOUser 开始");
        logger.debug("方法 insertOUser 开始,参数 oUser:" + JSON.toJSONString(oUser));
        ResponseResult<OUser> result = new ResponseResult<>();
        if (StringUtil.isNotNull(oUser)) {
            int flag = oUserMapper.insertSelective(oUser);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("加入购物车成功！");
                result.setContent(oUser);
            } else {
                result.setCode(false);
                result.setMsg("加入购物车失败！");
            }
        }

        logger.debug("方法 insertOUser 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertOUser 结束");
        return result;
    }

    public ResponseResult<OUser> updateOUser(OUser oUser) {
        logger.info("方法 updateOUser 开始");
        logger.debug("方法 updateOUser 开始,参数 oUser:" + JSON.toJSONString(oUser));
        ResponseResult<OUser> result = new ResponseResult<>();
        if (StringUtil.isNotNull(oUser) && StringUtil.isNotNull(oUser.getId())) {
            int flag = oUserMapper.updateByPrimaryKeySelective(oUser);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("更新购物车成功！");
                result.setContent(oUser);
            } else {
                result.setCode(false);
                result.setMsg("更新购物车失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("数据有误，更新购物车失败！");
        }
        logger.debug("方法 updateOUser 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 updateOUser 结束");
        return result;
    }


    public BootGrid<OUser> selOUser(BootGrid<OUser> grid, OUser oUser) {
        logger.info("方法 selOUser 开始");
        logger.debug("方法 selOUser 开始,参数 grid:" + JSON.toJSONString(grid) + "参数 oUser:" + JSON.toJSONString(oUser));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(oUserMapper.selectSelective(oUser));
        grid.setTotal(oUserMapper.selectSelective(oUser).size());
        grid.setResult(true);
        logger.debug("方法 selOUser 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selOUser 结束");
        return grid;
    }


    public ResponseResult<OUser> selOUserById(int id) {
        logger.info("方法 selOUserById 开始");
        logger.debug("方法 selOUserById 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<OUser> result = new ResponseResult<>();
        OUser oUser = oUserMapper.selectByPrimaryKey(id);
        if (StringUtil.isNotNull(oUser)) {
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(oUser);
        } else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selOUserById 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selOUserById 结束");
        return result;
    }


    public ResponseResult<OUser> selectSelective(OUser oUser) {
        logger.info("方法 selectSelective 开始");
        logger.debug("方法 selectSelective 开始,参数 oUser:" + JSON.toJSONString(oUser));
        ResponseResult<OUser> result = new ResponseResult<>();
        List<OUser> oUsers = oUserMapper.selectSelective(oUser);
        if (StringUtil.isNotNull(oUsers)) {
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(oUsers);
        } else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectSelective 结束");
        return result;
    }


}
