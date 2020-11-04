package com.jk.controller;


import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.jk.entity.Goods;
import freemarker.template.Configuration;
import freemarker.template.Template;
import com.jk.entity.xmUser;
import com.jk.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Freemarker {
    /*@Resource
    private GoodsService goodsService;

    @RequestMapping("findAll")
    public String findAll(Map<String,List<xmUser>> map){

        xmUser p1=new xmUser();
        p1.setId(1);
        p1.setName("小明");
        xmUser p2=new xmUser();
        p2.setId(2);
        p2.setName("小华");
        List<xmUser> person=new ArrayList<xmUser>();
        person.add(p1);
        person.add(p2);
        Map root = new HashMap();
        root.put("person", person);
        map.put("person", person);
        return "freemarker";
    }

    public static void main(String[] args) throws Exception {
        String dir="F:\\xxxDemo\\show";
        Configuration conf = new Configuration();
        //加载模板文件(模板的路径)
        conf.setDirectoryForTemplateLoading(new File(dir));
        // 加载模板
        Template template = conf.getTemplate("/freemarker.ftl");
        // 定义数据

        xmUser p1=new xmUser();
        p1.setId(1);
        p1.setName("小明");
        xmUser p2=new xmUser();
        p2.setId(2);
        p2.setName("小华");
        List<xmUser> person=new ArrayList<xmUser>();
        person.add(p1);
        person.add(p2);
        Map root = new HashMap();
        root.put("person", person);
        // 定义输出
        Writer out = new FileWriter(dir + "/show.html");
        template.process(root, out);
        System.out.println("转换成功");
        out.flush();
        out.close();
    }

*/

}
