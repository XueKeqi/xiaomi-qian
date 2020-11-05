package com.jk.controller;

import com.jk.entity.Picture;
import com.jk.service.PictureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PictureController {

    @Resource
    private PictureService pictureService;


    @RequestMapping("asd")
    public String asd(){
        return "asd";
    }


    @RequestMapping("pictur/findLun")
    public List<Picture> findLun(@RequestParam Integer mid){
        return pictureService.findLun(mid);
    }

}
