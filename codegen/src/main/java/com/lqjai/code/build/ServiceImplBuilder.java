package com.lqjai.code.build;

import java.util.Map;

/****
 * @Author 千千科技
 * @Description ServiceImpl构建
 * @Date 2022/01/08 19:13
 *****/
public class ServiceImplBuilder {

    /***
     * ServiceImpl构建
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        //生成ServiceImpl层文件
        BuilderFactory.builder(modelMap,
                "/template/service/impl",
                "ServiceImpl.java",
                TemplateBuilder.PACKAGE_SERVICE_INTERFACE_IMPL,
                "ServiceImpl.java");
    }

}
