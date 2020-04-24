package com.vj.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vj.bo.PatientBO;

@Repository
public class PatientDAOimpl implements PatientDAO {
	
	private static final String INSERT_PATIENT="INSERT INTO CORONA_PATIENTREG VALUES(PATID,?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int insert(PatientBO bo) {
		int count=0;
		count=jt.update(INSERT_PATIENT,bo.getPatName(),bo.getPatAge(),bo.getLocation(),bo.getHospital());
		return count;
	}

}
