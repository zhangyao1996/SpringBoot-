package com.zhangyao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
* @author zhangyao:
* @date 创建时间：Sep 10, 2018 2:09:33 PM
*/
@Entity
public class Girl {
	@Id
	@GeneratedValue
	private Integer id;
	@Min(value=18, message="禁止未成年入内")
	private Integer age;
	private String cupSize;
	@NotNull(message = "金额必传")
    private Double money;
	
	public Girl() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getCupSize() {
		return cupSize;
	}
	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
}
