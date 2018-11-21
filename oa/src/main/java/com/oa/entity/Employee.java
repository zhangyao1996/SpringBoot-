package com.oa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {
	

	@Id
	@GeneratedValue
    private String sn;

    private String password;

    private String name;

    private String departmentSn;

    private String post;

    private Department department;
}