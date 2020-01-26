package com.mindgate.dao;

import java.util.List;

import com.mindgate.pojo.TravelRequestDetails;

public interface TravelRequestDAO {
	
	public boolean addTravelRequest(TravelRequestDetails requestDetails);

	public boolean updateTravelRequest(int requestId, TravelRequestDetails requestDetails);

	public boolean deleteTravelRequest(int requestId);

	public TravelRequestDetails getTravelRequest(int requestId);

	public List<TravelRequestDetails> getAllTravelRequest();
	

}
