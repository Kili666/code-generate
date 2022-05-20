package ${package_pojo};
<#if swagger==true>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
import javax.persistence.*;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
<#list models as model>
	<#if model.simpleType=='LocalDateTime'>
import java.time.LocalDateTime;
	</#if>
	<#if model.identity=='YES'>
import com.baomidou.mybatisplus.annotation.IdType;
	</#if>
	<#if model.tablelogic==true>
import com.baomidou.mybatisplus.annotation.TableLogic;
	</#if>
</#list>

/****
 * @Author: ${author}
 * @Description: ${Table}Pojo
 * @Date ${create_time}
 *****/
<#if swagger==true>
@ApiModel(description = "${Table}",value = "${Table}")
</#if>
@TableName(value="${TableName}")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	private ${model.simpleType} ${model.name};	//${model.desc}

</#list>
}
