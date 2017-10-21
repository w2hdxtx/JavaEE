package com.lv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lv.dao.EmployeeMapper;
import com.lv.domain.Employee;
import com.lv.domain.EmployeeExample;
import com.lv.domain.EmployeeExample.Criteria;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;

	@Transactional(readOnly=true)
	public List<Employee> listAll() {
		
		return employeeMapper.selectEmpsWithDeptByExample(null);
	}

	@Transactional
	public void save(Employee employee) {
		
		employeeMapper.insertSelective(employee); //选择性插入，只插入不为空的字段
		
	}

	@Transactional(readOnly=true)
	public Boolean hasEmp(String lastName) {
		
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andLastNameEqualTo(lastName);
		
		long count = employeeMapper.countByExample(example);
				
		return count > 0;
	}

	@Transactional
	public void delete(Integer id) {

		employeeMapper.deleteByPrimaryKey(id);
	}

	@Transactional(readOnly=true)
	public Employee selectEmpsWithDeptBPrimaryKey(Integer id) {
		
		return employeeMapper.selectEmpsWithDeptBPrimaryKey(id);
	}

	@Transactional
	public void update(Employee employee) {

		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	
	

}
