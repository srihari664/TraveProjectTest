package com.mindgate.pojo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class TravelRequestDetails {
	
	private int requestId;
	private EmployeeDetails employeeDetails;
	private String status;
	private String travelFrom;
	private String travelTo;
	private String modeOfTravel;
    private String domesticOrInternational;
    private String eligibleForExchange;
    private Timestamp travelStartDate;
	private Timestamp travelEndDate;
    
public TravelRequestDetails() {
	// TODO Auto-generated constructor stub
}

public TravelRequestDetails(int requestId, EmployeeDetails employeeDetails, String status, String travelFrom,
		String travelTo, String modeOfTravel, String domesticOrInternational, String eligibleForExchange,Timestamp travelStartDate,Timestamp travelEndDate) {
	super();
	this.requestId = requestId;
	this.employeeDetails = employeeDetails;
	this.status = status;
	this.travelFrom = travelFrom;
	this.travelTo = travelTo;
	this.modeOfTravel = modeOfTravel;
	this.domesticOrInternational = domesticOrInternational;
	this.eligibleForExchange = eligibleForExchange;
	this.travelStartDate = travelStartDate;
	this.travelEndDate = travelEndDate;
}

public int getRequestId() {
	return requestId;
}

public void setRequestId(int requestId) {
	this.requestId = requestId;
}

public EmployeeDetails getEmployeeDetails() {
	return employeeDetails;
}

public void setEmployeeDetails(EmployeeDetails employeeDetails) {
	this.employeeDetails = employeeDetails;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getTravelFrom() {
	return travelFrom;
}

public void setTravelFrom(String travelFrom) {
	this.travelFrom = travelFrom;
}

public String getTravelTo() {
	return travelTo;
}

public void setTravelTo(String travelTo) {
	this.travelTo = travelTo;
}

public String getModeOfTravel() {
	return modeOfTravel;
}

public void setModeOfTravel(String modeOfTravel) {
	this.modeOfTravel = modeOfTravel;
}

public String getDomesticOrInternational() {
	return domesticOrInternational;
}

public void setDomesticOrInternational(String domesticOrInternational) {
	this.domesticOrInternational = domesticOrInternational;
}

public String getEligibleForExchange() {
	return eligibleForExchange;
}

public void setEligibleForExchange(String eligibleForExchange) {
	this.eligibleForExchange = eligibleForExchange;
}

public Timestamp getTravelStartDate() {
	return travelStartDate;
}
public void setTravelStartDate(Timestamp travelStartDate) {
	this.travelStartDate = travelStartDate;
}
public Timestamp getTravelEndDate() {
	return travelEndDate;
}
public void setTravelEndDate(Timestamp travelEndDate) {
	this.travelEndDate = travelEndDate;
}

@Override
public String toString() {
	return "TravelRequestDetails [requestId=" + requestId + ", employeeDetails=" + employeeDetails + ", status="
			+ status + ", travelFrom=" + travelFrom + ", travelTo=" + travelTo + ", modeOfTravel=" + modeOfTravel
			+ ", domesticOrInternational=" + domesticOrInternational + ", eligibleForExchange=" + eligibleForExchange
			+ ", travelStartDate=" + travelStartDate + ", travelEndDate=" + travelEndDate + "]";
}




    
}
