package com.mike.OOFO.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.OOFO.entity.OUserinfo;
import com.mike.OOFO.mapper.OUserinfoMapper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2018/4/12.
 */
@Service("oUserinfoService")
public class OUserinfoServiceImpl {
    private static Logger logger = Logger.getLogger(OUserinfoServiceImpl.class);

    @Autowired
    private OUserinfoMapper oUserinfoMapper;

    public ResponseResult<OUserinfo> deleteByPrimaryKey(int id) {
        logger.info("方法 deleteByPrimaryKey 开始");
        logger.debug("方法 deleteByPrimaryKey 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<OUserinfo> result = new ResponseResult<>();
        int flag = oUserinfoMapper.deleteByPrimaryKey(id);
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


    public ResponseResult<OUserinfo> insertOUserinfo(OUserinfo oUserinfo) {
        logger.info("方法 insertOUserinfo 开始");
        logger.debug("方法 insertOUserinfo 开始,参数 oUserinfo:" + JSON.toJSONString(oUserinfo));
        ResponseResult<OUserinfo> result = new ResponseResult<>();
        if (StringUtil.isNotNull(oUserinfo)) {
            int flag = oUserinfoMapper.insertSelective(oUserinfo);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("加入购物车成功！");
                result.setContent(oUserinfo);
            } else {
                result.setCode(false);
                result.setMsg("加入购物车失败！");
            }
        }

        logger.debug("方法 insertOUserinfo 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertOUserinfo 结束");
        return result;
    }

    public ResponseResult<OUserinfo> updateOUserinfo(OUserinfo oUserinfo) {
        logger.info("方法 updateOUserinfo 开始");
        logger.debug("方法 updateOUserinfo 开始,参数 oUserinfo:" + JSON.toJSONString(oUserinfo));
        ResponseResult<OUserinfo> result = new ResponseResult<>();
        if (StringUtil.isNotNull(oUserinfo) && StringUtil.isNotNull(oUserinfo.getId())) {
            int flag = oUserinfoMapper.updateByPrimaryKeySelective(oUserinfo);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("更新购物车成功！");
                result.setContent(oUserinfo);
            } else {
                result.setCode(false);
                result.setMsg("更新购物车失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("数据有误，更新购物车失败！");
        }
        logger.debug("方法 updateOUserinfo 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 updateOUserinfo 结束");
        return result;
    }


    public BootGrid<OUserinfo> selOUserinfo(BootGrid<OUserinfo> grid, OUserinfo oUserinfo) {
        logger.info("方法 selOUserinfo 开始");
        logger.debug("方法 selOUserinfo 开始,参数 grid:" + JSON.toJSONString(grid) + "参数 oUserinfo:" + JSON.toJSONString(oUserinfo));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(oUserinfoMapper.selectSelective(oUserinfo));
        grid.setTotal(oUserinfoMapper.selectSelective(oUserinfo).size());
        grid.setResult(true);
        logger.debug("方法 selOUserinfo 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selOUserinfo 结束");
        return grid;
    }


    public ResponseResult<OUserinfo> selOUserinfoById(int id) {
        logger.info("方法 selOUserinfoById 开始");
        logger.debug("方法 selOUserinfoById 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<OUserinfo> result = new ResponseResult<>();
        OUserinfo oUserinfo = oUserinfoMapper.selectByPrimaryKey(id);
        if (StringUtil.isNotNull(oUserinfo)) {
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(oUserinfo);
        } else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selOUserinfoById 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selOUserinfoById 结束");
        return result;
    }


    public ResponseResult<OUserinfo> selectSelective(OUserinfo oUserinfo) {
        logger.info("方法 selectSelective 开始");
        logger.debug("方法 selectSelective 开始,参数 oUserinfo:" + JSON.toJSONString(oUserinfo));
        ResponseResult<OUserinfo> result = new ResponseResult<>();
        List<OUserinfo> oUserinfos = oUserinfoMapper.selectSelective(oUserinfo);
        if (StringUtil.isNotNull(oUserinfos)) {
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(oUserinfos);
        } else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectSelective 结束");
        return result;
    }


}
