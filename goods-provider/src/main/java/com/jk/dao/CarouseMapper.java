package com.jk.dao;

import com.jk.entity.Carouse;

import java.util.List;

public interface CarouseMapper {
    int deleteByPrimaryKey(Integer siId);

    int insert(Carouse record);

    int insertSelective(Carouse record);

    Carouse selectByPrimaryKey(Integer siId);

    int updateByPrimaryKeySelective(Carouse record);

    int updateByPrimaryKey(Carouse record);

    List<Carouse> findCarouse();
}