package ${package_controller};

import ${package_service}.${Table}Service;
import com.lqjai.common.utils.PageResult;
import com.lqjai.common.utils.R;
import com.lqjai.common.utils.StatusCode;
import com.lqjai.goods.convert.CodeTestConvert;
import ${package_bo}.${Table}BO;
import ${package_dto}.${Table}AddDTO;
import ${package_dto}.${Table}QueryDTO;
import ${package_dto}.${Table}UpdateDTO;
import ${package_pojo}.${Table};
<#if swagger==true>import io.swagger.annotations.*;</#if>
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

/****
 * @Author: ${author}
 * @Description: ${Table}Controller
 * @Date ${create_time}
 *****/
<#if swagger==true>@Api(value = "${Table}Controller", tags = "${Table}Controller")</#if>
@RestController
@RequestMapping("/${table}")
@CrossOrigin
@Slf4j
public class ${Table}Controller {

    @Autowired
    private ${Table}Service ${table}Service;

    /***
     * ${Table}分页条件搜索实现
     * @param ${table}QuerDTO
     * @param pageNo
     * @param size
     * @return
     */
    <#if swagger==true>
    @ApiOperation("${Table}条件分页查询")
    </#if>
    @PostMapping("/search/{pageNo}/{size}" )
    public R<PageResult> findPage(@RequestBody(required = false) ${Table}QueryDTO ${table}QuerDTO, @PathVariable  int pageNo, @PathVariable  int size){
        ${Table} ${table} = ${Table}Convert.INSTANCE.convert(${table}QuerDTO);
        return R.ok( ${table}Service.findPage(${table}, pageNo, size));
    }

    /***
     * ${Table}分页搜索实现
     * @param pageNo:当前页
     * @param size:每页显示多少条
     * @return
     */
    <#if swagger==true>
    @ApiOperation("${Table}分页查询")
    </#if>
    @GetMapping("/search/{pageNo}/{size}" )
    public R<PageResult> findPage(@PathVariable  int pageNo, @PathVariable  int size){
        return R.ok( ${table}Service.findPage(pageNo, size));
    }

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation("${Table}根据ID删除")
    </#if>
    @DeleteMapping("/{id}" )
    public R delete(@PathVariable ${keyType} id){
        //调用${Table}Service实现根据主键删除
        return R.ok(${table}Service.removeById(id));
    }

    /***
     * 修改${Table}数据
     * @param ${table}UpdateDTO
     * @return
     */
    <#if swagger==true>
    @ApiOperation("${Table}根据ID修改")
    </#if>
    @PutMapping
    public R update(@RequestBody ${Table}UpdateDTO ${table}UpdateDTO){
        //调用${Table}Service实现修改${Table}
        ${Table} ${table} = ${Table}Convert.INSTANCE.convert(${table}UpdateDTO);
        return R.ok(${table}Service.updateById(${table}));
    }

    /***
     * 新增${Table}数据
     * @param ${table}AddDTO)
     * @return
     */
    <#if swagger==true>
    @ApiOperation("${Table}添加")
    </#if>
    @PostMapping
    public R add(@RequestBody ${Table}AddDTO ${table}AddDTO){
        //调用${Table}Service实现添加${Table}
        ${Table} ${table} = ${Table}Convert.INSTANCE.convert(${table}AddDTO);
        return R.ok(${table}Service.save(${table}));
    }

    /***
     * 根据ID查询${Table}数据
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${Table}根据ID查询")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @GetMapping("/{id}")
    public R<${Table}BO> findById(@PathVariable ${keyType} id){
        //调用${Table}Service实现根据主键查询${Table}
        return R.ok(${Table}Convert.INSTANCE.convert(${table}Service.getById(id)));
    }

    /***
     * 查询${Table}全部数据
     * @return
     */
    <#if swagger==true>
    @ApiOperation("查询所有${Table}")
    </#if>
    @GetMapping
    public R<List<${Table}BO>> findAll(){
        //调用${Table}Service实现查询所有${Table}
        List<${Table}> ${table}List = ${table}Service.list(Wrappers.<${Table}>lambdaQuery().orderByDesc(${Table}::getCreateTime));
        return R.ok(${Table}Convert.INSTANCE.convert(${table}List)) ;
    }
}
