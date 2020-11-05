package com.jk.service;

import com.jk.entity.xmUser;

import javax.servlet.http.HttpSession;

public interface userService {
    xmUser findUserbyName(String userName);
}
