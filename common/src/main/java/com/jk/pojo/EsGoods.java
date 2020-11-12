package com.jk.pojo;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Data
@Document(indexName = "good_ik_index", type = "good_ik_type")
public class EsGoods {


    @Id
    private Integer id;

    @Field(name = "title", type = FieldType.Keyword, analyzer = "ik_max_word", store = true)
    private String title;

    @Field(name = "types", type = FieldType.Keyword, analyzer = "ik_max_word", store = true)
    private Integer types;


}
