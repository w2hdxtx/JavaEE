package com.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Hello {

	
	@RequestMapping("hh/{id}")
	public String test1(@PathVariable("id") String id) {
		
		System.out.println("Hello:"+id);
		return "success";
	}
	
}
