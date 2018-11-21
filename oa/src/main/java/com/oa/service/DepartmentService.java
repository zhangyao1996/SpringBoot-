package com.oa.service;
/**
* @author zhangyao:
* @date 创建时间：Sep 7, 2018 2:27:04 PM
*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oa.entity.Department;
import com.oa.mapper.DepartmentMapper;


@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<Department> getAll(){
		return departmentMapper.selectAll();
	}

	public int addDept(Department dept) {
		return departmentMapper.insert(dept);
	}
	
	public Department getDept(String sn) {
		return departmentMapper.selectByPrimaryKey(sn);
	}

	public int updateDept(Department dept) {
		return departmentMapper.updateByPrimaryKey(dept);
	}
	
	public void deleteDept(String sn) {
		departmentMapper.deleteByPrimaryKey(sn);
	}
}
