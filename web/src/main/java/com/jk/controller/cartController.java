package com.jk.controller;

import com.jk.entity.Goods;
import com.jk.entity.Specs;
import com.jk.entity.xmUser;
import com.jk.service.GoodsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class cartController {


    @Resource
    private GoodsService  goodsService;

    /**
     * 将商品添加到购物车
     * @param specs
     */
//    @RequestMapping("cart/addCart")
//    public void  addCart(Specs specs){
//        //从session中获取当前用户
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        xmUser user= (xmUser) request.getSession().getAttribute("user");
//        Integer goodspuId = specs.getGoodspuId();
//        //去数据库查询商品信息
//        Specs specs1 =goodsService.queryGoodsbyIdCart(goodspuId);
//        String key="cart"+user.getUserId();
//        boolean isExist=goodsService.hasKey(key,goodspuId);
//        if(isExist){
//            //查询存在的商品信息
//            Specs specs2 = goodsService.hget(key, goodspuId);
//            int num = specs.getNum() + specs2.getNum();
//            specs1.setNum(num);
//            //给商品的小计赋值
//            specs1.setPriceNum(num*specs2.getPrice());
//            //存入reids
//            goodsService.setHashOption(key,goodspuId, specs);
//        }else {
//            //获取前台购买的数量
//            specs1.setNum(specs.getNum());
//            //给商品小计赋值
//            specs1.setPriceNum(specs.getNum()*specs1.getPrice());
//            //存入redis
//            goodsService.setHashOption(key,goodspuId, specs);
//        }
//    }


    /**
     * 将商品添加到购物车
     * @param
     */
    @RequestMapping("cart/addCart")
    public void  addCart(String goodspuId,Integer nums){
        Specs specs = new Specs();
        specs.setGoodspuId(Integer.parseInt(goodspuId));
        specs.setNum(nums);

        //从session中获取当前用户
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        xmUser user= (xmUser) request.getSession().getAttribute("user");
        String userName=user.getUserName();
        xmUser user2 = goodsService.findUserId(userName);

        //去数据库查询商品信息
        Specs specs1 =goodsService.queryGoodsbyIdCart(specs.getGoodspuId());
        String key="cart"+user2.getUserId();
        boolean isExist=goodsService.hasKey(key,goodspuId);
        if(isExist){
            //查询存在的商品信息
            Specs specs2 = goodsService.hget(key,goodspuId);
            int num = specs.getNum() + specs2.getNum();
            specs1.setNum(num);
            //给商品的小计赋值
            specs1.setPriceNum(num*specs2.getPrice());
            //存入reids
            goodsService.setHashOption(key,goodspuId, specs1);
        }else {
            //获取前台购买的数量
            specs1.setNum(specs.getNum());
            //给商品小计赋值
            specs1.setPriceNum(specs.getNum()*specs1.getPrice());
            //存入redis
            goodsService.setHashOption(key,goodspuId, specs1);
        }
    }
    /*
    * 查询购物车
    *
    * */
    @RequestMapping("cart/queryCart")
    public ModelAndView queryCart(Goods goods){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        xmUser user = (xmUser) request.getSession().getAttribute("user");
        String key="cart"+user.getUserId();
        //查询出购物车中的所有商品
        List<Goods> goodsList = goodsService.hgetList(key);
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject("goodsList",goodsList);
        return mav;
    }


}
