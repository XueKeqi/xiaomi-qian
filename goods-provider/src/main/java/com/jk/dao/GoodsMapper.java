package com.jk.dao;

import com.jk.entity.*;

import com.jk.pojo.EsGoods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface GoodsMapper {
    List<Goods> findAll(@Param("mid") String mid);

    List<MiaoshaGoods> findmiaosha(Integer c);

    List<Classify> findLie(Integer num);

    List<Goods> findAie(@Param("mid") String mid,@Param("lab") String lab);

    List<EsGoods> findAlls();

    Specs queryGoodsbyIdCart(@Param("goodsId") Integer goodsId);

    Product findProductById(Integer id);

    List<Specs> findSpecsList(Integer id);
}
