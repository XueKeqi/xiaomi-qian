package com.jk.controller;


import com.jk.entity.xmUser;
import com.jk.service.userService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class userController {
    @Resource
    private userService userService;

    @RequestMapping("/toLogin")
    public String toLogin(@RequestBody xmUser user, HttpSession session){
        return userService.toLogin(user,session);
    }

}
