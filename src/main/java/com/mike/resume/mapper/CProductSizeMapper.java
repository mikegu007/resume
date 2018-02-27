package com.mike.resume.mapper;

import com.mike.resume.entity.CProductSize;

import java.util.List;

public interface CProductSizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CProductSize record);

    int insertSelective(CProductSize record);

    CProductSize selectByPrimaryKey(Integer id);

    List<CProductSize> selectSelective(CProductSize cProductSize);

    int updateByPrimaryKeySelective(CProductSize record);

    int updateByPrimaryKey(CProductSize record);
}