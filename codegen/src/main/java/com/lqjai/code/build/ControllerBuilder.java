package com.lqjai.code.build;

import java.util.Map;

/****
 * @Author 千千科技
 * @Description Controller构建
 * @Date 2022/01/08 19:13
 *****/
public class ControllerBuilder {

    /***
     * 构建Controller
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        //生成Controller层文件
        BuilderFactory.builder(modelMap,
                "/template/controller",
                "Controller.java",
                TemplateBuilder.PACKAGE_CONTROLLER,
                "Controller.java");
    }

}
