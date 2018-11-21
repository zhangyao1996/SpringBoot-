package com.imooc.hospital.entity;
/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 3:58:11 PM
*/

import java.util.Date;

public class Category {
	private Integer id;
	private String name;
	private Date createTime;
	private Date updateTime;
	
	public Category() {
		super();
	}
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
