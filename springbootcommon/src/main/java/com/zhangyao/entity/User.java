package com.zhangyao.entity;
/**
* @author zhangyao:
* @date 创建时间：Sep 12, 2018 11:01:49 AM
*/

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

public class User {
	private String name;
	private Integer age;
	@JsonIgnore
	//忽略该字段
	private String password;
	@JsonFormat(pattern="yyyy-mm-dd",locale="zh",timezone="GMT+8")
	private Date birthday;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	//字段为空则不返回前段
	private String desc;
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	

}
