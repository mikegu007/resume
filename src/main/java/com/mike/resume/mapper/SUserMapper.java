package com.mike.resume.mapper;

import com.mike.resume.entity.SUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SUserMapper {
    int deleteByPrimaryKey(Integer openId);

    int insert(SUser record);

    int insertSelective(SUser record);

    SUser selectByPrimaryKey(Integer openId);

    List<SUser> selectSelective(SUser sUser);

    int updateByPrimaryKeySelective(SUser record);

    int updateByPrimaryKey(SUser record);
}