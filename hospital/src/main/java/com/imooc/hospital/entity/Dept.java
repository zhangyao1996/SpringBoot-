package com.imooc.hospital.entity;
/**
* @author zhangyao:
* @date 创建时间：Aug 29, 2018 3:57:56 PM
*/

import java.util.Date;

public class Dept {
	private Integer id;
	private Integer categoryId;
	private String name;
	private Date createTime;
	private Date updateTime;
	private Category category;
	public Dept() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Dept [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", category=" + category + "]";
	}
	
	
} 
