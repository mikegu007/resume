package com.mike.resume.mapper;

import com.mike.resume.entity.SUserToken;

public interface SUserTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SUserToken record);

    int insertSelective(SUserToken record);

    SUserToken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SUserToken record);

    int updateByPrimaryKey(SUserToken record);
}