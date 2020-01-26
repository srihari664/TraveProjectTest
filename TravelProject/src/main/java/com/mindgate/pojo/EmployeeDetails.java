package com.mindgate.pojo;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDetails {

	private int employeeId;
	private String name;
	private String email;
	private String password;
	private  SlabDetails slabDetails;
	private int managerId;
	private String designation;

	public EmployeeDetails() {
	}

	public EmployeeDetails(int employeeId, String name, String email, String password, SlabDetails slabDetails,
			int managerId,String designation) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.slabDetails = slabDetails;
		this.managerId = managerId;
		this.designation= designation;
	}

	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SlabDetails getSlabDetails() {
		return slabDetails;
	}

	public void setSlabDetails(SlabDetails slabDetails) {
		this.slabDetails = slabDetails;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ", password="
				+ password + ", slabDetails=" + slabDetails + ", managerId=" + managerId + ", designation="
				+ designation + "]";
	}
	
	

	
	
}
