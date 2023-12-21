package ${package_dto};
<#if swagger==true>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import ${package_utils}.PageQuery;
import java.io.Serializable;
import java.util.List;
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
 * @Description ${tableComment!""}
 * @Author ${author}
 * @Date ${create_time}
 **/
<#if swagger==true>
@ApiModel(description = "${Table}${sufDto}",value = "${Table}${sufDto}")
</#if>
@Data
@Accessors(chain = true)
public class ${Table}${sufDto}<#if sufDto == "QueryDTO"> extends PageQuery</#if> implements Serializable{
	private static final long serialVersionUID = 1L;

	<#if sufDto == "UpdateDTO">
	@ApiModelProperty(value = "批量更新时传id数组")
	private List<${keyType}> ids; //根据ids批量更新

	</#if>
<#list models as model>
	<#if swagger==true>
	@ApiModelProperty(value = "${model.desc!""}",required = ${model.required?string('true','false')})
	</#if>
	private ${model.simpleType} ${model.name}; <#if model.desc?has_content>//${model.desc}</#if>

</#list>
}
