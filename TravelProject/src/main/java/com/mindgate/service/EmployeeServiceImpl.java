package com.mindgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.dao.EmployeeDAOImpl;
import com.mindgate.pojo.EmployeeDetails;
@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeDAOImpl employeeDAOImpl;

	@Override
	public boolean addEmployee(EmployeeDetails employeeDetails) {
		return employeeDAOImpl.addEmployee(employeeDetails);
	}

	@Override
	public boolean updateEmployee(int employeeId, EmployeeDetails employeeDetails) {
		return employeeDAOImpl.updateEmployee(employeeId, employeeDetails);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		return employeeDAOImpl.deleteEmployee(employeeId);
	}

	@Override
	public EmployeeDetails getEmployee(int employeeId) {
		return employeeDAOImpl.getEmployee(employeeId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		return employeeDAOImpl.getAllEmployees();
	}
	public EmployeeDetails employeeLogin(EmployeeDetails details) {
		return employeeDAOImpl.employeeLogin(details);
	}
	
	
	}


