package com.jk.dao;

import com.jk.entity.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PictureMapper {
    List<Picture> findLun(Integer mid);
}
