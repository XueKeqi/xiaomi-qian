package com.jk.entity;

import lombok.Data;

/**
 * 产品
 */
@Data
public class Product {
    private Integer id;
    private String title;
    private String subtitle;
    private String images;
    private String detail;
}
