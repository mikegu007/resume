package com.mike.resume.mapper;

import com.mike.resume.entity.COrder;

public interface COrderMapper {
    int deleteByPrimaryKey(String orderNo);

    int insert(COrder record);

    int insertSelective(COrder record);

    COrder selectByPrimaryKey(String orderNo);

    int updateByPrimaryKeySelective(COrder record);

    int updateByPrimaryKey(COrder record);
}