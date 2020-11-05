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
    public xmUser findUserbyName(String userName) {
        return userMapper.findUserbyName(userName);
    }
}
