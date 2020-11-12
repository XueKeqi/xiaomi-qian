package com.jk.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "user_ik_index", type = "user_ik_type")
public class Users {

    @Id
    private Integer userId;

    @Field(name = "userName", type = FieldType.Keyword, analyzer = "ik_max_word", store = true)
    private String userName;

    private Integer userSex;

    private String userPassword;

    private String userPhone;

    private String userYoux;

    private String userImgurl;
}
