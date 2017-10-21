package com.lv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lv.dao.DepartmentMapper;
import com.lv.domain.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	public List<Department> listAll() {
		
		return departmentMapper.selectByExample(null);
	}
	
}
