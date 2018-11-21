package com.imooc.sm.entity;
/**
* @author zhangyao:
* @date 创建时间：Aug 28, 2018 1:31:21 PM
*/
public class Department {
	private Integer id;
    private String name;
    private String address;

	public Department(Integer id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Department() {
		super();
	}
	public Department(String name, String address) {
		super();
		this.name = name;
		this.address = address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
