package com.zhangyao.entity;

import lombok.Data;

/**
* @author zhangyao:
* @date 创建时间：Oct 17, 2018 2:41:38 PM
*/
@Data
public class ResultBean {
	
	public ResultBean(String data) {
		super();
		this.data = data;
	}

	private String data;

}
