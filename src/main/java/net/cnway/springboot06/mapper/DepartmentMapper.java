package net.cnway.springboot06.mapper;

import net.cnway.springboot06.bean.Department;
import org.apache.ibatis.annotations.*;

//指定这是一个操作数据库的mapper
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDepartmentById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDepartmentById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department (departmentName) values(#{departmentName})")
    public int insertDepartment(Department department);

    @Delete("update department set departmentName=#{departmentName} where id=#{id}")
    public int updateDepartment(Department department);
}
