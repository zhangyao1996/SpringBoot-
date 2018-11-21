package com.zhangyao.entity;



/**
* @author zhangyao:
 * @param <T>
* @date 创建时间：Sep 11, 2018 9:01:18 AM
*/
public class Result<T> {
	//错误码
	private Integer code;
	//提示信息
	private String msg;
	//数据
	private T date;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getDate() {
		return date;
	}
	public void setDate(T date) {
		this.date = date;
	}
	
	
}
