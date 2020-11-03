package com.jk.demo;


import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class testFreemarker {
    public static void main(String[] args) throws Exception {
        String dir="H:\\Java-EE Workspace\\freemarker\\src\\com\\gwd\\freemarker";
        Configuration conf = new Configuration();
        //加载模板文件(模板的路径)
        conf.setDirectoryForTemplateLoading(new File(dir));
        // 加载模板
        Template template = conf.getTemplate("/freemarker-demo.ftl");
        // 定义数据

        Map root = new HashMap();
        root.put("world", "Hello World");
        // 定义输出
        Writer out = new FileWriter(dir + "/freemarker.html");
        template.process(root, out);
        System.out.println("转换成功");
        out.flush();
        out.close();
    }
}