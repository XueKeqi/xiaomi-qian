package com.jk.controller;

import com.jk.entity.Product;
import com.jk.entity.Specs;
import com.jk.entity.xmUser;
import com.jk.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private GoodsService goodsService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(){
        return "detail";
    }

    @RequestMapping("/miaosha")
    public String miaosha(){
        return "miaosha";
    }

    @RequestMapping("/cart")
    public String mycart(){
        return "cart"; }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/miList")
    public String miList(){
        return "miList";
    }
    //跳转到订单页面
    @RequestMapping("/tooOrder")
    public String tooOrder(Model model, HttpSession session){
       xmUser user= (xmUser) session.getAttribute("user");
        model.addAttribute("userOrder",user);
        return "userOrder";
    }
    /**
     * 商品详情
     * @param id
     * @param
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


    //跳转到OSS页面
    @RequestMapping("/oss")
    public String oss(){
        return "aliyunoss";
    }
    //跳转到OSS管理页面
    @RequestMapping("/oss2")
    public String oss2(){
        return "aliyunoss2";
    }
}
