package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.pojo.TravelBookingDetails;
import com.mindgate.service.TravelBookingServiceImpl;
@CrossOrigin(value="*")
@RestController
@RequestMapping("/booking")
public class TravelBookingController {
	@Autowired
	TravelBookingServiceImpl travelBookingServiceImpl;
	
	@RequestMapping(value="/",method = RequestMethod.POST)
	public boolean addBooking(@RequestBody TravelBookingDetails travelBookingDetails){
		return travelBookingServiceImpl.addBooking(travelBookingDetails);
	}
	@RequestMapping(value="/{bookingId}",method = RequestMethod.PUT)
	public boolean updateBooking(@PathVariable("bookingId")int bookingId, @RequestBody TravelBookingDetails travelBookingDetails) {
		// TODO Auto-generated method stub
		return travelBookingServiceImpl.updateBooking(bookingId, travelBookingDetails);
	}

	@RequestMapping(value="/{bookingId}",method = RequestMethod.DELETE)
	public boolean deleteBooking(@PathVariable("bookingId") int bookingId) {
		// TODO Auto-generated method stub
		return travelBookingServiceImpl.deleteBooking(bookingId);
	}

	@RequestMapping(value="/{bookingId}",method = RequestMethod.GET)
	public TravelBookingDetails getBooking(@PathVariable("bookingId")int bookingId) {
		// TODO Auto-generated method stub
		return travelBookingServiceImpl.getBooking(bookingId);
	}

	@RequestMapping(value="/getAll",method = RequestMethod.GET)
	public List<TravelBookingDetails> getAllBookings() {
		// TODO Auto-generated method stub
		return travelBookingServiceImpl.getAllBookings();
	}
}
