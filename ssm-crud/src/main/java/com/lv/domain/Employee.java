package com.lv.domain;

import javax.validation.constraints.Pattern;

public class Employee {
    private Integer id;
    
    @Pattern(regexp="(^[a-zA-Z0-9_-]{3,12}$)|(^[\\u2E80-\\u9FFF]{1,4})$",
    		message="后台：用户名必须是3-12位字母数字组合或者1-4个汉字")
    private String lastName;
    
    @Pattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
    		message="后台：邮箱格式不正确")
    private String email;

    private String gender;

    private Integer deptId;

    private Department department;
   
	public Employee() {
		super();
	}

	public Employee(Integer id, String lastName, String email, String gender, Integer deptId) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.deptId = deptId;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? null : lastName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", deptId="
				+ deptId + ", department=" + department + "]";
	}

	
    
    
}