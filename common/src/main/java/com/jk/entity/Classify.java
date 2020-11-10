package com.jk.entity;

import lombok.Data;

@Data
public class Classify {
    private Integer id;
    private String key;
    private String value;
    private Integer categoryId;

    private String[] arr;




}
