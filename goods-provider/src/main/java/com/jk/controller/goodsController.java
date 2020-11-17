package com.jk.controller;

import com.jk.entity.*;
import com.jk.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController

public class goodsController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping("goods/findAll")
    public List<Goods> findAll(@RequestParam String mid){
        return goodsService.findAll(mid);
    }

    @RequestMapping("goods/findCarouse")
    public List<Carouse> findCarouse(){
        return goodsService.findCarouse();
    }

    @RequestMapping("miaosha/findmiaosha")
    public List<MiaoshaGoods> findmiaosha(@RequestParam Integer num){
        return goodsService.findmiaosha(num);
    }

    @RequestMapping("goods/findLie")
    List<Classify> findLie(@RequestParam Integer num){
        return goodsService.findLie(num);
    }

    @RequestMapping("goods/findAie")
    List<Goods> findAie(@RequestParam String mid, @RequestParam String lab){
        return goodsService.findAie(mid,lab);
    }


    @RequestMapping("goods/queryGoodsbyIdCart")
    public Specs queryGoodsbyIdCart(@RequestParam("goodsId") Integer goodsId){
        Specs specs = goodsService.queryGoodsbyIdCart(goodsId);
        return specs;
    }
    @RequestMapping("goods/findProductById")
    Product findProductById(@RequestParam Integer id){
        return goodsService.findProductById(id);
    };
    @RequestMapping("goods/findSpecsList")
    List<Specs> findSpecsList(@RequestParam Integer id){
        return goodsService.findSpecsList(id);
    };

}
