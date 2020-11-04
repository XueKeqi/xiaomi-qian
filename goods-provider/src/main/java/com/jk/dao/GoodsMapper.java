package com.jk.dao;

import com.jk.entity.Goods;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface GoodsMapper {
    List<Goods> findAll(String[] mid);
}
