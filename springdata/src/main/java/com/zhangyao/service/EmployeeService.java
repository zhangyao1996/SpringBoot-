
package com.zhangyao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zhangyao.entity.Employee;
import com.zhangyao.repository.EmployeeCrudRepository;
import com.zhangyao.repository.EmployeeJpaRepository;
import com.zhangyao.repository.EmployeeJpaSpecificationExecutorRepository;
import com.zhangyao.repository.EmployeePagingAndSortingRepository;
import com.zhangyao.repository.EmployeeRepository;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Service
public class EmployeeService<X> {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeCrudRepository employeeCrudRepository;

	@Autowired
	private EmployeePagingAndSortingRepository employeePagingAndSortingRepository;
	
	@Autowired
	private EmployeeJpaRepository employeeJpaRepository;
	
	@Autowired
	private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository;
	
	@Transactional
	public void update(Integer id, Integer age) {
		employeeRepository.update(id, age);
	}
	
	@Transactional
	public void save(List<Employee> employees) {
		employeeCrudRepository.save(employees);
	}
	
	
	
	public Page<Employee> findAll(Pageable pageable){
		return employeePagingAndSortingRepository.findAll(pageable);
	}

	
	public List<Employee> employees(){
		return employeeJpaRepository.findAll();
	}
	
	public Page<Employee> findAllBy(Pageable pageable){
		Specification<Employee> specification=new Specification<Employee>() {

			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Path path=root.get("id");
				return cb.gt(path, 20);
			}
		};
		return employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);
	}
	
}
