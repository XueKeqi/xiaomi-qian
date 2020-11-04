package com.jk.controller;

import com.jk.entity.Carouse;
import com.jk.entity.Goods;
import com.jk.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class showController {

    @Resource
    private GoodsService goodsService;




    @RequestMapping("goods/findAll")
    public Map<String, Object> findAll(){

        List<Goods> list = goodsService.findAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("replies", list);
        return map;
    }

    @RequestMapping("findCarouse")
    public List<Carouse> findCarouse(){
        return goodsService.findCarouse();
    }


}
