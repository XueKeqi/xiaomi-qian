package com.jk.dao;

import com.jk.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UsersMapper {
    List<Users> findAll();
}
