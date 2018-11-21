package com.zhangyao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author zhangyao:
 * @date 创建时间：Nov 20, 2018 2:52:33 PM
 */
/*
 * 开发实体类==》自动生成数据表
 */
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 20)
	private String name;
	
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
