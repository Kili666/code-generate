package com.lqjai.code.util;

/****
 * @Author: 千千科技
 * @Description: 记录POJO信息
 * @Date 2022/01/08
 *****/
public class ModelInfo {

    //属性类型
    private String type;
    //类型-只有名字
    private String simpleType;
    //属性名字
    private String name;
    //首字母大写属性名字
    private String upperName;
    //属性描述
    private String desc;
    //是否是主键
    private Boolean id;
    //是否是逻辑删除字段
    private Boolean tablelogic;
    //是否必填字段
    private Boolean required;
    //列名
    private String column;
    //是否自增  YES自增，NO：非自增
    private String identity;

    public ModelInfo(String type, String simpleType, String name, String upperName, String desc, Boolean id,Boolean required,String column,String identity, Boolean tablelogic) {
        this.type = type;
        this.simpleType = simpleType;
        this.name = name;
        this.upperName = upperName;
        this.desc = desc;
        this.id = id;
        this.column = column;
        this.identity=identity;
        this.required = required;
        this.tablelogic = tablelogic;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSimpleType() {
        return simpleType;
    }

    public void setSimpleType(String simpleType) {
        this.simpleType = simpleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpperName() {
        return upperName;
    }

    public void setUpperName(String upperName) {
        this.upperName = upperName;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Boolean getId() {
        return id;
    }

    public void setId(Boolean id) {
        this.id = id;
    }

    public Boolean getTablelogic() {
        return tablelogic;
    }

    public void setTablelogic(Boolean tablelogic) {
        this.tablelogic = tablelogic;
    }
}
