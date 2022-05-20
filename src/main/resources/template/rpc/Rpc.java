package ${package_rpc};

import ${package_pojo}.${Table};
import ${package_bo}.${Table}BO;
import ${package_dto}.${Table}AddDTO;
import ${package_dto}.${Table}UpdateDTO;
import com.lqjai.common.utils.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import com.lqjai.common.utils.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/****
 * @Author: ${author}
 * @Description: ${Table}Rpc
 * @Date ${create_time}
 *****/
public interface ${Table}Rpc{

    /***
     * ${Table}分页条件搜索实现
     * @param ${table}
     * @param pageNo
     * @param size
     * @return
     */
    public PageResult findPage(${Table} ${table}, int pageNo, int size);

    /***
     * ${Table}分页搜索实现
     * @param pageNo:当前页
     * @param size:每页显示多少条
     * @return
     */
    public PageResult findPage(int pageNo, int size);

    /***
     * 根据ID删除数据
     * @param id
     * @return
     */
    public Boolean delete(${keyType} id);

    /***
     * 修改${Table}数据
     * @param ${table}UpdateDTO
     * @return
     */
    public Boolean update(${Table}UpdateDTO ${table}UpdateDTO);

    /***
     * 新增${Table}数据
     * @param ${table}AddDTO
     * @return
     */
    public Boolean add(${Table}AddDTO ${table}AddDTO);

    /***
     * 根据ID查询${Table}数据
     * @param id
     * @return
     */
    public ${Table}BO findById(${keyType} id);

    /***
     * 查询${Table}全部数据
     * @return
     */
    public List<${Table}BO> findAll();

}
