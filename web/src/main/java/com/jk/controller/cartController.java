package com.jk.controller;

import com.jk.entity.Goods;
import com.jk.entity.Specs;
import com.jk.entity.xmUser;
import com.jk.service.GoodsService;
import com.jk.utils.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class cartController {


    @Resource
    private GoodsService  goodsService;


    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 将商品添加到购物车
     * @param
     */
    @RequestMapping("cart/addCart")
    @ResponseBody
    public void  addCart(String goodspuId, Integer nums, HttpSession session){
        Specs specs = new Specs();
        specs.setGoodspuId(Integer.parseInt(goodspuId));
        specs.setNum(nums);

        //从session中获取当前用户
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        xmUser user= (xmUser) request.getSession().getAttribute("user");
        String userName=user.getUserName();
        xmUser user2 = goodsService.findUserId(userName);

        //去数据库查询商品信息
        Integer a  = specs.getGoodspuId();

        Specs specs1 =goodsService.queryGoodsbyIdCart(a);
        String key="cart"+"_"+user2.getUserId();

        //下一个方法有用，自己看
        session.setAttribute("key",key);


        /*goodsService.hasKey(key,goodspuId);*/
        boolean isExist=redisUtil.hasKey(key);
        if(isExist){
            //查询存在的商品信息
            Specs specs2 = (Specs)redisUtil.hget(key, goodspuId);

            if (specs2 == null){
                //获取前台购买的数量
                specs1.setNum(specs.getNum());
                //给商品小计赋值
                specs1.setPriceNum(specs.getNum()*specs1.getPrice());

                redisUtil.hset(key,goodspuId,specs1);

            }else {
                int num = specs.getNum() + specs2.getNum();
                specs1.setNum(num);
                //给商品的小计赋值
                specs1.setPriceNum(num*specs2.getPrice());
                //存入reids
                redisUtil.hset(key,goodspuId,specs1);
            }


        }else {
            //获取前台购买的数量
            specs1.setNum(specs.getNum());
            //给商品小计赋值
            specs1.setPriceNum(specs.getNum()*specs1.getPrice());
            //存入redis
            redisUtil.hset(key,goodspuId,specs1);


        }
    }
    /*
    * 查询购物车
    *
    * */
    @RequestMapping("cart/queryCart")
    public String queryCart(Model model){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        xmUser user = (xmUser) request.getSession().getAttribute("user");


        //key
        //String key="cart"+"_"+user.getUserId();
        String key="cart"+"_"+1;
        Map<Object, Object> hmget = redisUtil.hmget(key);

        //获取map所有的key
        Set<Object> keys = hmget.keySet();

        Specs specs =goodsService.queryGoodsbyIdCart(63);

        List<Specs> list = new ArrayList<Specs>();
        list.add(specs);

       // ModelAndView mav = new ModelAndView("cart");
        //mav.addObject("goodsList",list);
        model.addAttribute("goodsList",list);

        return "redirect:/cart";
    }




}
