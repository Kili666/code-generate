package ${package_rpc_impl};

import ${package_mapper}.${Table}Mapper;
import ${package_pojo}.${Table};
import ${package_bo}.${Table}BO;
import ${package_dto}.${Table}AddDTO;
import ${package_dto}.${Table}UpdateDTO;
import ${package_dto}.${Table}QueryDTO;
import ${package_convert}.${Table}Convert;
import ${package_rpc}.${Table}Rpc;
import ${package_service}.${Table}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ${package_utils}.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.dubbo.config.annotation.DubboService;
import java.util.List;

/**
 * @Description ${tableComment!""}
 * @Author ${author}
 * @Date ${create_time}
 **/
@Slf4j
@DubboService
public class ${Table}RpcImpl implements ${Table}Rpc{

    @Autowired
    private ${Table}Service ${table}Service;

    /***
     * ${Table}分页条件查询
     * @param ${table}QueryDTO
     * @return
     */
    public PageResult findPage(${Table}QueryDTO ${table}QueryDTO){
        return ${table}Service.findPage(${table}QueryDTO);
    }

    /***
     * ${Table}分页查询
     * @param pageNo:当前页
     * @param size:每页显示多少条
     * @return
     */
    public PageResult findPage(int pageNo, int size){
        return ${table}Service.findPage(pageNo, size);
    }

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    public Boolean deleteById(${keyType} id){
        //调用${Table}Service实现根据主键删除
        return ${table}Service.deleteById(id);
    }

    /***
     * 修改${Table}数据
     * @param ${table}UpdateDTO
     * @return
     */
    public Boolean updateById(${Table}UpdateDTO ${table}UpdateDTO){
        return ${table}Service.updateById(${table}UpdateDTO);
    }

    /***
     * 新增${Table}数据
     * @param ${table}AddDTO
     * @return
     */
    public Boolean save(${Table}AddDTO ${table}AddDTO){
        return ${table}Service.save(${table}AddDTO);
    }

    /***
     * 根据ID查询${Table}数据
     * @param id
     * @return
     */
    public ${Table}BO findById(${keyType} id){
        return ${table}Service.findById(id);
    }

}
