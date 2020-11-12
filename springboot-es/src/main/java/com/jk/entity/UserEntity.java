package com.jk.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "2004_ik_index", type = "2004_ik_type")
public class UserEntity {

    @Id   // 数据id 和 索引id 一致
    private Integer userId;

    @Field(name = "userName", type = FieldType.Keyword, analyzer = "ik_synonym", store = true)
    private String userName;

    private String password;

    private String createTime;
}
