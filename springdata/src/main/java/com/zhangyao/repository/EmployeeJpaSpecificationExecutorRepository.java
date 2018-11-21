package com.zhangyao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.zhangyao.entity.Employee;

/**
* @author zhangyao:
* @date 创建时间：Nov 21, 2018 9:09:05 AM
*/
public interface EmployeeJpaSpecificationExecutorRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

}
