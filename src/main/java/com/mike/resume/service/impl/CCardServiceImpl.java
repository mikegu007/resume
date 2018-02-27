package com.mike.resume.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.CCard;
import com.mike.resume.mapper.CCardMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2017/7/19.
 */
@Service("cCardService")
public class CCardServiceImpl {
    private static Logger logger = Logger.getLogger(CCardServiceImpl.class);

    @Autowired
    private CCardMapper cCardMapper;

    public ResponseResult<CCard> deleteByPrimaryKey(int id) {
        logger.info("方法 deleteByPrimaryKey 开始");
        logger.debug("方法 deleteByPrimaryKey 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<CCard> result = new ResponseResult<>();
        int flag = cCardMapper.deleteByPrimaryKey(id);
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

    
    public ResponseResult<CCard> insertCCard(CCard cCard) {
        logger.info("方法 insertCCard 开始");
        logger.debug("方法 insertCCard 开始,参数 cCard:" + JSON.toJSONString(cCard));
        ResponseResult<CCard> result = new ResponseResult<>();
        if (StringUtil.isNotNull(cCard)&&StringUtil.isNotNull(cCard.getId())){
            CCard cCardOld = cCardMapper.selectByPrimaryKey(cCard.getId());
            if (StringUtil.isNotNull(cCardOld)){
                result.setCode(false);
                result.setMsg("购物车已存在，请勿重复添加！");
            }else {
                int flag = cCardMapper.insertSelective(cCard);
                if (flag>0){
                    result.setCode(true);
                    result.setMsg("加入购物车成功！");
                    result.setContent(cCard);
                }else {
                    result.setCode(false);
                    result.setMsg("加入购物车失败！");
                }
            }
        }else {
            result.setCode(false);
            result.setMsg("数据有误，加入购物车失败！");
        }
        logger.debug("方法 insertCCard 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertCCard 结束");
        return result;
    }

    
    public BootGrid<CCard> selCCard(BootGrid<CCard> grid, CCard cCard) {
        logger.info("方法 selCCard 开始");
        logger.debug("方法 selCCard 开始,参数 grid:" + JSON.toJSONString(grid)+"参数 cCard:" + JSON.toJSONString(cCard));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(cCardMapper.selectSelective(cCard));
        grid.setTotal(cCardMapper.selectSelective(cCard).size());
        grid.setResult(true);
        logger.debug("方法 selCCard 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selCCard 结束");
        return grid;
    }

    
    public ResponseResult<CCard> selCCardById(int id) {
        logger.info("方法 selCCardById 开始");
        logger.debug("方法 selCCardById 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<CCard> result = new ResponseResult<>();
        CCard cCard = cCardMapper.selectByPrimaryKey(id);
        if (StringUtil.isNotNull(cCard)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(cCard);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selCCardById 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selCCardById 结束");
        return result;
    }

    
    public ResponseResult<CCard> selectSelective(CCard cCard) {
        logger.info("方法 selectSelective 开始");
        logger.debug("方法 selectSelective 开始,参数 cCard:" + JSON.toJSONString(cCard));
        ResponseResult<CCard> result = new ResponseResult<>();
        List<CCard> cCards = cCardMapper.selectSelective(cCard);
        if (StringUtil.isNotNull(cCards)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(cCards);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectSelective 结束");
        return result;
    }


}
