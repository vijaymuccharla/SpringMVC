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
import com.vj.validator.PatientCommandValidator;

@Controller
/*
 We should not keep COMMAND class OBJ in SESSION scope as
VFLAG value will not change as it uses same command class OBJECT
*/
//@SessionAttributes("patCmd")		//this will make IOC to use same COMMAND object by keeping it in Session Scope		
public class PatientOperationsController {

	@Autowired
	private PatientService service;
	@Autowired		//injecting validator class to Controller
	private PatientCommandValidator validator;

	//for giving only one PatientCommand object per session
	@ModelAttribute("patCmd")		//initial request wrapping
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
	
	@PostMapping("/corona.htm")		//post back request
	public String registerForm(Map<String,Object> map,
				@ModelAttribute("patCmd") PatientCommand cmd,
				BindingResult br) {
		System.out.println("PatientOperationsController.registerForm()");
		PatientDTO dto=null;
		String result=null;
		
		//enable server-side validations only if cilent-side validations are not done
		//get vflag value from form hidden vflag value
		if(cmd.getVflag().equalsIgnoreCase("no")) {
		System.out.println("PatientOperationsController.registerForm()---> server side validations......");
		//calling supports(),validator() methods for performing server-side validations
		if(validator.supports(PatientCommand.class))
			validator.validate(cmd, br);			
			if(br.hasErrors())
				return "patient_registration";
		}
		
		if(cmd.getLocation().equalsIgnoreCase("hyd") || cmd.getLocation().equalsIgnoreCase("HYD") || cmd.getLocation().equalsIgnoreCase("hyderabad") || cmd.getLocation().equalsIgnoreCase("Hdearabad")) {
			br.rejectValue("location", "loc.blocked");
			return "patient_registration";
		}
		
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
