package com.mike.resume.mapper;

import com.mike.resume.entity.CProduct;

import java.util.List;

public interface CProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CProduct record);

    int insertSelective(CProduct record);

    CProduct selectByPrimaryKey(Integer id);

    List<CProduct> selectSelective(CProduct cProduct);

    int updateByPrimaryKeySelective(CProduct record);

    int updateByPrimaryKey(CProduct record);
}