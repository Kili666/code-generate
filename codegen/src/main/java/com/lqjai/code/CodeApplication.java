package com.lqjai.code;

import com.lqjai.code.build.TemplateBuilder;

/****
 * @Author 千千科技
 * @Description 
 * @Date 2022/02/08
 *****/
public class CodeApplication {

    public static void main(String[] args) {
        /**
         * tableName 为空或者null生成所有表的代码，否则生成指定表的代码
         * 如果是Oracle数据库，表名需要大写，如：tableName = "EXAMPLE_TABLE"
         */
        String tableName = "";
        /**
         * 去除表的前缀，如t_user的前缀为t_,没有前缀则不填
         */
        String prefix = "tb_";
        //调用该方法即可
        TemplateBuilder.builder(tableName, prefix);
    }
}
