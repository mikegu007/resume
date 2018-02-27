package com.mike.resume.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.mike.common.BootGrid;
import com.mike.common.ResponseResult;
import com.mike.common.StringUtil;
import com.mike.resume.entity.CProduct;
import com.mike.resume.mapper.CProductMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike on 2017/7/19.
 */
@Service("cProductService")
public class CProductServiceImpl {
    private static Logger logger = Logger.getLogger(CProductServiceImpl.class);

    @Autowired
    private CProductMapper cProductMapper;

    public ResponseResult<CProduct> deleteByPrimaryKey(int id) {
        logger.info("方法 deleteByPrimaryKey 开始");
        logger.debug("方法 deleteByPrimaryKey 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<CProduct> result = new ResponseResult<>();
        int flag = cProductMapper.deleteByPrimaryKey(id);
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

    
    public ResponseResult<CProduct> insertCProduct(CProduct cProduct) {
        logger.info("方法 insertCProduct 开始");
        logger.debug("方法 insertCProduct 开始,参数 cProduct:" + JSON.toJSONString(cProduct));
        ResponseResult<CProduct> result = new ResponseResult<>();
        if (StringUtil.isNotNull(cProduct)&&StringUtil.isNotNull(cProduct.getId())){
            CProduct cProductOld = cProductMapper.selectByPrimaryKey(cProduct.getId());
            if (StringUtil.isNotNull(cProductOld)){
                result.setCode(false);
                result.setMsg("产品已存在，请勿重复添加！");
            }else {
                int flag = cProductMapper.insertSelective(cProduct);
                if (flag>0){
                    result.setCode(true);
                    result.setMsg("加入产品成功！");
                    result.setContent(cProduct);
                }else {
                    result.setCode(false);
                    result.setMsg("加入产品失败！");
                }
            }
        }else {
            result.setCode(false);
            result.setMsg("数据有误，加入产品失败！");
        }
        logger.debug("方法 insertCProduct 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 insertCProduct 结束");
        return result;
    }

    
    public BootGrid<CProduct> selCProduct(BootGrid<CProduct> grid, CProduct cProduct) {
        logger.info("方法 selCProduct 开始");
        logger.debug("方法 selCProduct 开始,参数 grid:" + JSON.toJSONString(grid)+"参数 cProduct:" + JSON.toJSONString(cProduct));
        PageHelper.startPage(grid.getCurrent(), grid.getRowCount());
        grid.setRows(cProductMapper.selectSelective(cProduct));
        grid.setTotal(cProductMapper.selectSelective(cProduct).size());
        grid.setResult(true);
        logger.debug("方法 selCProduct 结束，return:" + JSON.toJSONString(grid));
        logger.info("方法 selCProduct 结束");
        return grid;
    }

    
    public ResponseResult<CProduct> selCProductById(int id) {
        logger.info("方法 selCProductById 开始");
        logger.debug("方法 selCProductById 开始,参数 id:" + JSON.toJSONString(id));
        ResponseResult<CProduct> result = new ResponseResult<>();
        CProduct cProduct = cProductMapper.selectByPrimaryKey(id);
        if (StringUtil.isNotNull(cProduct)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setContent(cProduct);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selCProductById 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selCProductById 结束");
        return result;
    }

    
    public ResponseResult<CProduct> selectSelective(CProduct cProduct) {
        logger.info("方法 selectSelective 开始");
        logger.debug("方法 selectSelective 开始,参数 cProduct:" + JSON.toJSONString(cProduct));
        ResponseResult<CProduct> result = new ResponseResult<>();
        List<CProduct> cProducts = cProductMapper.selectSelective(cProduct);
        if (StringUtil.isNotNull(cProducts)){
            result.setCode(true);
            result.setMsg("查询成功");
            result.setResult(cProducts);
        }else {
            result.setCode(false);
            result.setMsg("查询失败");
        }
        logger.debug("方法 selectSelective 结束，return:" + JSON.toJSONString(result));
        logger.info("方法 selectSelective 结束");
        return result;
    }


}
