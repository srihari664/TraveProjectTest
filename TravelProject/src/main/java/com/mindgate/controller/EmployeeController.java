package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.pojo.EmployeeDetails;
import com.mindgate.service.EmployeeServiceImpl;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public boolean addEmployee(@RequestBody EmployeeDetails employeeDetails) {
		return employeeService.addEmployee(employeeDetails);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
	public boolean updateEmployee(@PathVariable("employeeId") int employeeId,
			@RequestBody EmployeeDetails employeeDetails) {
		return employeeService.updateEmployee(employeeId, employeeDetails);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable("employeeId") int employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public EmployeeDetails getEmployee(@PathVariable("employeeId") int employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<EmployeeDetails> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public EmployeeDetails employeeLogin(@RequestBody EmployeeDetails details) {
		return employeeService.employeeLogin(details);
	}

}
