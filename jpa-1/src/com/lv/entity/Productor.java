package com.lv.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table(name="JPA_PRODUCTOR")
@Entity
public class Productor {

	private Integer id;
	private String name;
	private Set<Category> categories = new HashSet<>();
	
	@Column(name="P_ID")
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="P_NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JoinTable(name="PRODUCT_CATEGORY",
			joinColumns= {@JoinColumn(name="PP_ID",referencedColumnName="P_ID")},
			inverseJoinColumns= {@JoinColumn(name="CC_ID",referencedColumnName="C_ID")})
	@ManyToMany
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	
	
}
