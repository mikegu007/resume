package com.mike.OOFO.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.OOFO.entity.OUserCon;
import com.mike.OOFO.mapper.OUserConMapper;
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
@Service("oUserConService")
public class OUserConServiceImpl {
    private static Logger logger = Logger.getLogger(OUserConServiceImpl.class);

    @Autowired
    private OUserConMapper oUserConMapper;

    public ResponseResult<OUserCon> deleteByPrimaryKey(int id) {
        logger.info("方法 deleteByPrimaryKey 开始");
        logger.debug("方法 deleteByPrimaryKey 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<OUserCon> result = new ResponseResult<>();
        int flag = oUserConMapper.deleteByPrimaryKey(id);
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


    public ResponseResult<OUserCon> insertOUserCon(OUserCon oUserCon) {
        logger.info("方法 insertOUserCon 开始");
        logger.debug("方法 insertOUserCon 开始,参数 oUserCon:" + JSON.toJSONString(oUserCon));
        ResponseResult<OUserCon> result = new ResponseResult<>();
        if (StringUtil.isNotNull(oUserCon)) {
            int flag = oUserConMapper.insertSelective(oUserCon);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("加入购物车成功！");
                result.setContent(oUserCon);
            } else {
                result.setCode(false);
                result.setMsg("加入购物车失败！");
            }
        }

        logger.debug("方法 insertOUserCon 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertOUserCon 结束");
        return result;
    }

    public ResponseResult<OUserCon> updateOUserCon(OUserCon oUserCon) {
        logger.info("方法 updateOUserCon 开始");
        logger.debug("方法 updateOUserCon 开始,参数 oUserCon:" + JSON.toJSONString(oUserCon));
        ResponseResult<OUserCon> result = new ResponseResult<>();
        if (StringUtil.isNotNull(oUserCon) && StringUtil.isNotNull(oUserCon.getId())) {
            int flag = oUserConMapper.updateByPrimaryKeySelective(oUserCon);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("更新购物车成功！");
                result.setContent(oUserCon);
            } else {
                result.setCode(false);
                result.setMsg("更新购物车失败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("数据有误，更新购物车失败！");
        }
        logger.debug("方法 updateOUserCon 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 updateOUserCon 结束");
        return result;
    }


    public BootGrid<OUserCon> selOUserCon(BootGrid<OUserCon> grid, OUserCon oUserCon) {
        logger.info("方法 selOUserCon 开始");
        logger.debug("方法 selOUserCon 开始,参数 grid:" + JSON.toJSONString(grid) + "参数 oUserCon:" + JSON.toJSONString(oUserCon));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(oUserConMapper.selectSelective(oUserCon));
        grid.setTotal(oUserConMapper.selectSelective(oUserCon).size());
        grid.setResult(true);
        logger.debug("方法 selOUserCon 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selOUserCon 结束");
        return grid;
    }


    public ResponseResult<OUserCon> selOUserConById(int id) {
        logger.info("方法 selOUserConById 开始");
        logger.debug("方法 selOUserConById 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<OUserCon> result = new ResponseResult<>();
        OUserCon oUserCon = oUserConMapper.selectByPrimaryKey(id);
        if (StringUtil.isNotNull(oUserCon)) {
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(oUserCon);
        } else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selOUserConById 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selOUserConById 结束");
        return result;
    }


    public ResponseResult<OUserCon> selectSelective(OUserCon oUserCon) {
        logger.info("方法 selectSelective 开始");
        logger.debug("方法 selectSelective 开始,参数 oUserCon:" + JSON.toJSONString(oUserCon));
        ResponseResult<OUserCon> result = new ResponseResult<>();
        List<OUserCon> oUserCons = oUserConMapper.selectSelective(oUserCon);
        if (StringUtil.isNotNull(oUserCons)) {
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(oUserCons);
        } else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectSelective 结束");
        return result;
    }


}
