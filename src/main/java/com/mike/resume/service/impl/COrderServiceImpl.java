package com.mike.resume.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.common.UtilGenerateID;
import com.mike.resume.entity.COrder;
import com.mike.resume.entity.COrderDetail;
import com.mike.resume.entity.CProductSize;
import com.mike.resume.enums.EnumOrderStatus;
import com.mike.resume.mapper.COrderDetailMapper;
import com.mike.resume.mapper.COrderMapper;
import com.mike.resume.mapper.CProductSizeMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Mike on 2017/7/19.
 */
@Service("cOrderService")
public class COrderServiceImpl {
    private static Logger logger = Logger.getLogger(COrderServiceImpl.class);

    @Autowired
    private COrderMapper cOrderMapper;

    @Autowired
    private COrderDetailMapper cOrderDetailMapper;

    @Autowired
    private CProductSizeMapper cProductSizeMapper;

    public ResponseResult<COrder> deleteByPrimaryKey(String orderNo) {
        logger.info("方法 deleteByPrimaryKey 开始");
        logger.debug("方法 deleteByPrimaryKey 开始,参数 orderNo:" + JSON.toJSONString(orderNo));
        ResponseResult<COrder> result = new ResponseResult<>();
        int flag = cOrderMapper.deleteByPrimaryKey(orderNo);
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


    public ResponseResult<COrder> insertCOrder(COrder cOrder) {
        logger.info("方法 insertCOrder 开始");
        logger.debug("方法 insertCOrder 开始,参数 cOrder:" + JSON.toJSONString(cOrder));
        ResponseResult<COrder> result = new ResponseResult<>();

        if (StringUtil.isNotNull(cOrder) && StringUtil.isNotNull(cOrder.getOpenId()) && (cOrder.getDetailCount() > 0)&&StringUtil.isNotNull(cOrder.getcProductSizeId())) {
            //查询产品规格库存
            CProductSize cProductSize = cProductSizeMapper.selectByPrimaryKey(cOrder.getcProductSizeId());
            if (StringUtil.isNotNull(cProductSize)){
                if (cProductSize.getInventoryCount()>0){
                    String orderNo;
                    //生成的code数据库中不重复
                    orderNo = UtilGenerateID.generateID("");
                    //插入订单明细
                    int orderCount = 0;
                    for (COrderDetail c :cOrder.getcOrderDetails()) {
                        c.setOrderNo(orderNo);
                        cOrderDetailMapper.insertSelective(c);
                        orderCount += c.getpCount();
                    }
                    cOrder.setOrderNo(orderNo);
                    cOrder.setCreateTime(new Date());
                    cOrder.setHasPay(false);
                    cOrder.setStatus(EnumOrderStatus.ToPay.getStatusCode());
                    cOrder.setDetailCount(orderCount);
                    int flag = cOrderMapper.insertSelective(cOrder);
                    if (flag > 0) {
                        result.setCode(true);
                        result.setMsg("加入订单成功！");
                        result.setContent(cOrder);
                    //订单添加成功，库存-1
                        cProductSize.setInventoryCount(cProductSize.getInventoryCount()-1);
                        cProductSizeMapper.updateByPrimaryKeySelective(cProductSize);
                    } else {
                        result.setCode(false);
                        result.setMsg("加入订单失败！");
                    }
                }else {
                    result.setCode(false);
                    result.setMsg("订单添加失败，产品未查到库存！");
                }
            }else {
                result.setCode(false);
                result.setMsg("订单添加失败，产品未查到规格！");
            }



        } else {
            result.setCode(false);
            result.setMsg("数据有误，加入订单失败！");
        }
        logger.debug("方法 insertCOrder 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertCOrder 结束");
        return result;
    }

    public ResponseResult<COrder> updateCOrder(COrder cOrder) {
        logger.info("方法 updateCOrder 开始");
        logger.debug("方法 updateCOrder 开始,参数 cOrder:" + JSON.toJSONString(cOrder));
        ResponseResult<COrder> result = new ResponseResult<>();
        if (StringUtil.isNotNull(cOrder) && StringUtil.isNotNull(cOrder.getOrderNo())) {
            List<COrder> cOrders = cOrderMapper.selectSelective(cOrder);
            if (cOrders.size()>0){
                result.setCode(false);
                result.setMsg("请勿重复更新该订单！");
            }else {
                int flag = cOrderMapper.updateByPrimaryKeySelective(cOrder);
                if (flag > 0) {
                    result.setCode(true);
                    result.setMsg("更新订单成功！");
                    result.setContent(cOrder);
                } else {
                    result.setCode(false);
                    result.setMsg("更新订单失败！");
                }
            }

        } else {
            result.setCode(false);
            result.setMsg("数据有误，更新订单失败！");
        }
        logger.debug("方法 updateCOrder 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 updateCOrder 结束");
        return result;
    }


    public BootGrid<COrder> selCOrder(BootGrid<COrder> grid, COrder cOrder) {
        logger.info("方法 selCOrder 开始");
        logger.debug("方法 selCOrder 开始,参数 grid:" + JSON.toJSONString(grid) + "参数 cOrder:" + JSON.toJSONString(cOrder));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(cOrderMapper.selectSelective(cOrder));
        grid.setTotal(cOrderMapper.selectSelective(cOrder).size());
        grid.setResult(true);
        logger.debug("方法 selCOrder 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selCOrder 结束");
        return grid;
    }


    public ResponseResult<COrder> selCOrderByOrderNo(String orderNo) {
        logger.info("方法 selCOrderById 开始");
        logger.debug("方法 selCOrderById 开始,参数 orderNo:" + JSON.toJSONString(orderNo));
        ResponseResult<COrder> result = new ResponseResult<>();
        COrder cOrder = cOrderMapper.selectByPrimaryKey(orderNo);
        if (StringUtil.isNotNull(cOrder)) {
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(cOrder);
        } else {
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
        if (StringUtil.isNotNull(cOrders)) {
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(cOrders);
        } else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectSelective 结束");
        return result;
    }


}
