package com.lqjai.code.build;

import java.util.Map;

/****
 * @Author 千千科技
 * @Description Pojo构建
 * @Date 2022/01/08 19:13
 *****/
public class PojoBuilder {


    /***
     * 构建Pojo
     * @param dataModel
     */
    public static void builder(Map<String,Object> dataModel){
        //生成Pojo层文件
        BuilderFactory.builder(dataModel,
                "/template/pojo",
                "Pojo.java",
                TemplateBuilder.PACKAGE_POJO,
                ".java");
    }

}
