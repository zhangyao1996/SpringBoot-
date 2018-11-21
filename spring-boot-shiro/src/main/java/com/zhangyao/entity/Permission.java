package com.zhangyao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
* @author zhangyao:
* @date 创建时间：Oct 17, 2018 11:04:33 AM
*/
@Entity
public class Permission {
	@Id
	private Integer id;
	private String permission;
	private String roleName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Permission [id=" + id + ", permission=" + permission + ", roleName=" + roleName + "]";
	}
	
}
