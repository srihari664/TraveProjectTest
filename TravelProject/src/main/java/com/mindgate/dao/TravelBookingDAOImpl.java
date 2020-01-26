package com.mindgate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.dao.TravelRequestDAOImpl;
import com.mindgate.pojo.AgentDetails;
import com.mindgate.pojo.TravelBookingDetails;
import com.mindgate.pojo.TravelRequestDetails;


@Repository
public class TravelBookingDAOImpl implements TravelBookingDAO{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	AgentDAOImpl agentDAO;
	@Autowired
	TravelRequestDAOImpl travelRequestDAO;
	String sql;
	int count;
	@Override
	public boolean addBooking(TravelBookingDetails travelBookingDetails) {
		sql="insert into travel_booking_master values(booking_id.nextval,?,?,?,?,?,?,?,?)";
		Object args[]=new Object[]{travelBookingDetails.getAgentDetails().getAgentId(),travelBookingDetails.getTravelStartDate(),travelBookingDetails.getTravelEndDate(),travelBookingDetails.getCurrentAddress(),travelBookingDetails.getTravelRequestDetails().getRequestId(),travelBookingDetails.getTravelMedium(),travelBookingDetails.getHotelAddress(),travelBookingDetails.getEligibleForExchange()};
		count=jdbcTemplate.update(sql,args);
		if(count>0)
			return true;
		return false;
	}

	@Override
	public boolean updateBooking(int bookingId, TravelBookingDetails travelBookingDetails) {
		sql="update travel_booking_master set agent_id=?,travel_start_date=?,travel_end_date=?,current_address=?,travel_request_id=?,travel_medium=?,hotel_address=?,eligible_for_exchange=? where booking_id=?";
		Object args[]=new Object[]{travelBookingDetails.getAgentDetails().getAgentId(),travelBookingDetails.getTravelStartDate(),travelBookingDetails.getTravelEndDate(),travelBookingDetails.getCurrentAddress(),travelBookingDetails.getTravelRequestDetails().getRequestId(),travelBookingDetails.getTravelMedium(),travelBookingDetails.getHotelAddress(),travelBookingDetails.getEligibleForExchange(),bookingId};
		count=jdbcTemplate.update(sql,args);
		if(count>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteBooking(int bookingId) {
		sql="delete from travel_booking_master where booking_id=?";
		Object args[]=new Object[]{bookingId};
		count=jdbcTemplate.update(sql,args);
		if(count>0)
			return true;
		return false;
	}

	@Override
	public TravelBookingDetails getBooking(int bookingId) {
		sql="select * from travel_booking_master where booking_id=?";
		Object[] args = new Object[] {bookingId};
		TravelBookingDetails travelBookingDetails = jdbcTemplate.queryForObject(sql, args, new TravelBookingRowMapper());
		return travelBookingDetails;
		
		
	}

	@Override
	public List<TravelBookingDetails> getAllBookings() {
		sql = "select * from travel_booking_master";

		List<TravelBookingDetails> bookingList = new ArrayList<TravelBookingDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			TravelBookingDetails tbd=new TravelBookingDetails();
			tbd.setBookingId(Integer.parseInt(map.get("booking_id").toString()));
			int agentId= Integer.parseInt(map.get("agent_id").toString());
			AgentDetails agentDetails=agentDAO.getAgent(agentId);
			if (agentDetails == null)
				tbd.setAgentDetails(new AgentDetails());
			else
				tbd.setAgentDetails(agentDetails);
			tbd.setTravelStartDate(Timestamp.valueOf(map.get("travel_start_date").toString()));
			tbd.setTravelEndDate(Timestamp.valueOf(map.get("travel_end_date").toString()));
			tbd.setCurrentAddress(map.get("current_address").toString());
			int requestId= Integer.parseInt(map.get("travel_request_id").toString());
			TravelRequestDetails travelRequestDetails=travelRequestDAO.getTravelRequest(requestId);
			if (travelRequestDetails == null)
				tbd.setTravelRequestDetails(new TravelRequestDetails());
			else
				tbd.setTravelRequestDetails(travelRequestDetails);
			
			tbd.setTravelMedium(map.get("travel_medium").toString());
			tbd.setHotelAddress(map.get("hotel_address").toString());
			tbd.setEligibleForExchange(map.get("eligible_for_exchange").toString());
			bookingList.add(tbd);
		}
		return bookingList;
	}
	
	class TravelBookingRowMapper implements RowMapper<TravelBookingDetails>{

		@Override
		public TravelBookingDetails mapRow(ResultSet rs, int arg1) throws SQLException {
			TravelBookingDetails tbd=new TravelBookingDetails();
			tbd.setBookingId(rs.getInt("booking_id"));
			int agentId= (rs.getInt("agent_id"));
			AgentDetails agentDetails=agentDAO.getAgent(agentId);
			if (agentDetails == null)
				tbd.setAgentDetails(new AgentDetails());
			else
				tbd.setAgentDetails(agentDetails);
			tbd.setTravelStartDate(rs.getTimestamp("travel_start_date"));
			tbd.setTravelEndDate(rs.getTimestamp("travel_start_date"));
			tbd.setCurrentAddress(rs.getString("current_address"));
			int requestId= (rs.getInt("travel_request_id"));
			TravelRequestDetails travelRequestDetails=travelRequestDAO.getTravelRequest(requestId);
			if (travelRequestDetails == null)
				tbd.setTravelRequestDetails(new TravelRequestDetails());
			else
				tbd.setTravelRequestDetails(travelRequestDetails);
			
			tbd.setTravelMedium(rs.getString("travel_medium"));
			tbd.setHotelAddress(rs.getString("hotel_address"));
			tbd.setEligibleForExchange(rs.getString("eligible_for_exchange"));
		
			return tbd;
		}
		
	}

}
