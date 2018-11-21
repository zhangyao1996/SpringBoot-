package com.zhangyao.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {
	
	@Id
	@GeneratedValue
    private Integer id;

    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, max = 8, message = "姓名长度必须大于 2 且小于 20 字")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "年龄大于 0")
    @Max(value = 300, message = "年龄不大于 300")
    private Integer age;
    
    @NotEmpty(message = "出生时间不能为空")
    private String birthday;

    /*public Integer getId() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }*/
}