package ${package_rpc_impl};

import ${package_mapper}.${Table}Mapper;
import ${package_pojo}.${Table};
import ${package_bo}.${Table}BO;
import ${package_dto}.${Table}AddDTO;
import ${package_dto}.${Table}UpdateDTO;
import ${package_convert}.${Table}Convert;
import ${package_rpc}.${Table}Rpc;
import ${package_service}.${Table}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.lqjai.common.utils.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import java.util.List;

/****
 * @Author: ${author}
 * @Description: ${Table}ServiceImpl
 * @Date ${create_time}
 *****/
@Slf4j
@DubboService
public class ${Table}RpcImpl implements ${Table}Rpc{

    @Autowired
    private ${Table}Service ${table}Service;

    /***
     * ${Table}分页条件搜索实现
     * @param ${table}
     * @param pageNo
     * @param size
     * @return
     */
    public PageResult findPage(${Table} ${table}, int pageNo, int size){
        return ${table}Service.findPage(${table}, pageNo, size);
    }

    /***
     * ${Table}分页搜索实现
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
    public Boolean delete(${keyType} id){
        //调用${Table}Service实现根据主键删除
        return ${table}Service.removeById(id);
    }

    /***
     * 修改${Table}数据
     * @param ${table}UpdateDTO
     * @return
     */
    public Boolean update(${Table}UpdateDTO ${table}UpdateDTO){
        //调用${Table}Service实现修改${Table}
        ${Table} ${table} = ${Table}Convert.INSTANCE.convert(${table}UpdateDTO);
        return ${table}Service.updateById(${table});
    }

    /***
     * 新增${Table}数据
     * @param ${table}AddDTO
     * @return
     */
    public Boolean add(${Table}AddDTO ${table}AddDTO){
        //调用${Table}Service实现添加${Table}
        ${Table} ${table} = ${Table}Convert.INSTANCE.convert(${table}AddDTO);
        return ${table}Service.save(${table});
    }

    /***
     * 根据ID查询${Table}数据
     * @param id
     * @return
     */
    public ${Table}BO findById(${keyType} id){
        //调用${Table}Service实现根据主键查询${Table}
        return ${Table}Convert.INSTANCE.convert(${table}Service.getById(id));
    }

    /***
     * 查询${Table}全部数据
     * @return
     */
    public List<${Table}BO> findAll(){
        //调用${Table}Service实现查询所有${Table}
        return ${Table}Convert.INSTANCE.convert(${table}Service.list());
    }
}
