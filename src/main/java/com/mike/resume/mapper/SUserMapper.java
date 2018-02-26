package com.mike.resume.mapper;

import com.mike.resume.entity.SUser;

public interface SUserMapper {
    int deleteByPrimaryKey(Integer openId);

    int insert(SUser record);

    int insertSelective(SUser record);

    SUser selectByPrimaryKey(Integer openId);

    int updateByPrimaryKeySelective(SUser record);

    int updateByPrimaryKey(SUser record);
}