package com.oa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/*
 * 报销单实体类
 */
@Entity
@Data
public class ClaimVoucher {


	@Id
	@GeneratedValue
    private Integer id;

    private String cause;

    private String createSn;
    
    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm")
    private Date createTime;

    private String nextDealSn;

    private Double totalAmount;

    private String status;
    
    private Employee creater;
    
    private Employee dealer;
}