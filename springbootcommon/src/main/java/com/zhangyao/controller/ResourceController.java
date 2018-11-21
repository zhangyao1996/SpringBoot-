package com.zhangyao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangyao.entity.Resource;
import com.zhangyao.utils.IMoocJSONResult;

/**
* @author zhangyao:
* @date 创建时间：Sep 12, 2018 2:06:58 PM
*/
@RestController
public class ResourceController {

	@Autowired
	private Resource resource;
	
	@RequestMapping("/getresource")
	public IMoocJSONResult getResource() {
		
		return IMoocJSONResult.ok(resource);
	}
}
