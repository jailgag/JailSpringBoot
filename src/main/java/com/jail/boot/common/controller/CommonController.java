package com.jail.boot.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {
	
	//@ResponseBody
	
	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
}
