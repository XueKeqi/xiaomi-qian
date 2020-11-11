package com.jk.service;

import com.jk.entity.*;

import java.util.List;

public interface GoodsService {
    List<Goods> findAll(String mid);

    List<Carouse> findCarouse();

    List<MiaoshaGoods> findmiaosha(Integer num);

    Product findProductById(Integer id);

    List<Specs> findSpecsList(Integer id);
}
