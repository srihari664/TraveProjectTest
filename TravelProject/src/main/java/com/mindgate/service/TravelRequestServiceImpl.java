package com.mindgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindgate.dao.TravelRequestDAOImpl;
import com.mindgate.pojo.TravelBookingDetails;
import com.mindgate.pojo.TravelRequestDetails;

@Service
public class TravelRequestServiceImpl implements TravelRequestService
{

	
	public TravelRequestServiceImpl() {
		System.out.println("Travel Request Service object created !! ");
	}
	
	@Autowired
	TravelRequestDAOImpl travelRequestDAO;

	@Override
	public boolean addTravelRequest(TravelRequestDetails requestDetails) {
		
		return travelRequestDAO.addTravelRequest(requestDetails);
	}

	@Override
	public boolean updateTravelRequest(int requestId, TravelRequestDetails requestDetails) {
		
		return travelRequestDAO.updateTravelRequest(requestId, requestDetails);
	}

	@Override
	public boolean deleteTravelRequest(int requestId) {
		
		return travelRequestDAO.deleteTravelRequest(requestId);
	}

	@Override
	public TravelRequestDetails getTravelRequest(int requestId) {
		
		return travelRequestDAO.getTravelRequest(requestId);
	}

	@Override
	public List<TravelRequestDetails> getAllTravelRequest() {
		
		return travelRequestDAO.getAllTravelRequest();
	}
	public List<TravelRequestDetails> getEmployeeTravelRequest(int employeeId) {
		// TODO Auto-generated method stub
		return travelRequestDAO.getEmployeeTravelRequest(employeeId);
	}
	public List<TravelRequestDetails> getManagerTravelRequest(int employeeId) {
		// TODO Auto-generated method stub
		return travelRequestDAO.getManagerTravelRequest(employeeId);
	}
	public boolean approveRequest(int requestId) {
		return travelRequestDAO.approveRequest(requestId);
	}
	public boolean rejectRequest(int requestId) {
		return travelRequestDAO.rejectRequest(requestId);
	}
	public boolean checkSlab(TravelRequestDetails request){
		return travelRequestDAO.checkSlab(request);
	}
	public List<TravelRequestDetails> getDirectorTravelRequest(int employeeId) {
		// TODO Auto-generated method stub
		return travelRequestDAO.getDirectorTravelRequest(employeeId);
	}
	public List<TravelRequestDetails> getAgentTravelRequest() {
		// TODO Auto-generated method stub
		return travelRequestDAO.getAgentTravelRequest();
	}
	public boolean book(@PathVariable("requestId") int requestId) {
		
		return travelRequestDAO.book(requestId);
	}
	
	}
	

