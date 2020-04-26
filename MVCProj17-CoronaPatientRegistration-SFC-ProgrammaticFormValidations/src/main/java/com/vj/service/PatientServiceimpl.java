package com.vj.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vj.bo.PatientBO;
import com.vj.dao.PatientDAO;
import com.vj.dto.PatientDTO;

@Service
public class PatientServiceimpl implements PatientService {
	
	@Autowired
	PatientDAO dao;
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String register(PatientDTO dto) {
		int count=0;
		PatientBO bo=null;
		//convert DTO to BO
		bo=new PatientBO();
		BeanUtils.copyProperties(dto, bo);
		
		//use DAO
		count=dao.insert(bo);
		return count==0?" Patient Registration Failed ":" Patient Registration Success ";
	}

}
