package ${package_controller};

import ${package_service}.${Table}Service;
import ${package_utils}.PageResult;
import ${package_utils}.R;
import ${package_utils}.StatusCode;
import ${package_convert}.${Table}Convert;
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

/**
 * @Description ${tableComment!""}
 * @Author ${author}
 * @Date ${create_time}
 **/
<#if swagger==true>@Api(tags = "${tableComment!""}", value = "${Table}Controller")</#if>
@RestController
@RequestMapping("/${table}")
@CrossOrigin
@Slf4j
public class ${Table}Controller {

    @Autowired
    private ${Table}Service ${table}Service;

    /***
     * 分页条件查询
     * @param ${table}QuerDTO
     * @return
     */
    <#if swagger==true>
    @ApiOperation("分页条件查询")
    </#if>
    @PostMapping("/page" )
    public R<PageResult> findPage(@RequestBody(required = false) ${Table}QueryDTO ${table}QuerDTO){
        return R.ok( ${table}Service.findPage(${table}QuerDTO));
    }

    /***
     * 分页查询
     * @param pageNo:当前页
     * @param pageSize:每页显示多少条
     * @return
     */
    <#if swagger==true>
    @ApiOperation("分页查询")
    </#if>
    @GetMapping("/page/{pageNo}/{pageSize}" )
    public R<PageResult> findPage(@ApiParam("页号") @PathVariable  int pageNo, @ApiParam("页面大小") @PathVariable  int pageSize){
        return R.ok( ${table}Service.findPage(pageNo, pageSize));
    }

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation("根据ID删除")
    </#if>
    @DeleteMapping("/{id}" )
    public R deleteById(@PathVariable ${keyType} id){
        return R.ok(${table}Service.deleteById(id));
    }

    /***
     * 根据ID批量删除数据
     * @param ids
     * @return
     */
    @ApiOperation("根据ID批量删除")
    @DeleteMapping("/batch/{ids}" )
    public R deleteByIds(@ApiParam("id集合，逗号隔开，格式：ids=1,2,3") @PathVariable List<${keyType}> ids){
        return R.ok(${table}Service.deleteByIds(ids));
    }

    /***
     * 修改数据
     * @param ${table}UpdateDTO
     * @return
     */
    <#if swagger==true>
    @ApiOperation("根据ID修改")
    </#if>
    @PutMapping
    public R updateById(@RequestBody ${Table}UpdateDTO ${table}UpdateDTO){
        return R.ok(${table}Service.updateById(${table}UpdateDTO));
    }

    /***
     * 根据ID批量修改数据
     * @param ${table}UpdateDTO
     * @return
     */
    @ApiOperation("根据ID批量修改")
    @PutMapping("batch")
    public R updateBatchByIds(@RequestBody ${Table}UpdateDTO ${table}UpdateDTO){
        return R.ok(${table}Service.updateBatchByIds(${table}UpdateDTO));
    }

    /***
     * 新增数据
     * @param ${table}AddDTO)
     * @return
     */
    <#if swagger==true>
    @ApiOperation("新增数据")
    </#if>
    @PostMapping
    public R save(@RequestBody ${Table}AddDTO ${table}AddDTO){
        return R.ok(${table}Service.save(${table}AddDTO));
    }

    /***
     * 根据ID查询
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "根据ID查询")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @GetMapping("/{id}")
    public R<${Table}BO> findById(@PathVariable ${keyType} id){
        return R.ok(${table}Service.findById(id));
    }

}
