package com.example.demo_ssm.mapper;

import com.example.demo_ssm.controller.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper // <--- 必须加这个
public interface UserMapper {
    public TUser getUserById(@Param("id") Long id);


}
