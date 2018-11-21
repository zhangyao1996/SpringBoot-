package com.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oa.entity.Employee;

@Mapper
public interface EmployeeMapper {
   
	int deleteByPrimaryKey(String sn);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String sn);
    
    List<Employee> getAll();

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}