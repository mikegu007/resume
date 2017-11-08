package com.mike.resume.mapper;

import com.mike.resume.entity.SUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SUserMapper {
    int deleteByPrimaryKey(String code);

    int insert(SUser record);

    int insertSelective(SUser record);

    SUser selectByPrimaryKey(String code);

    List<SUser> selectSelective(SUser record);

    int updateByPrimaryKeySelective(SUser record);

    int updateByPrimaryKey(SUser record);

    /**
     * 通过userCode查询User
     * @param code
     * @return
     */
    SUser findByCode(@Param("code")String code);

    /**
     * 通过email查询User
     * @param email
     * @return
     */
    SUser findByEmail(@Param("email")String email);

    /**
     * 通过手机号查询User
     * @param phone
     * @return
     */
    SUser findByPhone(@Param("phone")Long phone);
}