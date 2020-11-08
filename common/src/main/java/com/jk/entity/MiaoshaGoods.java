package com.jk.entity;

import lombok.Data;

import java.util.Date;

@Data
public class MiaoshaGoods {
    private Long id;
    private Long goodsId;
    private Double miaoshaPrice;
    private Integer stockCount;
    private Date start;
    private Date end;


    private String images;
    private Double price;
    private String title;

}
