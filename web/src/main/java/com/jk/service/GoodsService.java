package com.jk.service;

import com.jk.entity.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "goods")
public interface GoodsService {

    @RequestMapping("findAll")
    public List<Goods> findAll();


}
