package com.jk.dao;

import com.jk.entity.Picture;

import java.util.List;

public interface PictureMapper {
    List<Picture> findLun(String mid);
}
