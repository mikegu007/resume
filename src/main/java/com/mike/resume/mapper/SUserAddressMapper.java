package com.mike.resume.mapper;

import com.mike.resume.entity.SUserAddress;

import java.util.List;

public interface SUserAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SUserAddress record);

    int insertSelective(SUserAddress record);

    SUserAddress selectByPrimaryKey(Integer id);

    List<SUserAddress> selectByOpenId(String openId);

    List<SUserAddress> selectSelective(SUserAddress sUserAddress);

    int updateByPrimaryKeySelective(SUserAddress record);

    int updateByPrimaryKey(SUserAddress record);
}