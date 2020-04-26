package com.vj.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.vj.command.PatientCommand;

@Component("patCmdValidator") //ordinary bean
public class PatientCommandValidator implements Validator {


	@Override 	// to Check whether correct command class is assigned or not
	public boolean supports(Class<?> clazz) {
		System.out.println("PatiendCommandValidator.supports()");
		return clazz.isAssignableFrom(PatientCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PatientCommand patCmd=null;
		System.out.println("PatiendCommandValidator.validate()");
		//typeCast
		patCmd=(PatientCommand)target;

		//server side form validations
		if(patCmd.getPatName()==null || patCmd.getPatName().equalsIgnoreCase("") || patCmd.getPatName().length()==0)
			errors.rejectValue("patName", "patient.name.required");
		if(patCmd.getPatAge()==null)
			errors.rejectValue("patAge", "patient.age.required");
		else if(patCmd.getPatAge()<18 || patCmd.getPatAge()>100)
			errors.rejectValue("patAge", "patient.age.range");
		
		if(patCmd.getLocation()==null || patCmd.getLocation().length()==0 || patCmd.getLocation()=="")
			errors.rejectValue("location", "patient.location.required");
		
		if(patCmd.getHospital()==null || patCmd.getHospital().length()==0 || patCmd.getHospital()=="")
			errors.rejectValue("hospital", "patient.hospital.required");
		else if(patCmd.getHospital().length()<3 || patCmd.getHospital().length()>20)
			errors.rejectValue("hospital", "patient.hospital.length");

	}

}
