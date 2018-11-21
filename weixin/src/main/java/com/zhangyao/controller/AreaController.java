package com.zhangyao.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.zhangyao.entity.Area;
import com.zhangyao.service.AreaService;

/**
* @author zhangyao:
* @date 创建时间：Sep 11, 2018 2:58:36 PM
*/
@RestController
@RequestMapping("/superadmin")
public class AreaController {
	@Autowired
	private AreaService areaService;
	
	@GetMapping("/listarea")
	private Map<String, Object> getAraeList(){
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<Area> list = new ArrayList<Area>();
		// 获取区域列表
		list = areaService.getAreaLists();
		modelMap.put("areaList", list);
		return modelMap; 
	}
	
	@GetMapping("/getarea")
	private Area getAreaById(Integer areaId) {
		Area area=areaService.getAreaById(areaId);
		return area;
	}
	@PostMapping(value = "/addarea")
	//@RequestBody获取前端传来的json等类型属性
	private Map<String, Object> addArea(@RequestBody Area area)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 添加区域信息
		modelMap.put("success", areaService.addArea(area));
		return modelMap;
	}

	
	@PostMapping(value = "/modifyarea")
	private Map<String, Object> modifyArea(@RequestBody Area area)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", areaService.modifyArea(area));
		return modelMap;
	}

	@DeleteMapping(value = "/removearea")
	private Map<String, Object> removeArea(Integer areaId) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		// 修改区域信息
		modelMap.put("success", areaService.deleteArea(areaId));
		return modelMap;
	}

	
	
}
