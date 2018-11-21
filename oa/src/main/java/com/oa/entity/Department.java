package com.oa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Department {
	

	@Id
	@GeneratedValue
    private String sn;

    private String name;

    private String address;

}