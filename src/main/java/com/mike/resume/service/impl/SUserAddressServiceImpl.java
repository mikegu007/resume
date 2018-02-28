package com.mike.resume.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.SUserAddress;
import com.mike.resume.mapper.SUserAddressMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2017/7/19.
 */
@Service("sUserAddressService")
public class SUserAddressServiceImpl {
    private static Logger logger = Logger.getLogger(SUserAddressServiceImpl.class);

    @Autowired
    private SUserAddressMapper sUserAddressMapper;

    public ResponseResult<SUserAddress> deleteByPrimaryKey(int id) {
        logger.info("方法 deleteByPrimaryKey 开始");
        logger.debug("方法 deleteByPrimaryKey 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<SUserAddress> result = new ResponseResult<>();
        int flag = sUserAddressMapper.deleteByPrimaryKey(id);
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


    public ResponseResult<SUserAddress> insertSUserAddress(SUserAddress sUserAddress) {
        logger.info("方法 insertSUserAddress 开始");
        logger.debug("方法 insertSUserAddress 开始,参数 sUserAddress:" + JSON.toJSONString(sUserAddress));
        ResponseResult<SUserAddress> result = new ResponseResult<>();
        if (StringUtil.isNotNull(sUserAddress) && StringUtil.isNotNull(sUserAddress.getOpenId())) {
            int flag = sUserAddressMapper.insertSelective(sUserAddress);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("加入用户地址成功！");
                result.setContent(sUserAddress);
            } else {
                result.setCode(false);
                result.setMsg("加入用户地址失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("数据有误，加入用户地址失败！");
        }
        logger.debug("方法 insertSUserAddress 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertSUserAddress 结束");
        return result;
    }



    public ResponseResult<SUserAddress> updateSUserAddress(SUserAddress sUserAddress) {
        logger.info("方法 updateSUserAddress 开始");
        logger.debug("方法 updateSUserAddress 开始,参数 sUserAddress:" + JSON.toJSONString(sUserAddress));
        ResponseResult<SUserAddress> result = new ResponseResult<>();
        if (StringUtil.isNotNull(sUserAddress) && StringUtil.isNotNull(sUserAddress.getId())) {
            int flag = sUserAddressMapper.updateByPrimaryKeySelective(sUserAddress);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("更新用户地址成功！");
                result.setContent(sUserAddress);
            } else {
                result.setCode(false);
                result.setMsg("更新用户地址败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("数据有误，更新用户地址失败！");
        }
        logger.debug("方法 updateSUserAddress 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 updateSUserAddress 结束");
        return result;
    }
    
    


    public BootGrid<SUserAddress> selSUserAddress(BootGrid<SUserAddress> grid, SUserAddress sUserAddress) {
        logger.info("方法 selSUserAddress 开始");
        logger.debug("方法 selSUserAddress 开始,参数 grid:" + JSON.toJSONString(grid) + "参数 sUserAddress:" + JSON.toJSONString(sUserAddress));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(sUserAddressMapper.selectSelective(sUserAddress));
        grid.setTotal(sUserAddressMapper.selectSelective(sUserAddress).size());
        grid.setResult(true);
        logger.debug("方法 selSUserAddress 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selSUserAddress 结束");
        return grid;
    }


    public ResponseResult<SUserAddress> selSUserAddressById(int id) {
        logger.info("方法 selSUserAddressById 开始");
        logger.debug("方法 selSUserAddressById 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<SUserAddress> result = new ResponseResult<>();
        SUserAddress sUserAddress = sUserAddressMapper.selectByPrimaryKey(id);
        if (StringUtil.isNotNull(sUserAddress)) {
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(sUserAddress);
        } else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selSUserAddressById 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selSUserAddressById 结束");
        return result;
    }


    public ResponseResult<SUserAddress> selectSelective(SUserAddress sUserAddress) {
        logger.info("方法 selectSelective 开始");
        logger.debug("方法 selectSelective 开始,参数 sUserAddress:" + JSON.toJSONString(sUserAddress));
        ResponseResult<SUserAddress> result = new ResponseResult<>();
        List<SUserAddress> sUserAddresss = sUserAddressMapper.selectSelective(sUserAddress);
        if (StringUtil.isNotNull(sUserAddresss)) {
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(sUserAddresss);
        } else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectSelective 结束");
        return result;
    }


}
