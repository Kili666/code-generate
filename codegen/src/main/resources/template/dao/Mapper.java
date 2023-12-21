package ${package_mapper};

import ${package_mapper}.${Table}Mapper;
import ${package_pojo}.${Table};
import ${package_service}.${Table}Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * @Description ${tableComment!""}
 * @Author ${author}
 * @Date ${create_time}
 **/
public interface ${Table}Mapper extends BaseMapper<${Table}> {

<#if Tablelogic?has_content>
    /**
     * 根据id查询已经逻辑删除的数据
     */
    @Select("select * from ${TableName} where id = ${Tid} and ${Tablelogic}=1")
    public ${Table} findLogicDelById(Long id);

    /**
     * 查询所有已经逻辑删除的数据
     */
    @Select("select * from ${TableName} where ${Tablelogic}=1")
    public List<${Table}> findAllLogicDel();

    /**
     * 根据id物理删除数据
     */
    @Delete("delete from ${TableName} where id=${Tid}")
    public Boolean deleteTablelogic(Long id);

    /**
     * 根据id更新逻辑删除的数据
     * 复杂sql语句写在xml里面
     * @param ${table}
     */
    public Boolean updateLogicDelById(${Table} ${table});

</#if>
    <#if foreigns?has_content>
    @Select("select * from ${TableName} where id = ${Tid}")
    @Results({
        <#list foreigns as foreign>
        <#if foreign.isPK>
        @Result(property = "${foreign.ftable}", column = "${foreign.fkColumn}",
                one = @One(select = "${package_mapper}.${foreign.opTable}Mapper.selectById")),
        <#else>
        @Result(property = "${foreign.ftable}", column = "${foreign.fkColumn}",
                many = @Many(select = "${package_mapper}.${foreign.opTable}Mapper.selectByFK")),
        </#if>
        </#list>
    })
    ${Table} selectCascadeById(@Param("id") ${keyType} id);
    </#if>

<#list foreigns as foreign>
<#if !foreign.isPK>
    /***** 将这段代码复制到${foreign.opTable}Mapper中  ****/
    @Select("select * from ${foreign.pkCatalog}.${foreign.pkTable} where ${foreign.pkColumn} = ${Tid}")
    List<${foreign.opTable}> selectByFK(Serializable id);

<#elseif foreign.fkCatalog != foreign.pkCatalog>
    /***** 将这段代码剪切到${foreign.opTable}Mapper中  ****/
    @Select("select * from ${foreign.pkCatalog}.${foreign.pkTable} where ${foreign.tpk} = ${Tid}")
    ${foreign.opTable} selectById(Serializable id);

</#if>
</#list>

}
