package com.jk.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 商品参数
 */
@Data
public class Specs{
    private Integer id;
    private Integer goodspuId;
    private String productSpecs;
    private Map<String,String[]> options;//
    private Integer stock;
    private Integer price;
    //spu 标题
    private String  title;
    //总价
    private Integer priceNum;
    //数量
    private Integer num;
    //照片
    private String images;
}
