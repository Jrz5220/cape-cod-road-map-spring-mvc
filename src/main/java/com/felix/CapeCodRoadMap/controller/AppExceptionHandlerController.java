package com.felix.CapeCodRoadMap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppExceptionHandlerController {
	
	@GetMapping("/AppExceptionHandler")
	public String appExceptionHandler() {
		return "error";
	}

}
