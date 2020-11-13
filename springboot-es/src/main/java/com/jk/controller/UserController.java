package com.jk.controller;

import com.jk.entity.Users;
import com.jk.service.UserService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;


    @Resource
    private UserService userService;



    /*查询全部*/
    @RequestMapping("findAll")
    @ResponseBody
    public List<Users> findAll(){

        return userService.findAll();

    }

    /*展示指定的字段*/
    /*条查*/
    @RequestMapping("findByName")
    @ResponseBody
    public List<Users> findByName(){

        String[] include = {"userName", "userSex"};

        FetchSourceFilter fetchSourceFilter = new FetchSourceFilter(include, null);   //两个参数分别是要显示的和不显示的

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withSourceFilter(fetchSourceFilter)
                .build();

        List<Users> users = elasticsearchTemplate.queryForList(searchQuery, Users.class);


        return users;
    }




    @RequestMapping("findBy")
    @ResponseBody
    public List<Users> findBy(String name){


        String preTag = "<font color='#dd4b39'>";//google的色值
        String postTag = "</font>";

        Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder srb = client.prepareSearch("user_ik_index")
                .setTypes("user_ik_type")
                .setQuery(QueryBuilders.matchQuery("userName", name));

        // 获取高亮对象
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("userName").preTags(preTag).postTags(postTag);

        // 将高亮对象放入查询对象中
        srb.highlighter(highlightBuilder);

        // 获取查询返回的对象
        SearchResponse sr = srb.get();

        // 通过SearchResponse对象获取命中的结果集
        SearchHits hits = sr.getHits();

        // 命中的结果集获取iterator迭代器
        Iterator<SearchHit> iterator = hits.iterator();

        List<Users> userList = new ArrayList<>();
        while (iterator.hasNext()) {
            Users user = new Users();
            SearchHit sh = iterator.next();
            Map<String, HighlightField> hf = sh.getHighlightFields();
            Map<String, Object> sourceAsMap = sh.getSourceAsMap();
            user.setUserId(Integer.valueOf(sourceAsMap.get("userId").toString()));
            user.setUserName(hf.get("userName").getFragments()[0].toString());
            user.setUserPhone(sourceAsMap.get("userPhone").toString());
            user.setUserPassword(sourceAsMap.get("userPassword").toString());
            user.setUserImgurl(sourceAsMap.get("userImgurl").toString());
            user.setUserYoux(sourceAsMap.get("userYoux").toString());
            user.setUserSex(Integer.valueOf(sourceAsMap.get("userSex").toString()));
            userList.add(user);
        }



        return userList;
    }






    /*新增数据*/
    @RequestMapping("add")
    public void addUser(){


        userService.addUser();

    }







}
