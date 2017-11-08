package com.mike.resume.service.impl;

import com.github.pagehelper.PageHelper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.resume.entity.Lottery;
import com.mike.resume.mapper.LotteryMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2017/6/27.
 */
@Service("lotteryService")
public class LotteryServiceImpl{
    private static Logger logger = Logger.getLogger(LotteryServiceImpl.class);

    @Autowired
    private LotteryMapper lotteryMapper;

    public ResponseResult<Lottery> selectByPrimaryKey(Integer id) {
        logger.debug("selectByPrimaryKey 开始 。。。");
        ResponseResult<Lottery> result = new ResponseResult<>();
        Lottery lottery = lotteryMapper.selectByPrimaryKey(id);
        if (lottery != null) {
            result.setCode(true);
            result.setContent(lottery);
            result.setMsg("查找成功！");
            logger.info("查找彩票期数成功 。。。");
        } else {
            result.setCode(false);
            result.setMsg("查找失败！");
            logger.info("查找彩票期数失败 。。。");
        }
        logger.debug("selectByPrimaryKey 结束 。。。 ");
        return result;
    }

    
    public BootGrid<Lottery> selectSelectiveQuery(BootGrid<Lottery> bootGrid, Lottery lottery) {
        logger.debug("selectSelective 开始 。。。");
        PageHelper.startPage(bootGrid.getCurrent(), bootGrid.getRowCount());
        bootGrid.setRows(lotteryMapper.selectSelective(lottery));
        bootGrid.setTotal(lotteryMapper.selectSelective(lottery).size());
        logger.info("条件查询彩票期数列表成功 。。。");
        logger.debug("selectSelective 结束 。。。");
        return bootGrid;
    }

    
    public ResponseResult<Lottery> deleteByPrimaryKey(Integer id) {
        logger.debug("deleteByPrimaryKey 开始 。。。");
        ResponseResult<Lottery> result = new ResponseResult<>();
        int change = lotteryMapper.deleteByPrimaryKey(id);
        if (change > 0) {
            result.setCode(true);
            result.setMsg("删除成功！");
            logger.info("删除彩票期数成功 。。。");
        } else {
            result.setCode(false);
            result.setMsg("删除失败！");
            logger.info("删除彩票期数失败 。。。");
        }
        logger.debug("deleteByPrimaryKey 结束 。。。");
        return result;
    }

    
    public ResponseResult<Lottery> insertSelective(Lottery lottery) {
        logger.debug("insertSelective 开始 。。。");
        ResponseResult<Lottery> result = new ResponseResult<>();
        int change = lotteryMapper.insertSelective(lottery);
        if (change > 0) {
            result.setCode(true);
            result.setContent(lottery);
            result.setMsg("插入成功！");
            logger.info("插入彩票期数成功 。。。");
        } else {
            result.setCode(false);
            result.setMsg("插入失败！");
            logger.info("插入彩票期数失败 。。。");
        }
        logger.debug("insertSelective 结束 。。。");
        return result;
    }

    
    public ResponseResult<Lottery> updateByPrimaryKeySelective(Lottery lottery) {
        logger.debug("updateByPrimaryKeySelective 开始 。。。");
        ResponseResult<Lottery> result = new ResponseResult<>();
        int change = lotteryMapper.updateByPrimaryKeySelective(lottery);
        if (change > 0) {
            result.setCode(true);
            result.setMsg("更新成功！");
            logger.info("更新彩票期数成功 。。。");
        } else {
            result.setCode(false);
            result.setMsg("更新失败！");
            logger.info("更新彩票期数失败 。。。");
        }
        logger.debug("updateByPrimaryKeySelective 结束 。。。");
        return result;
    }

    
    public ResponseResult<Lottery> updateByPrimaryKey(Lottery lottery) {
        logger.debug("updateByPrimaryKey 开始 。。。");
        ResponseResult<Lottery> result = new ResponseResult<>();
        int change = lotteryMapper.updateByPrimaryKey(lottery);
        if (change > 0) {
            result.setCode(true);
            result.setMsg("更新成功！");
            logger.info("更新彩票期数成功 。。。");
        } else {
            result.setCode(false);
            result.setMsg("更新失败！");
            logger.info("更新彩票期数失败 。。。");
        }
        logger.debug("updateByPrimaryKey 结束 。。。");
        return result;
    }

    
    public ResponseResult<Lottery> margeLottery(Lottery lottery) {
        ResponseResult<Lottery> result = new ResponseResult<>();
        if(lottery != null){
            if(lottery.getId() != null && lottery.getId() != 0){
                result=updateByPrimaryKeySelective(lottery);
            }else{
                result=insertSelective(lottery);
            }
        }
        return result;
    }
}
