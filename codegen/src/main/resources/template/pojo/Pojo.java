package ${package_pojo};
<#if swagger==true>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
<#if showList==true>
import java.util.List;
</#if>
<#if showTableField==true>
import com.baomidou.mybatisplus.annotation.TableField;
</#if>
<#list models as model>
    <#if model.type?index_of("java.lang") == -1>
import ${model.type};
    </#if>
	<#if model.identity=='YES'>
import com.baomidou.mybatisplus.annotation.IdType;
	</#if>
	<#if model.tablelogic==true>
import com.baomidou.mybatisplus.annotation.TableLogic;
	</#if>
</#list>

/**
 * @Description ${Table} Pojo
 * @Author ${author}
 * @Date ${create_time}
 **/
<#if swagger==true>
@ApiModel(description = "${tableComment!""}",value = "${Table}")
</#if>
@TableName(value="${TableName}")
@Data
@Accessors(chain = true)
public class ${Table} implements Serializable{
	private static final long serialVersionUID = 1L;

<#list models as model>
	<#if swagger==true>
	@ApiModelProperty(value = "${model.desc!""}",required = ${model.required?string('true','false')})
	</#if>
	<#if model.id==true>
	@TableId<#if model.identity=='YES'>(type = IdType.AUTO)</#if>
	</#if>
	<#if model.tablelogic==true>
	@TableLogic
	</#if>
	private ${model.simpleType} ${model.name}; <#if model.desc?has_content>//${model.desc}</#if>

</#list>
<#list foreigns as foreign>
	<#if swagger==true>
	@ApiModelProperty(value = "${foreign.tableRemarks!""}")
	</#if>
	@TableField(exist = false)
	private ${foreign.pTable} ${foreign.ftable}; <#if foreign.tableRemarks?has_content>//${foreign.tableRemarks}</#if>

</#list>
}
