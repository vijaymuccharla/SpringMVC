package com.vj.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vj.dto.EmployeeDTO;
import com.vj.service.EmployeeMgmtService;

@Controller("empController")
public class ListEmployeesController  {
	@Autowired
	private EmployeeMgmtService  service;


	@RequestMapping("/welcome.htm")
	public String showHome()  throws Exception {
		return "home"; 
	}

	@RequestMapping("/list_emps.htm")
	public String getEmps(Map<String,Object> map) throws Exception {
		List<EmployeeDTO> listDTO=null;
		//use service
		listDTO=service.fetchAllEmps();
		//pud model into map
		//return view name and model data
		map.put("listDTO", listDTO);
		return "show_emps";
	}

}
