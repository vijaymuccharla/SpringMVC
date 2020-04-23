package com.vj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("Main")
public class MainController {
	
	@RequestMapping("/welcome.htm")
	public String welcomePage() {
		return "home";
	}
	
}
