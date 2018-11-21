package com.zhangyao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Department {
	@Id
	@GeneratedValue
    private Integer id;

    private String departmentName;


}