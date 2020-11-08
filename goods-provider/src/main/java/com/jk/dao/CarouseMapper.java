package com.jk.dao;

import com.jk.entity.Carouse;
import com.jk.entity.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CarouseMapper {
    int deleteByPrimaryKey(Integer siId);

    int insert(Carouse record);

    int insertSelective(Carouse record);

    Carouse selectByPrimaryKey(Integer siId);

    int updateByPrimaryKeySelective(Carouse record);

    int updateByPrimaryKey(Carouse record);

    List<Carouse> findCarouse();

    List<Picture> findLun(String mid);
}