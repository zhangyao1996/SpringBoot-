package com.zhangyao.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangyao.entity.Resource;

/**
* @author zhangyao:
* @date 创建时间：Sep 12, 2018 2:49:28 PM
*/
@Controller
@RequestMapping("/ftl")
public class FreemarkerController {

	@Autowired
	private Resource resource;
	@RequestMapping("/center")
	public String getCenter() {
		return "freemaker/center";
	}
	
	@RequestMapping("/index")
	public String getIndex(ModelMap map) {
		
		map.addAttribute("resource",resource);
		return "freemaker/index";
	}
}
