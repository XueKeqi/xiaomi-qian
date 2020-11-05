package com.jk.service;

import com.jk.entity.Carouse;
import com.jk.entity.Goods;
import com.jk.entity.Picture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(value = "goods")
public interface GoodsService {

    @RequestMapping("goods/findAll")
    public List<Goods> findAll(@RequestParam String mid);

    @RequestMapping("pictur/findLun")
    public List<Picture> findLun(@RequestParam Integer mid);


    @RequestMapping("goods/findCarouse")
    public List<Carouse> findCarouse();


}
