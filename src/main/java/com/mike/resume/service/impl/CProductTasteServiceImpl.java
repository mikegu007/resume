package com.mike.resume.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.CProductTaste;
import com.mike.resume.mapper.CProductTasteMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2017/7/19.
 */
@Service("cProductTasteService")
public class CProductTasteServiceImpl {
    private static Logger logger = Logger.getLogger(CProductTasteServiceImpl.class);

    @Autowired
    private CProductTasteMapper cProductTasteMapper;

    public ResponseResult<CProductTaste> deleteByPrimaryKey(int id) {
        logger.info("方法 deleteByPrimaryKey 开始");
        logger.debug("方法 deleteByPrimaryKey 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<CProductTaste> result = new ResponseResult<>();
        int flag = cProductTasteMapper.deleteByPrimaryKey(id);
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

    
    public ResponseResult<CProductTaste> insertCProductTaste(CProductTaste cProductTaste) {
        logger.info("方法 insertCProductTaste 开始");
        logger.debug("方法 insertCProductTaste 开始,参数 cProductTaste:" + JSON.toJSONString(cProductTaste));
        ResponseResult<CProductTaste> result = new ResponseResult<>();
        if (StringUtil.isNotNull(cProductTaste)&&StringUtil.isNotNull(cProductTaste.getId())){
            CProductTaste cProductTasteOld = cProductTasteMapper.selectByPrimaryKey(cProductTaste.getId());
            if (StringUtil.isNotNull(cProductTasteOld)){
                result.setCode(false);
                result.setMsg("产品口味已存在，请勿重复添加！");
            }else {
                int flag = cProductTasteMapper.insertSelective(cProductTaste);
                if (flag>0){
                    result.setCode(true);
                    result.setMsg("加入产品口味成功！");
                    result.setContent(cProductTaste);
                }else {
                    result.setCode(false);
                    result.setMsg("加入产品口味失败！");
                }
            }
        }else {
            result.setCode(false);
            result.setMsg("数据有误，加入产品口味失败！");
        }
        logger.debug("方法 insertCProductTaste 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertCProductTaste 结束");
        return result;
    }

    public ResponseResult<CProductTaste> updateCProductTaste(CProductTaste cProductTaste) {
        logger.info("方法 updateCProductTaste 开始");
        logger.debug("方法 updateCProductTaste 开始,参数 cProductTaste:" + JSON.toJSONString(cProductTaste));
        ResponseResult<CProductTaste> result = new ResponseResult<>();
        if (StringUtil.isNotNull(cProductTaste) && StringUtil.isNotNull(cProductTaste.getId())) {
            int flag = cProductTasteMapper.updateByPrimaryKeySelective(cProductTaste);
            if (flag > 0) {
                result.setCode(true);
                result.setMsg("更新产品口味成功！");
                result.setContent(cProductTaste);
            } else {
                result.setCode(false);
                result.setMsg("更新产品口味败！");
            }
        } else {
            result.setCode(false);
            result.setMsg("数据有误，更新产品口味失败！");
        }
        logger.debug("方法 updateCProductTaste 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 updateCProductTaste 结束");
        return result;
    }
    
    
    
    

    
    public BootGrid<CProductTaste> selCProductTaste(BootGrid<CProductTaste> grid, CProductTaste cProductTaste) {
        logger.info("方法 selCProductTaste 开始");
        logger.debug("方法 selCProductTaste 开始,参数 grid:" + JSON.toJSONString(grid)+"参数 cProductTaste:" + JSON.toJSONString(cProductTaste));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(cProductTasteMapper.selectSelective(cProductTaste));
        grid.setTotal(cProductTasteMapper.selectSelective(cProductTaste).size());
        grid.setResult(true);
        logger.debug("方法 selCProductTaste 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selCProductTaste 结束");
        return grid;
    }

    
    public ResponseResult<CProductTaste> selCProductTasteById(int id) {
        logger.info("方法 selCProductTasteById 开始");
        logger.debug("方法 selCProductTasteById 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<CProductTaste> result = new ResponseResult<>();
        CProductTaste cProductTaste = cProductTasteMapper.selectByPrimaryKey(id);
        if (StringUtil.isNotNull(cProductTaste)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(cProductTaste);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selCProductTasteById 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selCProductTasteById 结束");
        return result;
    }

    
    public ResponseResult<CProductTaste> selectSelective(CProductTaste cProductTaste) {
        logger.info("方法 selectSelective 开始");
        logger.debug("方法 selectSelective 开始,参数 cProductTaste:" + JSON.toJSONString(cProductTaste));
        ResponseResult<CProductTaste> result = new ResponseResult<>();
        List<CProductTaste> cProductTastes = cProductTasteMapper.selectSelective(cProductTaste);
        if (StringUtil.isNotNull(cProductTastes)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(cProductTastes);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectSelective 结束");
        return result;
    }


}
