package com.jk.service;

import com.jk.entity.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
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


    @RequestMapping("goods/findByName")
    List<Goods> findByName(@RequestParam String name);

    @RequestMapping("goods/queryGoodsbyIdCart")
    public Specs queryGoodsbyIdCart(@RequestParam("goodsId") Integer goodsId);

    @RequestMapping("cart/hasKey")
    public Boolean hasKey(@RequestParam("key") String key, @RequestParam("GoodsId") String GoodsId);

    @RequestMapping("cart/hget")
    public Specs hget(@RequestParam("key") String key, @RequestParam("GoodsId") String GoodsId);

    @RequestMapping("cart/setHashOption")
    public void setHashOption(@RequestParam("key") String key, @RequestParam("goodsId") String GoodsId, @RequestBody Specs goods);

    @RequestMapping("cart/hgetList")
    public List hgetList(@RequestParam("key") String key);

    @RequestMapping("cart/findUserId")
    public xmUser findUserId(@RequestParam String userName);


    @RequestMapping("goods/findProductById")
    Product findProductById(@RequestParam Integer id);


    @RequestMapping("goods/findSpecsList")
    List<Specs> findSpecsList(@RequestParam Integer id);


    @RequestMapping("goods/findCart")
    List<Specs> findCart(@RequestParam String chkvalue);
}
