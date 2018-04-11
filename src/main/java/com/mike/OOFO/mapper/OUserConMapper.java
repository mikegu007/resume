package com.mike.OOFO.mapper;

import com.mike.OOFO.entity.OUserCon;

public interface OUserConMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OUserCon record);

    int insertSelective(OUserCon record);

    OUserCon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OUserCon record);

    int updateByPrimaryKey(OUserCon record);
}