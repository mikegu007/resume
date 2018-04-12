package com.mike.OOFO.mapper;

import com.mike.OOFO.entity.OUserCon;

import java.util.List;

public interface OUserConMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OUserCon record);

    int insertSelective(OUserCon record);

    OUserCon selectByPrimaryKey(Integer id);

    OUserCon selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(OUserCon record);

    int updateByPrimaryKey(OUserCon record);

    List<OUserCon> selectSelective(OUserCon oUserCon);
}