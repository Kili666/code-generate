package com.lqjai.code.build;

import java.util.Map;

/****
 * @Author 千千科技
 * @Description DTO构建
 * @Date 2022/01/08 19:13
 *****/
public class DtoBuilder {


    /***
     * 构建DTO
     * @param dataModel
     */
    public static void builder(Map<String,Object> dataModel){
        //生成Dto层文件
        BuilderFactory.builder(dataModel,
                "/template/model",
                "DTO.java",
                TemplateBuilder.PACKAGE_DTO,
                "DTO.java");
    }

    /***
     * 构建DTO
     * @param dataModel
     */
    public static void builder(Map<String,Object> dataModel, String suffix){
        dataModel.put("sufDto",suffix.substring(0, suffix.indexOf(".")));
        //生成Dto层文件
        BuilderFactory.builder(dataModel,
                "/template/model",
                "DTO.java",
                TemplateBuilder.PACKAGE_DTO,
                suffix);
    }

}
