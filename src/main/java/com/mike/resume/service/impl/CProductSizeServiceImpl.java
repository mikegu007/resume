package com.mike.resume.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.CProductSize;
import com.mike.resume.mapper.CProductSizeMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2017/7/19.
 */
@Service("cProductSizeService")
public class CProductSizeServiceImpl {
    private static Logger logger = Logger.getLogger(CProductSizeServiceImpl.class);

    @Autowired
    private CProductSizeMapper cProductSizeMapper;

    public ResponseResult<CProductSize> deleteByPrimaryKey(int id) {
        logger.info("方法 deleteByPrimaryKey 开始");
        logger.debug("方法 deleteByPrimaryKey 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<CProductSize> result = new ResponseResult<>();
        int flag = cProductSizeMapper.deleteByPrimaryKey(id);
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


    public ResponseResult<CProductSize> insertCProductSize(CProductSize cProductSize) {
        logger.info("方法 insertCProductSize 开始");
        logger.debug("方法 insertCProductSize 开始,参数 cProductSize:" + JSON.toJSONString(cProductSize));
        ResponseResult<CProductSize> result = new ResponseResult<>();
        if (StringUtil.isNotNull(cProductSize)&&StringUtil.isNotNull(cProductSize.getId())){
            CProductSize cProductSizeOld = cProductSizeMapper.selectByPrimaryKey(cProductSize.getId());
            if (StringUtil.isNotNull(cProductSizeOld)){
                result.setCode(false);
                result.setMsg("产品规格已存在，请勿重复添加！");
            }else {
                int flag = cProductSizeMapper.insertSelective(cProductSize);
                if (flag>0){
                    result.setCode(true);
                    result.setMsg("加入产品规格成功！");
                    result.setContent(cProductSize);
                }else {
                    result.setCode(false);
                    result.setMsg("加入产品规格失败！");
                }
            }
        }else {
            result.setCode(false);
            result.setMsg("数据有误，加入产品规格失败！");
        }
        logger.debug("方法 insertCProductSize 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertCProductSize 结束");
        return result;
    }


    public ResponseResult<CProductSize> updateCProductSize(CProductSize cProductSize) {
        logger.info("方法 updateCProductSize 开始");
        logger.debug("方法 updateCProductSize 开始,参数 cProductSize:" + JSON.toJSONString(cProductSize));
        ResponseResult<CProductSize> result = new ResponseResult<>();
        if (StringUtil.isNotNull(cProductSize) && StringUtil.isNotNull(cProductSize.getId())) {
            int flag = cProductSizeMapper.updateByPrimaryKeySelective(cProductSize);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("更新产品规格成功！");
                result.setContent(cProductSize);
            } else {
                result.setCode(false);
                result.setMsg("更新产品规格败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("数据有误，更新产品规格失败！");
        }
        logger.debug("方法 updateCProductSize 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 updateCProductSize 结束");
        return result;
    }


    public BootGrid<CProductSize> selCProductSize(BootGrid<CProductSize> grid, CProductSize cProductSize) {
        logger.info("方法 selCProductSize 开始");
        logger.debug("方法 selCProductSize 开始,参数 grid:" + JSON.toJSONString(grid)+"参数 cProductSize:" + JSON.toJSONString(cProductSize));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(cProductSizeMapper.selectSelective(cProductSize));
        grid.setTotal(cProductSizeMapper.selectSelective(cProductSize).size());
        grid.setResult(true);
        logger.debug("方法 selCProductSize 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selCProductSize 结束");
        return grid;
    }


    public ResponseResult<CProductSize> selCProductSizeById(int id) {
        logger.info("方法 selCProductSizeById 开始");
        logger.debug("方法 selCProductSizeById 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<CProductSize> result = new ResponseResult<>();
        CProductSize cProductSize = cProductSizeMapper.selectByPrimaryKey(id);
        if (StringUtil.isNotNull(cProductSize)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(cProductSize);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selCProductSizeById 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selCProductSizeById 结束");
        return result;
    }


    public ResponseResult<CProductSize> selectSelective(CProductSize cProductSize) {
        logger.info("方法 selectSelective 开始");
        logger.debug("方法 selectSelective 开始,参数 cProductSize:" + JSON.toJSONString(cProductSize));
        ResponseResult<CProductSize> result = new ResponseResult<>();
        List<CProductSize> cProductSizes = cProductSizeMapper.selectSelective(cProductSize);
        if (StringUtil.isNotNull(cProductSizes)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(cProductSizes);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectSelective 结束");
        return result;
    }


}
