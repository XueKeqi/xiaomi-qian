package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.config.RedisContent;
import com.jk.entity.*;
import com.jk.service.GoodsService;
import com.jk.service.UserService;
import com.jk.utils.RedisUtil;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class showController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 商品详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("product/detail")
    public String detail(Integer id,Model m){
        //产品系列信息：比如 小米 10、Redmi P30
        Product product=goodsService.findProductById(id);
        //产品系列下的具体商品列表：比如 '小米 10 XX版本 XX颜色'
        List<Specs> specsList=goodsService.findSpecsList(id);
        m.addAttribute("id",id);
        m.addAttribute("product",product);
        m.addAttribute("specsList",specsList);
        return "detail";
    }


    @RequestMapping("goods/findAll")
    @ResponseBody
    public List<Goods> findAll(String mid){
        List<Goods> goodsList = (List)redisUtil.get(RedisContent.GOODS_LIST_KEY );
        if(goodsList == null || goodsList.isEmpty()) {
            goodsList = goodsService.findAll(mid);
            redisUtil.set(RedisContent.GOODS_LIST_KEY, goodsList);
            // 设置key的过期时间
            //redisUtil.expire(RedisContent.GOODS_LIST_KEY , 60);
        }

        return goodsList;
    }



    @RequestMapping("goods/findmiao")
    @ResponseBody
    public List<MiaoshaGoods> findmiao(Integer num){
        return goodsService.findmiaosha(num);
    }



    /*轮播图*/
    @RequestMapping("pictur/findLun")
    @ResponseBody
    public Map<String, Object> findLun(Integer id){
        List<Picture> list = goodsService.findLun(id);
        System.out.print(list);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("lun", list);
        return map;
    }

    @RequestMapping("user/toLogin")
    @ResponseBody
    public String toLogin(xmUser user,HttpSession session){
        xmUser user2 =userService.toLogin(user);
        if(user2==null){
            return"请输入账号和密码";
        }
        if(!user2.getUserPassword().equals(user.getUserPassword())){
            return "密码不正确";
        }

        return "登录成功";
    }


    @RequestMapping("findCarouse")
    @ResponseBody
    public List<Carouse> findCarouse(){
        return goodsService.findCarouse();
    }





}
