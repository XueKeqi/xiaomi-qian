package com.jk.controller;

import com.jk.config.RedisContent;
import com.jk.entity.Carouse;
import com.jk.entity.Goods;
import com.jk.entity.Picture;
import com.jk.entity.xmUser;
import com.jk.service.GoodsService;
import com.jk.service.UserService;
import com.jk.utils.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class showController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisUtil redisUtil;




    @RequestMapping("goods/findAll")
    public Map<String, Object> findAll(String mid){
        List<Goods> list = goodsService.findAll(mid);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("replies", list);

        return map;
    }

        /*轮播图*/
        @RequestMapping("pictur/findLun")
    public Map<String, Object> findLun(Integer id){
        List<Picture> list = goodsService.findLun(id);
        System.out.print(list);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("lun", list);
        return map;
    }


    @RequestMapping("user/toLogin")
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
    public List<Carouse> findCarouse(){
        return goodsService.findCarouse();
    }





}
