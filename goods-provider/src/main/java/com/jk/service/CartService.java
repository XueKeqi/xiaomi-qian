package com.jk.service;

import com.jk.entity.xmUser;

import java.util.List;

public interface CartService {

    Boolean hasKey(String key, String goodsId);

    public  Object hget(String key, String goodsId);

    public void setHashOption(String key, String objkey, Object value);

    List hgetList(String key);

    xmUser findUserId(String userName);

}
