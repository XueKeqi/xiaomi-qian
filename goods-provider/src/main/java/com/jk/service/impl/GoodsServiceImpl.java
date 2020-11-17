package com.jk.service.impl;

import com.jk.dao.CarouseMapper;
import com.jk.dao.GoodsMapper;
import com.jk.entity.*;
import com.jk.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private CarouseMapper carouseMapper;

    @Override
    public List<Goods> findAll(String mid) {
        return goodsMapper.findAll(mid);
    }

    @Override
    public List<Carouse> findCarouse() {
        return carouseMapper.findCarouse();
    }

    @Override
    public List<MiaoshaGoods> findmiaosha(Integer num) {

        return goodsMapper.findmiaosha(num);
    }

    @Override
    public List<Classify> findLie(Integer num) {



        return goodsMapper.findLie(num);
    }

    @Override
    public List<Goods> findAie(String mid, String lab) {
        return goodsMapper.findAie(mid,lab);
    }

    @Override

    public Specs queryGoodsbyIdCart(Integer goodsId) {
        return goodsMapper.queryGoodsbyIdCart(goodsId);
    }


    @Override

    public Product findProductById(Integer id) {
        return goodsMapper.findProductById(id);
    }

    @Override
    public List<Specs> findSpecsList(Integer id) {
        return goodsMapper.findSpecsList(id);
    }

}
