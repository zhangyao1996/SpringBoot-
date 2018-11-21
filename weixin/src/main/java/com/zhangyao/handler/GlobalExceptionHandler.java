package com.zhangyao.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @author zhangyao:
* @date 创建时间：Sep 11, 2018 3:29:04 PM
*/
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) throws Exception {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("success", false);
		modelMap.put("errMsg", e.getMessage());
		return modelMap;
	}
}
