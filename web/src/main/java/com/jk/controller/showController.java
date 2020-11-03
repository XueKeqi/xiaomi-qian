package com.jk.controller;

import com.jk.entity.Carouse;
import com.jk.entity.Goods;
import com.jk.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/web")
public class showController {

    @Resource
    private GoodsService goodsService;




    @RequestMapping("findAll")
    public List<Goods> findAll(){
        return goodsService.findAll();
    }

    @RequestMapping("findCarouse")
    public List<Carouse> findCarouse(){
        return goodsService.findCarouse();
    }


}
