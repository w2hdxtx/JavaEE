package com.lv.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lv.dao.DepartmentMapper;
import com.lv.domain.Department;
import com.lv.domain.Employee;
import com.lv.domain.Msg;
import com.lv.service.DepartmentService;
import com.lv.service.EmployeeService;

@Controller
public class CRUDController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;

	
	@ResponseBody
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public Msg listAll(@RequestParam("pageNum")Integer pageNum) {
		
		PageHelper.startPage(pageNum, 5); //页码pageNum从1开始，每页显示5条记录
		List<Employee> employees = employeeService.listAll();
		PageInfo<Employee> pageInfo = new PageInfo<>(employees,5);
		
		Msg msg = new Msg();
		msg.success().add("pageInfo", pageInfo);
		return msg;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public Msg saveEmp(@Valid Employee employee, BindingResult result) {
		
		Msg msg = new Msg();
		if (result.getErrorCount()>0) {   //检验出错
			msg.fail();
			for(FieldError error: result.getFieldErrors()){       //把出错JavaBean属性和信息放入map
				msg.add(error.getField(), error.getDefaultMessage());
			}

		}else {
			msg.success();
			employeeService.save(employee);
		}
			
		return msg;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/depts",method=RequestMethod.GET)
	public Msg getDepts() {
		
		Msg msg = new Msg();
		
		List<Department> departments = departmentService.listAll();
		
		msg.success().add("depts", departments);
		return msg;
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/validateLastName",method=RequestMethod.POST)
	public Msg validateLastName(@RequestParam("lastName")String lastName) {
		
		Msg msg = new Msg();
		Boolean flag = employeeService.hasEmp(lastName);//判断用户名是否存在
		if (flag)
			msg.fail();
		else
			msg.success();
		return msg;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/delete/{empId}",method=RequestMethod.DELETE)
	public Msg delete(@PathVariable("empId") Integer id) {
		
		Msg msg = new Msg();
		employeeService.delete(id);
		msg.success();
		return msg;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public Msg beforeUpdate(@RequestParam("empId") Integer id) {
		
		Msg msg = new Msg();
		Employee employee = employeeService.selectEmpsWithDeptBPrimaryKey(id);
		if(employee != null)
			msg.add("emp", employee).success();
		else
			msg.fail();
		return msg;
	}
	

	@ResponseBody
	@RequestMapping(value="/update/{empId}",method=RequestMethod.PUT)
	public Msg update(Employee employee) {
		
		employeeService.update(employee);
		Msg msg = new Msg();
		msg.success();
		return msg;
	}
	
	
	
}









