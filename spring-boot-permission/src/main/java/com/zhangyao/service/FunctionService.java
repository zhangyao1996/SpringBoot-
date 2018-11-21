package com.zhangyao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangyao.mapper.FunctionMapper;

/**
* @author zhangyao:
* @date 创建时间：Nov 21, 2018 3:14:14 PM
*/
@Service
public class FunctionService {
	@Autowired
	private FunctionMapper functionMapper;
}
