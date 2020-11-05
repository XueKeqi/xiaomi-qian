package com.jk.controller;

import com.jk.entity.Carouse;
import com.jk.entity.Goods;
import com.jk.entity.Picture;
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





}
