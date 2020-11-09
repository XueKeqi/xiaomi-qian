package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "mycar";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
