package com.jk.controller;

import com.jk.entity.xmUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

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

    @RequestMapping("/mycar")
    public String mycart(){
        return "mycar"; }

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
        String id=session.getId();
        model.addAttribute("userId","id");
        return "userOrder";
    }

}
