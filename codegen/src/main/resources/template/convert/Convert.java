package ${package_convert};

import ${package_bo}.${Table}BO;
import ${package_dto}.${Table}AddDTO;
import ${package_dto}.${Table}QueryDTO;
import ${package_dto}.${Table}UpdateDTO;
import ${package_pojo}.${Table};
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description ${Table}Convert
 * @Author ${author}
 * @Date ${create_time}
 **/
@Mapper
public interface ${Table}Convert {

    /** 默认的方式 **/
    ${Table}Convert INSTANCE = Mappers.getMapper(${Table}Convert.class);

    ${Table} convert(${Table}AddDTO ${table}AddDTO);

    ${Table} convert(${Table}QueryDTO ${table}QueryDTO);

    ${Table} convert(${Table}UpdateDTO ${table}UpdateDTO);

    ${Table}BO convert(${Table} ${table});

    List<${Table}BO> convert(List<${Table}> ${table}List);
}