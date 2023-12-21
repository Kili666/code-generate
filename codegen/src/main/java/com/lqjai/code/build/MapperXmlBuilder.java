package com.lqjai.code.build;

import java.util.Map;

/****
 * @Author 千千科技
 * @Description Dao构建
 * @Date 2022/01/08 19:13
 *****/
public class MapperXmlBuilder {


    /***
     * 构建Dao
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        //生成Dao层文件
        BuilderFactory.builder(modelMap,
                "/template/xml",
                "Mapper.xml",
                TemplateBuilder.PACKAGE_MAPPER_XML,
                "Mapper.xml");
    }

}
