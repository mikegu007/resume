package com.mike.resume.mapper;

import com.mike.resume.entity.COrderDetail;

public interface COrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(COrderDetail record);

    int insertSelective(COrderDetail record);

    COrderDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(COrderDetail record);

    int updateByPrimaryKey(COrderDetail record);
}