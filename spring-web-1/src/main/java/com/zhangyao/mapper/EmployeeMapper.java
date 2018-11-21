package com.zhangyao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhangyao.entity.Employee;
@Mapper
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    List<Employee> selectEmployees();
}