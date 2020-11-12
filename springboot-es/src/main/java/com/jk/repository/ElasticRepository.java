package com.jk.repository;

import com.jk.entity.UserEntity;
import com.jk.entity.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


/**
 *   springboot整合ES方式有两种
 *          1。 在controller控制层注入template操作模板
 *              @Resource
 *              private ElasticsearchTemplate esTemplate;
 *              常用复杂的多条件查询包括 高亮 复杂条件  同义词  扩展词  分词器方式
 *
 *          2. 在持久层继承 ElasticsearchRepository<实体类, 主键类型>
 *              常用于简单的添加 修改 删除    查询
 */

@Repository
public interface ElasticRepository extends ElasticsearchRepository<Users, Integer> {

}
