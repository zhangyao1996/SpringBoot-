package com.oa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
@Entity
public class DealRecord {
	

	@Id
	@GeneratedValue
    private Integer id;

    private Integer claimVoucherId;

    private String dealSn;
    
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm")
    private Date dealTime;

    private String dealWay;

    private String dealResult;

    private String comment;


}