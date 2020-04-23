package com.vj.service;

import java.util.List;

import com.vj.dto.EmployeeDTO;
import com.vj.dto.EmployeeResultDTO;

public interface EmployeeService {
   public List<EmployeeResultDTO>  search(EmployeeDTO dto);
}
