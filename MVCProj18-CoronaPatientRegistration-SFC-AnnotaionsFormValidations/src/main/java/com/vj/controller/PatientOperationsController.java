package com.vj.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vj.command.PatientCommand;
import com.vj.dto.PatientDTO;
import com.vj.service.PatientService;

@Controller
/*
 We should not keep COMMAND class OBJ in SESSION scope as
VFLAG value will not change as it uses same command class OBJECT
 */
//@SessionAttributes("patCmd")		//this will make IOC to use same COMMAND object by keeping it in Session Scope		
public class PatientOperationsController {

	@Autowired
	private PatientService service;


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
	/*	
		@PostMapping("/corona.htm")		//post back request
		public String registerForm(Map<String,Object> map,
				@Valid  @ModelAttribute("patCmd") PatientCommand cmd,
					BindingResult br) {
			System.out.println("PatientOperationsController.registerForm()");
			PatientDTO dto=null;
			String result=null;

			if(br.hasErrors()) {
				return "patient_registration";
			}


			//application logic errors given to bindResult
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
	//		map.put("resMsg", result);
			//return LVN
			return "redirect:/result.htm?resMsg="+result;	
		}*/


	/*	
		@PostMapping("/corona.htm")		//post back request
		public String registerForm(RedirectAttributes model,
				@Valid  @ModelAttribute("patCmd") PatientCommand cmd,
					BindingResult br) {
			System.out.println("PatientOperationsController.registerForm()");
			PatientDTO dto=null;
			String result=null;

			if(br.hasErrors()) {
				return "patient_registration";
			}


			//application logic errors given to bindResult
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
			model.addFlashAttribute("resMsg",result);
			model.addFlashAttribute("sysDate",new Date());
	//		model.addAttribute("resMsg",result);		
	//		model.addAttribute("sysDate",new Date());		//addAttribute cannot carry obj data only simple data
			//return LVN
			return "redirect:/result.htm";
		}

	 */

	@PostMapping("/corona.htm")		//post back request
	public String registerForm(HttpSession ses,
			@Valid  @ModelAttribute("patCmd") PatientCommand cmd,
			BindingResult br) {
		System.out.println("PatientOperationsController.registerForm()");
		PatientDTO dto=null;
		String result=null;

		if(br.hasErrors()) {
			return "patient_registration";
		}


		//application logic errors given to bindResult
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
		ses.setAttribute("resMsg", result);
		ses.setAttribute("sysDate", new Date());
		//return LVN
		return "redirect:/result.htm";
	}


	@GetMapping("/result.htm")
	public String showResultPage() {
		System.out.println("PatientOperationsController.showResultPage()");
		return "show_result";
	}


}
