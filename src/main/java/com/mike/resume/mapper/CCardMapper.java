package com.mike.resume.mapper;

import com.mike.resume.entity.CCard;

import java.util.List;

public interface CCardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CCard record);

    int insertSelective(CCard record);

    CCard selectByPrimaryKey(Integer id);

    List<CCard> selectSelective(CCard cCard);

    int updateByPrimaryKeySelective(CCard record);

    int updateByPrimaryKey(CCard record);
}