package com.cache.dao;

import com.cache.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 员工信息
 *
 * @author non human
 * on 2020/2/9
 */
@Mapper
public interface EmployeeDao {

    @Select("SELECT * FROM Employee WHERE id = #{id}")
    Employee getEmpById(Integer id);

}
