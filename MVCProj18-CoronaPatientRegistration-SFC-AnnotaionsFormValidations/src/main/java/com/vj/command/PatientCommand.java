package com.vj.command;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class PatientCommand {
	
	@NotEmpty(message = "*Patient name is required(d)")
	private String patName;
	
	@NotNull(message = "*Patient Age is required (d)")
	@Range(min=18,max = 100, message = "*Age must be 18-100 (d)")
	private Integer patAge;
	
	@NotEmpty(message = " *Location name needed(d)")
	private String location;
	
	@NotEmpty(message = " *Hospital name needed(d)")
	@Length(min = 4,max = 20, message = " *min 4-20 chars allowed(d)")
	private String hospital;
	
	private String vflag="no";
	
	
	
	public PatientCommand() {
		System.out.println("PatientCommand.0-Param contructor");
	}
	
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public Integer getPatAge() {
		return patAge;
	}
	public void setPatAge(Integer patAge) {
		this.patAge = patAge;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	

	public String getVflag() {
		return vflag;
	}

	public void setVflag(String vflag) {
		this.vflag = vflag;
	}

	
}
