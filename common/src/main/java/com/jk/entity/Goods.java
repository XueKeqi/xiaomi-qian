package com.jk.entity;



import lombok.Data;

import java.util.Date;

@Data
public class Goods {

    private Integer id;

    private Integer categoryId;

    private String title;

    private String subtitle;

    private String images;

    private String detail;

    private Integer attributeKey;

    private Double price;

    private Integer stock;

    private Integer sale;

    private Integer status;

    private Date createTime;

    private Date updateTime;






}
