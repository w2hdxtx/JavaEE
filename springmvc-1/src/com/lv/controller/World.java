package com.lv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("mvc2")
@Controller
public class World {
	
	@RequestMapping("lv")
	public String test1() {
		
		System.out.println("World test1");
		return "redirect:/mvc2/hello";
	}

	@RequestMapping("hello")
	public String test2() {
		
		System.out.println("World test2");
		return "success";
		
	}
	
}
