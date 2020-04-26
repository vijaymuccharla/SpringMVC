package com.vj.command;

public class PatientCommand {
	
	private String patName;
	private Integer patAge;
	private String location;
	private String hospital;
	
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
	
	
	
}
