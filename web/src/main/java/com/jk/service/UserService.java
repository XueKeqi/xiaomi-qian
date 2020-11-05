package com.jk.service;

import com.jk.entity.xmUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@FeignClient(value = "user")
public interface UserService {
    @RequestMapping("user/toLogin")
    public xmUser toLogin(@RequestBody xmUser user);
}
