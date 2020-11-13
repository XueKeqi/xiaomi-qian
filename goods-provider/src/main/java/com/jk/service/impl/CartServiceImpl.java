package com.jk.service.impl;

import com.jk.dao.CartMapper;
import com.jk.entity.xmUser;
import com.jk.service.CartService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Resource
    private CartMapper cartMapper;

    @Resource
    private RedisTemplate redisTemplate;


    @Override
    public Boolean hasKey(String key, String goodsId) {
        return redisTemplate.opsForHash().hasKey(key,goodsId);
    }

    @Override
    public Object hget(String key, String goodsId) {
        return redisTemplate.opsForHash().get(key,goodsId);
    }

    @Override
    public void setHashOption(String key, String objkey, Object value) {
        redisTemplate.opsForHash().put(key,objkey,value);
    }

    @Override
    public List hgetList(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    @Override
    public xmUser findUserId(String userName) {
        return cartMapper.findUserId(userName);
    }


}
