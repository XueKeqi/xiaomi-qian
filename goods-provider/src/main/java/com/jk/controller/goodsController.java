package com.jk.controller;

import com.jk.entity.Goods;
import com.jk.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class goodsController {

    @Resource
    private GoodsService goodsService;


    @RequestMapping("asd")
    public String asd(){
        return "asd";
    }


    @RequestMapping("/findAll")
    public List<Goods> findAll(){
        return goodsService.findAll();
    }







}