package com.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.oa.entity.Department;

@Mapper
public interface DepartmentMapper {
   
	int deleteByPrimaryKey(String sn);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String sn);
    
    List<Department> selectAll();

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}