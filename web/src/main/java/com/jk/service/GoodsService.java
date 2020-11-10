package com.jk.service;

import com.jk.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "goods")
public interface GoodsService {

    @RequestMapping("goods/findAll")
    public List<Goods> findAll(@RequestParam String mid);

    @RequestMapping("pictur/findLun")
    public List<Picture> findLun(@RequestParam Integer mid);

    @RequestMapping("miaosha/findmiaosha")
    public List<MiaoshaGoods> findmiaosha(@RequestParam Integer num);


    @RequestMapping("goods/findCarouse")
    public List<Carouse> findCarouse();

    @RequestMapping("goods/findLie")
    List<Classify> findLie(@RequestParam Integer num);

    @RequestMapping("goods/findAie")
    List<Goods> findAie(@RequestParam String mid, @RequestParam String lab);
}
