package com.jk.service.impl;

import com.jk.dao.UsersMapper;
import com.jk.entity.Users;
import com.jk.repository.ElasticRepository;
import com.jk.service.UserService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private ElasticRepository elasticRepository;

    @Resource
    private ElasticsearchTemplate esTemplate;

    @Resource
    private UsersMapper usersMapper;

    /////////////////////////////////////////////////////////

    /*新增*/
    @Override
    public void addUser() {
        List<Users> list = usersMapper.findAll();
        for (int i=0; i<list.size(); i++){
            Users u = new Users();
            u = list.get(i);
            System.out.print(u);
            elasticRepository.save(u);
        }
    }

    /*查询全部*/
    @Override
    public List<Users> findAll() {

        Iterable<Users> userEntities = elasticRepository.findAll();
        Iterator<Users> iterator = userEntities.iterator();
        List<Users> userList = new ArrayList<Users>();
        while (iterator.hasNext()) {
            userList.add(iterator.next());
        }
        return userList;
    }

}
