package com.mindgate.dao;

import java.util.List;

import com.mindgate.pojo.TravelBookingDetails;

public interface TravelBookingDAO {

	public boolean addBooking(TravelBookingDetails travelBookingDetails);

	public boolean updateBooking(int bookingId, TravelBookingDetails travelBookingDetails);


	public boolean deleteBooking(int bookingId);

	public TravelBookingDetails getBooking(int bookingId);

	public List<TravelBookingDetails> getAllBookings();


}
