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

    @RequestMapping("/mycart")
    public String mycart(){
        return "mycart";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/mycar")
    public String mycar() { return "mycar";}

}
