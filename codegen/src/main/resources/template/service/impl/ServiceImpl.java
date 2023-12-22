package ${package_service_impl};

import ${package_mapper}.${Table}Mapper;
import ${package_pojo}.${Table};
import ${package_vo}.${Table}VO;
import ${package_dto}.${Table}AddDTO;
import ${package_dto}.${Table}QueryDTO;
import ${package_dto}.${Table}UpdateDTO;
import ${package_service}.${Table}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import ${package_utils}.PageResult;
import ${package_convert}.${Table}Convert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import java.util.List;

/**
 * @Description ${tableComment!""}
 * @Author ${author}
 * @Date ${create_time}
 **/
@Service
@Slf4j
public class ${Table}ServiceImpl extends ServiceImpl<${Table}Mapper, ${Table}> implements ${Table}Service{

    /**
     * ${Table}条件+分页查询
     * @param ${table}QueryDTO 查询条件
     * @return 分页结果
     */
    @Override
    public PageResult findPage(${Table}QueryDTO ${table}QueryDTO){
        ${Table} ${table} = ${Table}Convert.INSTANCE.convert(${table}QueryDTO);
        LambdaQueryWrapper<${Table}> queryWrapper = Wrappers.lambdaQuery(${table});
        Page<${Table}> result = page(${table}QueryDTO.toMpPage(), queryWrapper);
        PageResult pageResult=new PageResult(result.getTotal(),${Table}Convert.INSTANCE.convert(result.getRecords()));
        return pageResult;
    }

    /**
     * ${Table}分页查询
     * @param pageNo 页号
     * @param pageSize 页面大小
     * @return 分页结果
     */
    @Override
    public PageResult findPage(int pageNo, int pageSize){
        Page<${Table}> page = new Page<>();
        LambdaQueryWrapper<${Table}> wrapper = Wrappers.<${Table}>lambdaQuery();
        page.setCurrent(pageNo).setSize(pageSize);
        IPage result = this.page(page, wrapper);
        PageResult pageResult=new PageResult(result.getTotal(),${Table}Convert.INSTANCE.convert(result.getRecords()));
        return pageResult;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(${keyType} id) {
        return removeById(id);
    }

    /**
     * 新增数据
     * @param ${table}AddDTO
     * @return
     */
    @Override
    public Boolean save(${Table}AddDTO ${table}AddDTO) {
        ${Table} ${table} = ${Table}Convert.INSTANCE.convert(${table}AddDTO);
        return save(${table});
    }

    /**
     * 根据id修改
     * @param ${table}UpdateDTO
     * @return
     */
    @Override
    public Boolean updateById(${Table}UpdateDTO ${table}UpdateDTO) {
        ${Table} ${table} = ${Table}Convert.INSTANCE.convert(${table}UpdateDTO);
        return updateById(${table});
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public ${Table}VO findById(${keyType} id) {
    <#if !foreigns?has_content>
        ${Table} ${table} = getById(id);
    <#else>
        ${Table} ${table} = getBaseMapper().selectCascadeById(id);
    </#if>
        ${Table}VO ${table}VO = ${Table}Convert.INSTANCE.convert(${table});
        return ${table}VO;
    }

    /**
     * 根据ids批量修改
     * @param ${table}UpdateDTO
     * @return
     */
    @Override
    public Boolean updateBatchByIds(${Table}UpdateDTO ${table}UpdateDTO) {
        ${Table} token = ${Table}Convert.INSTANCE.convert(${table}UpdateDTO);
        UpdateWrapper<${Table}> wrapper = new UpdateWrapper<>();
        wrapper.in("user_id", ${table}UpdateDTO.getIds());
        return update(token, wrapper);
    }

    /**
     * 根据ids批量删除
     * @param ids
     * @return
     */
    @Override
    public Boolean deleteByIds(List<${keyType}> ids) {
        return removeBatchByIds(ids);
    }
}
