package com.jk.service;

import com.jk.entity.Carouse;
import com.jk.entity.Goods;
import com.jk.entity.Picture;

import java.util.List;

public interface GoodsService {
    List<Goods> findAll(String mid);

    List<Carouse> findCarouse();


}
