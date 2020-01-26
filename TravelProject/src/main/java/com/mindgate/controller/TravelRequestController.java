package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.pojo.TravelRequestDetails;
import com.mindgate.service.TravelRequestServiceImpl;
@CrossOrigin(value="*")
@RestController
@RequestMapping("/request")
public class TravelRequestController {

	public TravelRequestController() {
		System.out.println("EmployeeController object is created !!");
	}

	@Autowired
	TravelRequestServiceImpl travelRequestService;
	
	
	@RequestMapping(value="/",method = RequestMethod.POST)
	public boolean addTravelRequest(@RequestBody TravelRequestDetails requestDetails) {
		
		return travelRequestService.addTravelRequest(requestDetails);
	}
	@RequestMapping(value="/{requestId}",method = RequestMethod.PUT)
	public boolean updateTravelRequest(@PathVariable("requestId") int requestId, @RequestBody TravelRequestDetails requestDetails) {
		
		return travelRequestService.updateTravelRequest(requestId, requestDetails);
	}
	@RequestMapping(value="/{requestId}",method = RequestMethod.DELETE)
	public boolean deleteTravelRequest(@PathVariable("requestId") int requestId) {
		
		return travelRequestService.deleteTravelRequest(requestId);
	}
	@RequestMapping(value="/{requestId}",method = RequestMethod.GET)
	public TravelRequestDetails getTravelRequest(@PathVariable("requestId") int requestId) {
		
		return travelRequestService.getTravelRequest(requestId);
	}
	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	public List<TravelRequestDetails> getAllTravelRequest() {
		
		return travelRequestService.getAllTravelRequest();
	}
	@RequestMapping(value="/getEmployeeRequest/{employeeId}",method=RequestMethod.GET)
	public List<TravelRequestDetails> getEmployeeTravelRequest(@PathVariable("employeeId") int employeeId) 
	{
		// TODO Auto-generated method stub
		return travelRequestService.getEmployeeTravelRequest(employeeId);
	}
	@RequestMapping(value="/getManagerRequest/{employeeId}",method=RequestMethod.GET)
	public List<TravelRequestDetails> getManagerTravelRequest(@PathVariable("employeeId") int employeeId) 
	{
	
		return travelRequestService.getManagerTravelRequest(employeeId);
	}
	@RequestMapping(value="/approveRequest/{requestId}",method=RequestMethod.GET)
	public boolean approveRequest(@PathVariable("requestId") int requestId) {
		return travelRequestService.approveRequest(requestId);
	}
	@RequestMapping(value="/rejectRequest/{requestId}",method=RequestMethod.GET)
	public boolean rejectRequest(@PathVariable("requestId") int requestId) {
		return travelRequestService.rejectRequest(requestId);
	}
	@RequestMapping(value="/checkSlab",method = RequestMethod.POST)
	public boolean checkSlab(@RequestBody TravelRequestDetails request){
		return travelRequestService.checkSlab(request);
	}
	@RequestMapping(value="/getDirectorRequest/{employeeId}",method=RequestMethod.GET)
	public List<TravelRequestDetails> getDirectorTravelRequest(@PathVariable("employeeId") int employeeId) 
	{
		
		return travelRequestService.getDirectorTravelRequest(employeeId);
	}
	@RequestMapping(value="/getAgentRequest",method=RequestMethod.GET)
	public List<TravelRequestDetails> getAgentTravelRequest() {
		// TODO Auto-generated method stub
		return travelRequestService.getAgentTravelRequest();
	}
	@RequestMapping(value="/book/{requestId}",method=RequestMethod.GET)
	public boolean book(@PathVariable("requestId") int requestId) {
		
		return travelRequestService.book(requestId);
	}
	
}

	