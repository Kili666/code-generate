package ${package_feign};

import ${package_utils}.PageResult;
import ${package_utils}.R;
import ${package_pojo}.${Table};
import ${package_vo}.${Table}VO;
import ${package_dto}.${Table}AddDTO;
import ${package_dto}.${Table}QueryDTO;
import ${package_dto}.${Table}UpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Description ${tableComment!""}
 * @Author ${author}
 * @Date ${create_time}
 **/
@FeignClient(name="${serviceName}")
@RequestMapping("/${table}")
public interface ${Table}Feign {

    /***
     * ${Table}分页条件查询
     * @param ${table}QueryDTO
     * @return
     */
    @PostMapping(value = "/page" )
    R<PageResult> findPage(@RequestBody(required = false) ${Table}QueryDTO ${table}QueryDTO);

    /***
     * ${Table}分页查询
     * @param pageNo:当前页
     * @param pageSize:每页显示多少条
     * @return
     */
    @GetMapping(value = "/page/{pageNo}/{pageSize}" )
    R<PageResult> findPage(@PathVariable  int pageNo, @PathVariable  int pageSize);

    /***
     * 根据ID删除${Table}数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    R deleteById(@PathVariable ${keyType} id);

    /***
     * 修改${Table}数据
     * @return
     */
    @PutMapping
    R updateById(@RequestBody ${Table}UpdateDTO ${table}UpdateDTO);

    /***
     * 新增${Table}数据
     * @param ${table}AddDTO
     * @return
     */
    @PostMapping
    R save(@RequestBody ${Table}AddDTO ${table}AddDTO);

    /***
     * 根据ID查询${Table}数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    R<${Table}VO> findById(@PathVariable ${keyType} id);

}