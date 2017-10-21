package com.lv.test;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.lv.dao.DepartmentMapper;
import com.lv.dao.EmployeeMapper;
import com.lv.domain.Employee;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml",
		"file:src/main/webapp/WEB-INF/springDispatcherServlet-servlet.xml"})
public class MVCTest {
	
	//Spring的IOC容器
	@Autowired
	private WebApplicationContext context;
	
	//用于模拟发送http请求
	private MockMvc mockMvc;
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	

	
	@Test
	public void testMVC() throws Exception {
		
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pageNum", "1")).andReturn();
		MockHttpServletRequest request = result.getRequest();
		PageInfo<Employee> pageInfo = (PageInfo<Employee>) request.getAttribute("pageInfo");
		
		System.out.println("当前页码："+pageInfo.getPageNum());
		System.out.println("总页码："+pageInfo.getPages());
		System.out.println("总记录数："+pageInfo.getTotal());
		
		System.out.println("是否第一页："+pageInfo.isIsFirstPage());
		System.out.println("是否最后一页："+pageInfo.isIsLastPage());
		System.out.println("是否有下一页："+pageInfo.isHasNextPage());
		System.out.println("是否有上一页："+pageInfo.isHasPreviousPage());
		
		System.out.println("在页面需要连续显示的页码");
		int[] nums = pageInfo.getNavigatepageNums();
		for (int i : nums) {
			System.out.print(" "+i);
		}
		System.out.println();
		
		//获取员工数据
		List<Employee> list = pageInfo.getList();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	
//	@Test
	public void test1() {
		

		List<Employee> employees = employeeMapper.selectByExample(null);
		for(Employee employee: employees)
			System.out.println(employee);
				
		
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i = 0;i<100;i++){
			String uid = UUID.randomUUID().toString().substring(0,5)+i;
			mapper.insertSelective(new Employee(null,uid, uid+"@qq.com",""+i%2, i%3+1));
		}
		System.out.println("批量完成");
		
	}
	
	

}





















