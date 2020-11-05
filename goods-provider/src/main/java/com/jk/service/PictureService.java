package com.jk.service;

import com.jk.entity.Picture;

import java.util.List;

public interface PictureService {
    List<Picture> findLun(String mid);
}
