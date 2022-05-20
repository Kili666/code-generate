package com.lqjai.code.util;

/****
 * @Author: 千千科技
 * @Description: 字符串处理
 * @Date 2022/01/08
 *****/
public class StringUtils {

    /***
     * 首字母大写
     * @param str
     * @return
     */
    public static String firstUpper(String str){
        try {
            return str.substring(0,1).toUpperCase()+str.substring(1);
        } catch (Exception e) {
//            e.printStackTrace();
            return "OVER";
        }
    }

    /**
     * 首字母小写
     * @param str
     * @return
     */
    public static String firstLower(String str){
        try {
            return str.substring(0,1).toLowerCase()+str.substring(1);
        } catch (Exception e) {
//            e.printStackTrace();
            return "OVER";
        }
    }

    /***
     * 移除tab_,tb_
     * @return
     */
    public static String replaceTab(String str, String prefix){
        if(StringUtils.isNotBlank(prefix))
            return str.replaceFirst(prefix,"");
        return str;
    }

    /***
     * 将下划线替换掉
     * @param str
     * @return
     */
    public static String replace_(String str){
        //根据下划线分割
        String[] split = str.split("_");
        //循环组装
        String result = split[0];
        if(split.length>1){
            for (int i = 1; i < split.length; i++) {
                result+=firstUpper(split[i]);
            }
        }
        return result;
    }

    public static Boolean isBlank(String str){
        if(str == null || str == "")
            return true;
        else
            return false;
    }

    public static Boolean isNotBlank(String str) {
        if(str == null || str == "")
            return false;
        else
            return true;
    }
}
