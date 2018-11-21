package com.zhangyao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyao.entity.Employee;
import com.zhangyao.mapper.EmployeeMapper;

/**
* @author zhangyao:
* @date 创建时间：Sep 26, 2018 3:55:50 PM
*/
@Service
public class EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public List<Employee> getAllEmps(){
		return employeeMapper.selectEmployees();
	}
	
	public int addEmp(Employee emp) {
		return employeeMapper.insert(emp);
	}
}
