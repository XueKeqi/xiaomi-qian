package com.jk.dao;

import com.jk.entity.Classify;
import com.jk.entity.Goods;

import com.jk.entity.MiaoshaGoods;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface GoodsMapper {
    List<Goods> findAll(String[] mid);

    List<MiaoshaGoods> findmiaosha(Integer c);

    List<Classify> findLie(Integer num);
}
