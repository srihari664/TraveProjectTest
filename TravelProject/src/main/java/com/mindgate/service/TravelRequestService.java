package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.TravelRequestDetails;



public interface TravelRequestService 
{
	
	public boolean addTravelRequest(TravelRequestDetails requestDetails);

	public boolean updateTravelRequest(int requestId, TravelRequestDetails requestDetails);

	public boolean deleteTravelRequest(int requestId);

	public TravelRequestDetails getTravelRequest(int requestId);

	public List<TravelRequestDetails> getAllTravelRequest();
	
	
	
	

}
