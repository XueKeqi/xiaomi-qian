package com.jk.service;

import com.jk.entity.*;
import com.jk.pojo.EsGoods;

import java.util.List;

public interface GoodsService {
    List<Goods> findAll(String mid);

    List<Carouse> findCarouse();

    List<MiaoshaGoods> findmiaosha(Integer num);

    List<Classify> findLie(Integer num);

    List<Goods> findAie(String mid, String lab);

    Specs queryGoodsbyIdCart(Integer goodsId);

    Product findProductById(Integer id);

    List<Specs> findSpecsList(Integer id);

    List<Specs> findCart(String chkvalue);
}
