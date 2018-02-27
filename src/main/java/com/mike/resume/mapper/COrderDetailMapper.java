package com.mike.resume.mapper;

import com.mike.resume.entity.COrderDetail;

import java.util.List;

public interface COrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(COrderDetail record);

    int insertSelective(COrderDetail record);

    COrderDetail selectByPrimaryKey(Integer id);

    List<COrderDetail> selectSelective(COrderDetail cOrderDetail);

    int updateByPrimaryKeySelective(COrderDetail record);

    int updateByPrimaryKey(COrderDetail record);
}