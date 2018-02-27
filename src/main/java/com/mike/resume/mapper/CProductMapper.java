package com.mike.resume.mapper;

import com.mike.resume.entity.CProduct;

public interface CProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CProduct record);

    int insertSelective(CProduct record);

    CProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CProduct record);

    int updateByPrimaryKey(CProduct record);
}