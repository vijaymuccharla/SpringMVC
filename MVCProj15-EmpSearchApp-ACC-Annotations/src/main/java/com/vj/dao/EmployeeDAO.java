package com.vj.dao;

import java.util.List;

import com.vj.bo.EmployeeBO;
import com.vj.bo.EmployeeResultBO;

public interface EmployeeDAO {
	
	public List<EmployeeResultBO>  find(EmployeeBO bo);

}
