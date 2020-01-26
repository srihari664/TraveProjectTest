package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.TravelBookingDetails;

public interface TravelBookingService {
	
	public boolean addBooking(TravelBookingDetails travelBookingDetails);

	public boolean updateBooking(int bookingId, TravelBookingDetails travelBookingDetails);


	public boolean deleteBooking(int bookingId);

	public TravelBookingDetails getBooking(int bookingId);

	public List<TravelBookingDetails> getAllBookings();


}
