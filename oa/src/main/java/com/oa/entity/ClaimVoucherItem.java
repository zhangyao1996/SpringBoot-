package com.oa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ClaimVoucherItem {
	
	@Id
	@GeneratedValue
    private Integer id;

    private Integer claimVoucherId;

    private String item;

    private Double amount;

    private String comment;

}