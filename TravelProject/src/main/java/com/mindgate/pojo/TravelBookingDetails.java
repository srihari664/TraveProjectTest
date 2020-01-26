package com.mindgate.pojo;



import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class TravelBookingDetails {
	private int BookingId;
	private AgentDetails agentDetails;
	private Timestamp travelStartDate;
	private Timestamp travelEndDate;
	private String currentAddress;
	private TravelRequestDetails travelRequestDetails;
	private String travelMedium;
	private String hotelAddress;
	private String eligibleForExchange;
public TravelBookingDetails() {
	// TODO Auto-generated constructor stub
}
public TravelBookingDetails(int bookingId, AgentDetails agentDetails, Timestamp travelStartDate,
		Timestamp travelEndDate, String currentAddress, TravelRequestDetails travelRequestDetails, String travelMedium,
		String hotelAddress, String eligibleForExchange) {
	super();
	BookingId = bookingId;
	this.agentDetails = agentDetails;
	this.travelStartDate = travelStartDate;
	this.travelEndDate = travelEndDate;
	this.currentAddress = currentAddress;
	this.travelRequestDetails = travelRequestDetails;
	this.travelMedium = travelMedium;
	this.hotelAddress = hotelAddress;
	this.eligibleForExchange = eligibleForExchange;
}
public int getBookingId() {
	return BookingId;
}
public void setBookingId(int bookingId) {
	BookingId = bookingId;
}
public AgentDetails getAgentDetails() {
	return agentDetails;
}
public void setAgentDetails(AgentDetails agentDetails) {
	this.agentDetails = agentDetails;
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
public String getCurrentAddress() {
	return currentAddress;
}
public void setCurrentAddress(String currentAddress) {
	this.currentAddress = currentAddress;
}
public TravelRequestDetails getTravelRequestDetails() {
	return travelRequestDetails;
}
public void setTravelRequestDetails(TravelRequestDetails travelRequestDetails) {
	this.travelRequestDetails = travelRequestDetails;
}
public String getTravelMedium() {
	return travelMedium;
}
public void setTravelMedium(String travelMedium) {
	this.travelMedium = travelMedium;
}
public String getHotelAddress() {
	return hotelAddress;
}
public void setHotelAddress(String hotelAddress) {
	this.hotelAddress = hotelAddress;
}
public String getEligibleForExchange() {
	return eligibleForExchange;
}
public void setEligibleForExchange(String eligibleForExchange) {
	this.eligibleForExchange = eligibleForExchange;
}
@Override
public String toString() {
	return "TravelBookingDetails [BookingId=" + BookingId + ", travelStartDate=" + travelStartDate + ", travelEndDate="
			+ travelEndDate + ", currentAddress=" + currentAddress + ", travelMedium=" + travelMedium
			+ ", hotelAddress=" + hotelAddress + ", eligibleForExchange=" + eligibleForExchange + "]";
}


}