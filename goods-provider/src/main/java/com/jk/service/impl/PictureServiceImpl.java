package com.jk.service.impl;

import com.jk.dao.PictureMapper;
import com.jk.entity.Picture;
import com.jk.service.PictureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {


    @Resource
    private PictureMapper pictureMapper;

    @Override
    public List<Picture> findLun(String mid) {
        return pictureMapper.findLun(mid);
    }
}
