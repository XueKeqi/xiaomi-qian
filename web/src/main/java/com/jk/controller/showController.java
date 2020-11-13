package com.jk.controller;

import com.alibaba.fastjson.JSONObject;
import com.jk.config.RedisContent;
import com.jk.entity.*;
import com.jk.service.GoodsService;
import com.jk.service.UserService;
import com.jk.utils.CheckSumBuilder;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.RedisUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    public List<Goods> findAll(String mid){
        /*List<Goods> goodsList = (List)redisUtil.get(RedisContent.GOODS_LIST_KEY );
        if(goodsList == null || goodsList.isEmpty()) {
            goodsList = goodsService.findAll(mid);
            redisUtil.set(RedisContent.GOODS_LIST_KEY, goodsList);
            // 设置key的过期时间
            redisUtil.expire(RedisContent.GOODS_LIST_KEY , 60);
        }*/

        List<Goods> goodsList = goodsService.findAll(mid);



        return goodsList;
    }

    @RequestMapping("goods/findAlla")
    public List<Goods> findAlla(String mid){

        List<Goods> goodsList = (List)redisUtil.get(RedisContent.GOODS_LIST_KEY+"_"+mid );
        if(goodsList == null || goodsList.isEmpty()) {
            goodsList = goodsService.findAll(mid);
            redisUtil.set(RedisContent.GOODS_LIST_KEY+"_"+mid, goodsList);
            // 设置key的过期时间
            redisUtil.expire(RedisContent.GOODS_LIST_KEY+"_"+mid , 600);
        }

        return goodsList;
    }



    @RequestMapping("goods/findmiao")
    public List<MiaoshaGoods> findmiao(Integer num){
        return goodsService.findmiaosha(num);
    }



    /*轮播图*/
    @RequestMapping("pictur/findLun")
    public List<Picture> findLun(Integer id){

        List<Picture> goodsLunList = (List)redisUtil.get(RedisContent.GOODS_LUNLIST_KEY+"_"+id );
        if(goodsLunList == null){
            goodsLunList = goodsService.findLun(id);
            redisUtil.set(RedisContent.GOODS_LUNLIST_KEY+"_"+id, goodsLunList);
            // 设置key的过期时间
            redisUtil.expire(RedisContent.GOODS_LUNLIST_KEY+"_"+id , 600);
        }
        return goodsLunList;
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
        session.setAttribute("user",user2);
        return "登录成功";
    }
    @RequestMapping("user/findSession")
    @ResponseBody
    public xmUser findSession(HttpSession session) {
        return (xmUser) session.getAttribute("user");
    }





    @RequestMapping("findCarouse")
    public List<Carouse> findCarouse(){
        return goodsService.findCarouse();
    }


    @RequestMapping("goods/findLie")
    public List<Classify> findLie(Integer num){

        List<Classify> list = goodsService.findLie(num);
        List<Classify> lista = new ArrayList<Classify>();

        for (int i=0; i<list.size(); i++){
            Classify c = new Classify();
            String val = list.get(i).getValue();
            String[] split = val.split("，");
            c.setId(list.get(i).getId());
            c.setKey(list.get(i).getKey());
            c.setValue(list.get(i).getValue());
            c.setCategoryId(list.get(i).getCategoryId());
            c.setArr(split);
            lista.add(c);
        }



            return lista;
    }



    @RequestMapping("goods/findAie")
    public List<Goods> findAie(String mid,String lab){
       List<Goods> goodsList = goodsService.findAie(mid,lab);
       return goodsList;
    }



    //获取验证码
    @RequestMapping("user/getCode")

    public String getCode(String phoneNUmber) {
        Object object = redisTemplate.opsForValue().get(phoneNUmber);
        if (object!=null) {
            return "您已发送验证码，请稍后再试";
        }
        String url = "https://api.netease.im/sms/sendcode.action";
        HashMap<String, Object> headparams = new HashMap<String, Object>();
        HashMap<String, Object> params = new HashMap<String, Object>();

        String appKey = "8c982d891cc8875adc2974e43d47b150";
        long nonce = Math.round((Math.random()*899999+100000));
        long curTime = System.currentTimeMillis()/1000;
        String appSecret = "27a66ea21ea5";
        String checkSum = CheckSumBuilder.getCheckSum(appSecret , nonce+"", curTime+"");
        headparams.put("AppKey", appKey);
        headparams.put("Nonce", nonce);
        headparams.put("CurTime", curTime);
        headparams.put("CheckSum", checkSum);

        params.put("mobile", phoneNUmber);
        params.put("templateid", "14874457");
        params.put("authCode", nonce);

        String value = HttpClientUtil.post2(url, headparams, params);
        JSONObject valueObj = JSONObject.parseObject(value);
        int code = valueObj.getIntValue("code");
        if (code==200) {
            redisTemplate.opsForValue().set(phoneNUmber, nonce,10, TimeUnit.MINUTES);
            return "验证码发送成功";
        }
        return "验证码发送失败";
    }

    //登录
    @RequestMapping("user/logIn")
    @ResponseBody
    public String logIn(String phoneNUmber, String verificationCode) {
        Object object = redisTemplate.opsForValue().get(phoneNUmber);
        String code2 = object.toString();
        if (object==null || !verificationCode.equals(code2)) {
            return "验证码错误";
        }
        redisTemplate.delete(phoneNUmber);
        return "登陆成功";
    }

}
