package com.jk.controller;

import com.jk.entity.Goods;
import com.jk.entity.Specs;
import com.jk.entity.xmUser;
import com.jk.service.CartService;
import com.jk.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController

public class cartController {
    @Resource
    private CartService cartService;

    @RequestMapping("cart/hasKey")
    public Boolean hasKey(@RequestParam("key") String key, @RequestParam("GoodsId") String GoodsId){
        return cartService.hasKey(key,GoodsId);
    }
    @RequestMapping("cart/hget")
    public Specs hget(@RequestParam("key") String key, @RequestParam("GoodsId") String GoodsId){
        return (Specs) cartService.hget(key,GoodsId);
    }
    @RequestMapping("cart/setHashOption")
    public void setHashOption(@RequestParam("key") String key,@RequestParam("goodsId") String GoodsId,@RequestBody Specs specs){
        cartService.setHashOption(key,GoodsId,specs);
    }

    /**
     * 查询购物车中的商品信息
     * @param key
     * @return
     */
    @RequestMapping("cart/hgetList")
    public List hgetList(@RequestParam("key") String key){
        return cartService.hgetList(key);
    }


    @RequestMapping("cart/findUserId")
    public xmUser findUserId(@RequestParam String userName){
        return cartService.findUserId(userName);
    }

}
