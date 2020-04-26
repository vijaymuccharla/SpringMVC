package com.vj.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vj.command.PatientCommand;
import com.vj.dto.PatientDTO;
import com.vj.service.PatientService;

@Controller
@SessionAttributes("patCmd")
public class PatientOperationsController {

	@Autowired
	private PatientService service;

	//for giving only one PatientCommand object per session
	@ModelAttribute("patCmd")
	public PatientCommand getPatCmd() {
		System.out.println("PatientOperationsController.getPatCmd()");
		return new PatientCommand();
	}
	
	
	@GetMapping("/corona.htm")		//for initial page request
	public String showForm(@ModelAttribute("patCmd") PatientCommand cmd ) {
		System.out.println("PatientOperationsController.showForm()");
		cmd.setLocation("hyd");
		cmd.setHospital("Yahsodha Hospital");
		//return LVN
		return "patient_registration";
			
	}
	
	@PostMapping("/corona.htm")
	public String registerForm(Map<String,Object> map,
				@ModelAttribute("patCmd") PatientCommand cmd,
				BindingResult br) {
		System.out.println("PatientOperationsController.registerForm()");
		PatientDTO dto=null;
		String result=null;
		//convert cmd to DTO
		dto=new PatientDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		result=service.register(dto);
		//keep result int Model attribute
		map.put("resMsg", result);
		//return LVN
		return "show_result";
		 
		
	}
	
}
