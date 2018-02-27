package com.mike.resume.mapper;

import com.mike.resume.entity.SUserToken;

import java.util.List;

public interface SUserTokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SUserToken record);

    int insertSelective(SUserToken record);

    SUserToken selectByPrimaryKey(Integer id);

    List<SUserToken> selectSelective(SUserToken sUserToken);

    int updateByPrimaryKeySelective(SUserToken record);

    int updateByPrimaryKey(SUserToken record);
}