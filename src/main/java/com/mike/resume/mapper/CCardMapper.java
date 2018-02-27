package com.mike.resume.mapper;

import com.mike.resume.entity.CCard;

public interface CCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CCard record);

    int insertSelective(CCard record);

    CCard selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CCard record);

    int updateByPrimaryKey(CCard record);
}