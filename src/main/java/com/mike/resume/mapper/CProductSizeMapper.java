package com.mike.resume.mapper;

import com.mike.resume.entity.CProductSize;

public interface CProductSizeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CProductSize record);

    int insertSelective(CProductSize record);

    CProductSize selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CProductSize record);

    int updateByPrimaryKey(CProductSize record);
}