package com.mindgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.dao.TravelBookingDAOImpl;
import com.mindgate.pojo.TravelBookingDetails;
@Service
public class TravelBookingServiceImpl implements TravelBookingService {
	@Autowired
	TravelBookingDAOImpl travelBookingDAOImpl;
	public boolean addBooking(TravelBookingDetails travelBookingDetails) {
		// TODO Auto-generated method stub
		return travelBookingDAOImpl.addBooking(travelBookingDetails);
		}
	
	public boolean updateBooking(int bookingId, TravelBookingDetails travelBookingDetails) {
		// TODO Auto-generated method stub
		return travelBookingDAOImpl.updateBooking(bookingId, travelBookingDetails);
	}


	public boolean deleteBooking(int bookingId) {
		// TODO Auto-generated method stub
		return travelBookingDAOImpl.deleteBooking(bookingId);
	}

	
	public TravelBookingDetails getBooking(int bookingId) {
		// TODO Auto-generated method stub
		return travelBookingDAOImpl.getBooking(bookingId);
	}



	public List<TravelBookingDetails> getAllBookings() {
		// TODO Auto-generated method stub
		return travelBookingDAOImpl.getAllBookings();
	}

}
