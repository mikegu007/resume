package com.mike.resume.mapper;

import com.mike.resume.entity.CProductTaste;

import java.util.List;

public interface CProductTasteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CProductTaste record);

    int insertSelective(CProductTaste record);

    CProductTaste selectByPrimaryKey(Integer id);

    List<CProductTaste> selectSelective(CProductTaste cProductTaste);

    int updateByPrimaryKeySelective(CProductTaste record);

    int updateByPrimaryKey(CProductTaste record);
}