package com.lv.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="JPA_CATEGORY")
@Entity
public class Category {
	
	private Integer id;
	private String name;
	private Set<Productor> productors = new HashSet<>();
	
	@Column(name="C_ID")
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="C_NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(mappedBy="categories")
	public Set<Productor> getProductors() {
		return productors;
	}
	public void setProductors(Set<Productor> productors) {
		this.productors = productors;
	}
	
	

}
