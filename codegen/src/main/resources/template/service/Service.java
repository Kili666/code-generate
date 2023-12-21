package ${package_service};

import ${package_pojo}.${Table};
import ${package_bo}.${Table}BO;
import ${package_dto}.${Table}AddDTO;
import ${package_dto}.${Table}QueryDTO;
import ${package_dto}.${Table}UpdateDTO;
import ${package_utils}.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * @Description ${tableComment!""}
 * @Author ${author}
 * @Date ${create_time}
 **/
public interface ${Table}Service extends IService<${Table}> {

    /**
     * ${Table}条件+分页查询
     * @param ${table}QueryDTO 查询条件
     * @return 分页结果
     */
    PageResult findPage(${Table}QueryDTO ${table}QueryDTO);

    PageResult findPage(int pageNo, int pageSize);

    Boolean save(${Table}AddDTO ${table}AddDTO);

    Boolean deleteById(${keyType} id);

    Boolean updateById(${Table}UpdateDTO ${table}UpdateDTO);

    ${Table}BO findById(${keyType} id);

    Boolean updateBatchByIds(${Table}UpdateDTO ${table}UpdateDTO);

    Boolean deleteByIds(List<${keyType}> ids);

}
