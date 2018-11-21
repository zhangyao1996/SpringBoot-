package com.zhangyao.repository;

import org.springframework.data.repository.CrudRepository;

import com.zhangyao.entity.Employee;


/**
 * @author zhangyao:
 * @date 创建时间：Nov 20, 2018 4:44:58 PM
 */

public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer>{

}
