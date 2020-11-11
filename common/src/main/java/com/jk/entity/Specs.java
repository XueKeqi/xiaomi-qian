package com.jk.entity;

import lombok.Data;

import java.util.Map;

/**
 * 商品参数
 */
@Data
public class Specs {
    private Integer id;
    private Integer goodspuId;
    private String productSpecs;
    private Map<String,String[]> options;//
    private Integer stock;
    private Integer price;
}
