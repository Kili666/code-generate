package ${package_rpc};

import ${package_pojo}.${Table};
import ${package_bo}.${Table}BO;
import ${package_dto}.${Table}AddDTO;
import ${package_dto}.${Table}UpdateDTO;
import ${package_dto}.${Table}QueryDTO;
import ${package_utils}.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import ${package_utils}.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description ${tableComment!""}
 * @Author ${author}
 * @Date ${create_time}
 **/
public interface ${Table}Rpc{

    /***
     * ${Table}分页条件查询
     * @param ${table}QueryDTO
     * @return
     */
    public PageResult findPage(${Table}QueryDTO ${table}QueryDTO);

    /***
     * ${Table}分页查询
     * @param pageNo:当前页
     * @param pageSize:每页显示多少条
     * @return
     */
    public PageResult findPage(int pageNo, int pageSize);

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    public Boolean deleteById(${keyType} id);

    /***
     * 修改${Table}数据
     * @param ${table}UpdateDTO
     * @return
     */
    public Boolean updateById(${Table}UpdateDTO ${table}UpdateDTO);

    /***
     * 新增${Table}数据
     * @param ${table}AddDTO
     * @return
     */
    public Boolean save(${Table}AddDTO ${table}AddDTO);

    /***
     * 根据ID查询${Table}数据
     * @param id
     * @return
     */
    public ${Table}BO findById(${keyType} id);

}
