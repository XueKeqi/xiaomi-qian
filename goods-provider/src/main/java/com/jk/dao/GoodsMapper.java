package com.jk.dao;

import com.jk.entity.Goods;

import com.jk.entity.MiaoshaGoods;
import com.jk.entity.Product;
import com.jk.entity.Specs;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface GoodsMapper {
    List<Goods> findAll(String[] mid);

    List<MiaoshaGoods> findmiaosha(Integer c);

    Product findProductById(Integer id);

    List<Specs> findSpecsList(Integer id);
}
