package com.jk.dao;

import com.jk.entity.xmUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {


    xmUser findUserId(String userName);
}
