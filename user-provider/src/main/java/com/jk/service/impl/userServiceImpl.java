package com.jk.service.impl;

import com.jk.dao.userMapper;
import com.jk.entity.xmUser;
import com.jk.service.userService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class userServiceImpl implements userService {

    @Resource
    private userMapper userMapper;

    @Override
    public String toLogin(xmUser user, HttpSession session) {
        xmUser user2 =userMapper.findUserbyName(user.getUserName());
        if(user2==null){
            return"请输入账号和密码";
        }
        if(!user2.getUserPassword().equals(user.getUserPassword())){
            return "密码不正确";
        }
        session.setAttribute("user",user);
        return "登录成功";
    }
}
