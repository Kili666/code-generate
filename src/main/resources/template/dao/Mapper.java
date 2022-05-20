package ${package_mapper};

import ${package_mapper}.${Table}Mapper;
import ${package_pojo}.${Table};
import ${package_service}.${Table}Service;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/****
 * @Author: ${author}
 * @Description: ${Table}Dao
 * @Date ${create_time}
 *****/
public interface ${Table}Mapper extends BaseMapper<${Table}> {
    /**
     * 根据id查询已经逻辑删除的数据
     */
    @Select("select * from ${TableName} where id = ${Tid} and ${Tablelogic}=1")
    public ${Table} findLogicDelById(Long id);

    /**
     * 查询所有已经逻辑删除的数据
     */
    @Select("select * from ${TableName} where ${Tablelogic}=1")
    public List<${Table}> findAllLogicDel();

    /**
     * 根据id物理删除数据
     */
    @Delete("delete from ${TableName} where id=${Tid}")
    public Boolean deleteTablelogic(Long id);

    /**
     * 根据id更新逻辑删除的数据
     * 复杂sql语句写在xml里面
     * @param ${table}
     */
    public Boolean updateLogicDelById(${Table} ${table});

}
