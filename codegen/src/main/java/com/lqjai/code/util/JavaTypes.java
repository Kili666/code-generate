package com.lqjai.code.util;

import java.sql.Types;

/****
 * @Author 千千科技
 * @Description
 * @Date 2022/01/08
 *****/
public class JavaTypes {

    /***
     * 根据java.sql.Types的值返回java的类型
     * @param value
     * @return
     */
    public static String getType(int value) {
        switch (value) {
            case Types.BIT:
            case Types.BOOLEAN:
                return "java.lang.Boolean";
            case Types.TINYINT:
            case Types.SMALLINT:
            case Types.INTEGER:
                return "java.lang.Integer";
            case Types.BIGINT:
                return "java.lang.Long";
            case Types.FLOAT:
            case Types.REAL:
            case Types.DOUBLE:
                return "java.lang.Double";
            case Types.NUMERIC:
            case Types.DECIMAL:
                return "java.math.BigDecimal";
            case Types.CHAR:
            case Types.VARCHAR:
            case Types.LONGVARCHAR:
                return "java.lang.String";
            case Types.DATE:
                return "java.time.LocalDate";
            case Types.TIME:
                return "java.time.LocalTime";
            case Types.TIMESTAMP:
                return "java.time.LocalDateTime";
            case Types.BINARY:
            case Types.VARBINARY:
            case Types.LONGVARBINARY:
                return "java.lang.byte[]";
            default:
                return "java.lang.String";
        }
    }

    /***
     * 去掉数据类型的包
     * @param type
     * @return
     */
    public static String simpleName(String type){
        return type.replace("java.lang.","")
                .replaceFirst("java.util.","")
                .replaceFirst("java.time.","")
                .replaceFirst("java.math.","");
    }

    /***
     * 去掉数据类型的包，并且首字母小写
     * @param type
     * @return
     */
    public static  String simpleNameLowerFirst(String type){
        //去掉前缀
        type = simpleName(type);
        //将第一个字母转成小写
        return StringUtils.firstLower(type);
    }

}
