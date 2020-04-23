package com.vj.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vj.service.WishMessageService;

@Controller("main")
public class MainController {
	@Autowired
	private WishMessageService service;
	
	@RequestMapping("/welcome.htm")
	public String homePage() {
		return "home";
	}
	
	/*@RequestMapping("/wish.htm")
	public ModelAndView process() {
		String msg=null;
		//use service
		msg=service.getWishMessage();
		//retunr Model And View Object with view name, ModelName, Model Object 
		return new ModelAndView("wish","wMsg",msg);
	}*/
	
	/*@RequestMapping("/wish.htm")
	public String process(Model model) {
		String msg=null;
		//use service
		msg=service.getWishMessage();
		//add  model data
		model.addAttribute("wMsg",msg);
		//retunr Model And View Object with view name, ModelName, Model Object 
		return "wish";
	}*/
	
	
	/*@RequestMapping("/wish.htm")
	public String process(ModelMap model) {
		String msg=null;
		//use service
		msg=service.getWishMessage();
		//add  model data
		model.addAttribute("wMsg",msg);
		//retunr Model And View Object with view name, ModelName, Model Object 
		return "wish";
	}*/
	
	@RequestMapping("/wish.htm")
	public String process(Map<String,Object> map) {
		String msg=null;
		//use service
		msg=service.getWishMessage();
		//add  model data
		map.put("wMsg", msg);
		//retunr Model And View Object with view name, ModelName, Model Object 
		return "wish";
	}
	
}
