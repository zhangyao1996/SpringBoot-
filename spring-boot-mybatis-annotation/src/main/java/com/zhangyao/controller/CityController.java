package com.zhangyao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zhangyao.entity.City;
import com.zhangyao.service.CityService;

/**
* @author zhangyao:
* @date 创建时间：Sep 19, 2018 3:13:46 PM
*/
@RestController
public class CityController {
	@Autowired
	private CityService cityService;
	
	@GetMapping("/getCity/{name}")
	public City get(@PathVariable("name") String name) {
		System.out.println(cityService.getCityByName(name));
		return cityService.getCityByName(name);
		
	}
}
