package com.oa.service;
/**
* @author zhangyao:
* @date 创建时间：Sep 7, 2018 2:27:04 PM
*/


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.oa.entity.Employee;
import com.oa.mapper.EmployeeMapper;




@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	
	public List<Employee> getAll() {
		return employeeMapper.getAll();
	}
	
	public int addEmp(Employee emp) {
		return employeeMapper.insert(emp);
	}
	
	public int deleteEmp(String sn) {
		return employeeMapper.deleteByPrimaryKey(sn);
	}
	
	public Employee getEmp(String sn) {
		System.out.println("emp的"+employeeMapper.selectByPrimaryKey(sn));
		return employeeMapper.selectByPrimaryKey(sn);
	}
	public int updateEmp(Employee employee) {
		return employeeMapper.updateByPrimaryKey(employee);
	}
	
}
