package com.mike.OOFO.mapper;

import com.mike.OOFO.entity.OUser;

public interface OUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OUser record);

    int insertSelective(OUser record);

    OUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OUser record);

    int updateByPrimaryKey(OUser record);
}