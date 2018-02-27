package com.mike.resume.mapper;

import com.mike.resume.entity.SUserAddress;

public interface SUserAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SUserAddress record);

    int insertSelective(SUserAddress record);

    SUserAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SUserAddress record);

    int updateByPrimaryKey(SUserAddress record);
}