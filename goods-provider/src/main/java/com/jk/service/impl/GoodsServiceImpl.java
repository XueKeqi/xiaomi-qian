package com.jk.service.impl;

import com.jk.dao.CarouseMapper;
import com.jk.dao.GoodsMapper;
import com.jk.entity.Carouse;
import com.jk.entity.Goods;
import com.jk.entity.MiaoshaGoods;
import com.jk.entity.Picture;
import com.jk.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private CarouseMapper carouseMapper;

    @Override
    public List<Goods> findAll(String mid) {
        String[] mids=mid.split(",");
        return goodsMapper.findAll(mids);
    }

    @Override
    public List<Carouse> findCarouse() {
        return carouseMapper.findCarouse();
    }

    @Override
    public List<MiaoshaGoods> findmiaosha(Integer num) {

        return goodsMapper.findmiaosha(num);
    }


}
