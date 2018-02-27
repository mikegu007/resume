package com.mike.resume.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.COrder;
import com.mike.resume.mapper.COrderMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2017/7/19.
 */
@Service("cOrderService")
public class COrderServiceImpl {
    private static Logger logger = Logger.getLogger(COrderServiceImpl.class);

    @Autowired
    private COrderMapper cOrderMapper;

    public ResponseResult<COrder> deleteByPrimaryKey(String orderNo) {
        logger.info("方法 deleteByPrimaryKey 开始");
        logger.debug("方法 deleteByPrimaryKey 开始,参数 orderNo:" + JSON.toJSONString(orderNo));
        ResponseResult<COrder> result = new ResponseResult<>();
        int flag = cOrderMapper.deleteByPrimaryKey(orderNo);
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

    
    public ResponseResult<COrder> insertCOrder(COrder cOrder) {
        logger.info("方法 insertCOrder 开始");
        logger.debug("方法 insertCOrder 开始,参数 cOrder:" + JSON.toJSONString(cOrder));
        ResponseResult<COrder> result = new ResponseResult<>();
        if (StringUtil.isNotNull(cOrder)&&StringUtil.isNotNull(cOrder.getOrderNo())){
            COrder cOrderOld = cOrderMapper.selectByPrimaryKey(cOrder.getOrderNo());
            if (StringUtil.isNotNull(cOrderOld)){
                result.setCode(false);
                result.setMsg("产品已存在，请勿重复添加！");
            }else {
                int flag = cOrderMapper.insertSelective(cOrder);
                if (flag>0){
                    result.setCode(true);
                    result.setMsg("加入产品成功！");
                    result.setContent(cOrder);
                }else {
                    result.setCode(false);
                    result.setMsg("加入产品失败！");
                }
            }
        }else {
            result.setCode(false);
            result.setMsg("数据有误，加入产品失败！");
        }
        logger.debug("方法 insertCOrder 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertCOrder 结束");
        return result;
    }

    
    public BootGrid<COrder> selCOrder(BootGrid<COrder> grid, COrder cOrder) {
        logger.info("方法 selCOrder 开始");
        logger.debug("方法 selCOrder 开始,参数 grid:" + JSON.toJSONString(grid)+"参数 cOrder:" + JSON.toJSONString(cOrder));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(cOrderMapper.selectSelective(cOrder));
        grid.setTotal(cOrderMapper.selectSelective(cOrder).size());
        grid.setResult(true);
        logger.debug("方法 selCOrder 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selCOrder 结束");
        return grid;
    }

    
    public ResponseResult<COrder> selCOrderById(String orderNo) {
        logger.info("方法 selCOrderById 开始");
        logger.debug("方法 selCOrderById 开始,参数 orderNo:" + JSON.toJSONString(orderNo));
        ResponseResult<COrder> result = new ResponseResult<>();
        COrder cOrder = cOrderMapper.selectByPrimaryKey(orderNo);
        if (StringUtil.isNotNull(cOrder)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(cOrder);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selCOrderById 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selCOrderById 结束");
        return result;
    }

    
    public ResponseResult<COrder> selectSelective(COrder cOrder) {
        logger.info("方法 selectSelective 开始");
        logger.debug("方法 selectSelective 开始,参数 cOrder:" + JSON.toJSONString(cOrder));
        ResponseResult<COrder> result = new ResponseResult<>();
        List<COrder> cOrders = cOrderMapper.selectSelective(cOrder);
        if (StringUtil.isNotNull(cOrders)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(cOrders);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectSelective 结束");
        return result;
    }


}
