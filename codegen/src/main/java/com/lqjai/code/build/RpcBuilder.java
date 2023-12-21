package com.lqjai.code.build;

import java.util.Map;

/****
 * @Author 千千科技
 * @Description Feign构建
 * @Date 2022/01/08 19:13
 *****/
public class RpcBuilder {


    /***
     * 构建Feign
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        //生成Dao层文件
        BuilderFactory.builder(modelMap,
                "/template/rpc",
                "Rpc.java",
                TemplateBuilder.PACKAGE_RPC_INTERFACE,
                "Rpc.java");
    }

}
