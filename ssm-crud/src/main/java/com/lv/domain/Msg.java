package com.lv.domain;

import java.util.HashMap;
import java.util.Map;



/**
 * code：响应状态，1成功，0失败
 * message：响应说明
 * map：用于封装返回的信息
 *
 */
public class Msg {
	
	
	private Integer code;
	private String message;
	private Map<String, Object> map = new HashMap<>();
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public Msg success() {
		
		this.code = 1;
		this.message = "处理成功";
		return this;
	}
	
	public Msg fail() {
		
		this.code = 0;
		this.message = "处理失败";
		return this;
	}

	public Msg add(String key, Object value) {
		
		this.map.put(key, value);
		return this;
	}
}
