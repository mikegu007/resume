package com.mike.resume.mapper;

import com.mike.resume.entity.COrder;

import java.util.List;

public interface COrderMapper {
    int deleteByPrimaryKey(String orderNo);

    int insert(COrder record);

    int insertSelective(COrder record);

    COrder selectByPrimaryKey(String orderNo);

    List<COrder> selectSelective(COrder cOrder);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);
}