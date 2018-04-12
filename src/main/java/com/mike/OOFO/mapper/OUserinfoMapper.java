package com.mike.OOFO.mapper;

import com.mike.OOFO.entity.OUserinfo;

import java.util.List;

public interface OUserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OUserinfo record);

    int insertSelective(OUserinfo record);

    OUserinfo selectByPrimaryKey(Integer id);

    OUserinfo selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(OUserinfo record);

    int updateByPrimaryKey(OUserinfo record);

    List<OUserinfo> selectSelective(OUserinfo oUserinfo);

}