package com.mike.OOFO.mapper;

import com.mike.OOFO.entity.OUserinfo;

public interface OUserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OUserinfo record);

    int insertSelective(OUserinfo record);

    OUserinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OUserinfo record);

    int updateByPrimaryKey(OUserinfo record);
}