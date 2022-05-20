package com.lqjai.code.swagger;

/*****
 * @Author:  千千科技
 * @Date: 2022/01/08 14:51
 * @Description:  com.lqjai.code.util
 *  响应数据配置
 ****/
public class SwaggerResponse {
    //响应状态码  200,404.。。
    private int code;

    //描述
    private String description;

    //响应引用
    private String schema;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
