package com.lqjai.code.build;

import java.util.Map;

/****
 * @Author 千千科技
 * @Description Service构建
 * @Date 2022/01/08 19:13
 *****/
public class ServiceBuilder {


    /***
     * 构建Service
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        //生成Service层文件
        BuilderFactory.builder(modelMap,
                "/template/service",
                "Service.java",
                TemplateBuilder.PACKAGE_SERVICE_INTERFACE,
                "Service.java");
    }

}
