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

import com.mindgate.dao.TravelBookingDAOImpl.TravelBookingRowMapper;
import com.mindgate.pojo.AgentDetails;
import com.mindgate.pojo.EmployeeDetails;
import com.mindgate.pojo.SlabDetails;
import com.mindgate.pojo.TravelBookingDetails;
import com.mindgate.pojo.TravelRequestDetails;

@Repository
public class TravelRequestDAOImpl implements TravelRequestDAO 
{
	
	
	@Autowired
	EmployeeDAOImpl employeeDAO;
	
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	private String sql;
	private int count;
	
	
	@Override
	public boolean addTravelRequest(TravelRequestDetails requestDetails) {
		sql = "insert into travel_request_master values(travel_request_id.nextval,?,?,?,?,?,?,?,?,?)";
		
		Object[] args = new Object[] { requestDetails.getEmployeeDetails().getEmployeeId(),requestDetails.getStatus(), requestDetails.getTravelFrom(), requestDetails.getTravelTo(),requestDetails.getModeOfTravel(),requestDetails.getDomesticOrInternational(), requestDetails.getEligibleForExchange(),requestDetails.getTravelStartDate(),requestDetails.getTravelEndDate()};
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return false;
	
		
	}
	@Override
	public boolean updateTravelRequest(int requestId, TravelRequestDetails requestDetails) {
		sql="update travel_request_master set EMPLOYEE_ID=?,STATUS=?,REQUEST_SOURCE=?,REQUEST_DESTINATION=?,MODE_OF_TRAVEL=?,DOMESTIC_INTERNATIONAL=?,ELIGIBLE_FOR_EXCHANGE=?,TRAVEL_START_DATE=?,TRAVEL_END_DATE=? where TRAVEL_REQUEST_ID=?";
		Object[] args = new Object[] { requestDetails.getEmployeeDetails().getEmployeeId(),requestDetails.getStatus(), requestDetails.getTravelFrom(), requestDetails.getTravelTo(),requestDetails.getModeOfTravel(),requestDetails.getDomesticOrInternational(), requestDetails.getEligibleForExchange(),requestDetails.getTravelStartDate(),requestDetails.getTravelEndDate(),requestId};
		count=jdbcTemplate.update(sql,args);
		if(count>0)
			return true;
		return false;
	}
	@Override
	public boolean deleteTravelRequest(int requestId) {
		
		sql="delete from travel_request_master where travel_request_id=?";
		Object args[]=new Object[]{requestId};
		count=jdbcTemplate.update(sql,args);
		if(count>0)
			return true;
		return false;
	}
	@Override
	public TravelRequestDetails getTravelRequest(int requestId) {
		
		sql="select * from travel_request_master where travel_request_id=?";
		Object[] args = new Object[] {requestId};
		TravelRequestDetails travelRequestDetails   = jdbcTemplate.queryForObject(sql, args, new TravelRequestRowMapper());
		return travelRequestDetails;
		
	}
	public boolean approveRequest(int requestId) {
		sql="update travel_request_master set status=? where travel_request_id=?"; 
		Object[] args = new Object[]{"approved",requestId}; 
		count=jdbcTemplate.update(sql,args);
		if(count>0)
			return true;
		return false;
	}
	public boolean rejectRequest(int requestId) {
		sql="update travel_request_master set status=? where travel_request_id=?"; 
		Object[] args = new Object[]{"rejected",requestId}; 
		count=jdbcTemplate.update(sql,args);
		if(count>0)
			return true;
		return false;
	}
	public List<TravelRequestDetails> getEmployeeTravelRequest(int employeeId) {
		sql = "select * from travel_request_master where employee_id=?";

		List<TravelRequestDetails> employeeList = new ArrayList<TravelRequestDetails>();
		Object[] args = new Object[] {employeeId};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,args);

		for (Map<String, Object> map : rows) {
			TravelRequestDetails requestDetails = new TravelRequestDetails();
			requestDetails.setRequestId(Integer.parseInt(map.get("TRAVEL_REQUEST_ID").toString()));
			
			employeeId=Integer.parseInt(map.get("EMPLOYEE_ID").toString());
			EmployeeDetails employeeDetails=employeeDAO.getEmployee(employeeId);
			
			if (employeeDetails == null)
				requestDetails.setEmployeeDetails(new EmployeeDetails());
			else
				requestDetails.setEmployeeDetails(employeeDetails);
				requestDetails.setStatus(map.get("STATUS").toString());
				requestDetails.setTravelFrom(map.get("REQUEST_SOURCE").toString());
				requestDetails.setTravelTo(map.get("REQUEST_DESTINATION").toString());
				requestDetails.setModeOfTravel(map.get("MODE_OF_TRAVEL").toString());
				requestDetails.setDomesticOrInternational(map.get("DOMESTIC_INTERNATIONAL").toString());
				requestDetails.setEligibleForExchange(map.get("ELIGIBLE_FOR_EXCHANGE").toString());
				requestDetails.setTravelStartDate(Timestamp.valueOf(map.get("travel_start_date").toString()));
				requestDetails.setTravelEndDate(Timestamp.valueOf(map.get("travel_end_date").toString()));
			    employeeList.add(requestDetails);
		}

		return employeeList;
		
		
	} 
	
	public List<TravelRequestDetails> getManagerTravelRequest(int employeeId) {
	sql = "select * from travel_request_master where  employee_id in (select employee_id from employee_master where manager_id=? or employee_id=?)order by employee_id";

		List<TravelRequestDetails> employeeList = new ArrayList<TravelRequestDetails>();
		Object[] args = new Object[] {employeeId,employeeId};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,args);

		for (Map<String, Object> map : rows)
		{
			TravelRequestDetails requestDetails = new TravelRequestDetails();
			requestDetails.setRequestId(Integer.parseInt(map.get("TRAVEL_REQUEST_ID").toString()));
			
			employeeId=Integer.parseInt(map.get("EMPLOYEE_ID").toString());
			EmployeeDetails employeeDetails=employeeDAO.getEmployee(employeeId);
			
			if (employeeDetails == null)
				requestDetails.setEmployeeDetails(new EmployeeDetails());
			else
				requestDetails.setEmployeeDetails(employeeDetails);
				requestDetails.setStatus(map.get("STATUS").toString());
				requestDetails.setTravelFrom(map.get("REQUEST_SOURCE").toString());
				requestDetails.setTravelTo(map.get("REQUEST_DESTINATION").toString());
				requestDetails.setModeOfTravel(map.get("MODE_OF_TRAVEL").toString());
				requestDetails.setDomesticOrInternational(map.get("DOMESTIC_INTERNATIONAL").toString());
				requestDetails.setEligibleForExchange(map.get("ELIGIBLE_FOR_EXCHANGE").toString());
				requestDetails.setTravelStartDate(Timestamp.valueOf(map.get("travel_start_date").toString()));
				requestDetails.setTravelEndDate(Timestamp.valueOf(map.get("travel_end_date").toString()));
			    employeeList.add(requestDetails);
		}

		return employeeList;
		
		
	} 
	
	
	@Override
	public List<TravelRequestDetails> getAllTravelRequest() {
		sql = "select * from travel_request_master";

		List<TravelRequestDetails> employeeList = new ArrayList<TravelRequestDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			TravelRequestDetails requestDetails = new TravelRequestDetails();
			requestDetails.setRequestId(Integer.parseInt(map.get("TRAVEL_REQUEST_ID").toString()));
			
			int employeeId=Integer.parseInt(map.get("EMPLOYEE_ID").toString());
			EmployeeDetails employeeDetails=employeeDAO.getEmployee(employeeId);
			
			if (employeeDetails == null)
				requestDetails.setEmployeeDetails(new EmployeeDetails());
			else
				requestDetails.setEmployeeDetails(employeeDetails);
				requestDetails.setStatus(map.get("STATUS").toString());
				requestDetails.setTravelFrom(map.get("REQUEST_SOURCE").toString());
				requestDetails.setTravelTo(map.get("REQUEST_DESTINATION").toString());
				requestDetails.setModeOfTravel(map.get("MODE_OF_TRAVEL").toString());
				requestDetails.setDomesticOrInternational(map.get("DOMESTIC_INTERNATIONAL").toString());
				requestDetails.setEligibleForExchange(map.get("ELIGIBLE_FOR_EXCHANGE").toString());
				requestDetails.setTravelStartDate(Timestamp.valueOf(map.get("travel_start_date").toString()));
				requestDetails.setTravelEndDate(Timestamp.valueOf(map.get("travel_end_date").toString()));
			
			employeeList.add(requestDetails);
		}

		return employeeList;
		
		
	}
	public List<TravelRequestDetails> getDirectorTravelRequest(int employeeId) {
		sql = "select * from travel_request_master where  employee_id in (select employee_id from employee_master where manager_id=?) or status=? order by status";

		List<TravelRequestDetails> employeeList = new ArrayList<TravelRequestDetails>();
		Object[] args = new Object[] {employeeId,"approved"};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,args);

		for (Map<String, Object> map : rows) 
		{
			TravelRequestDetails requestDetails = new TravelRequestDetails();
			requestDetails.setRequestId(Integer.parseInt(map.get("TRAVEL_REQUEST_ID").toString()));
			int employee1Id=Integer.parseInt(map.get("EMPLOYEE_ID").toString());
			EmployeeDetails employeeDetails=employeeDAO.getEmployee(employee1Id);
			System.out.println(employeeDetails.getManagerId());
			if (employeeDetails == null)
				requestDetails.setEmployeeDetails(new EmployeeDetails());
			else
				requestDetails.setEmployeeDetails(employeeDetails);
				requestDetails.setStatus(map.get("STATUS").toString());
				requestDetails.setTravelFrom(map.get("REQUEST_SOURCE").toString());
				requestDetails.setTravelTo(map.get("REQUEST_DESTINATION").toString());
				requestDetails.setModeOfTravel(map.get("MODE_OF_TRAVEL").toString());
				requestDetails.setDomesticOrInternational(map.get("DOMESTIC_INTERNATIONAL").toString());
				requestDetails.setEligibleForExchange(map.get("ELIGIBLE_FOR_EXCHANGE").toString());
				requestDetails.setTravelStartDate(Timestamp.valueOf(map.get("travel_start_date").toString()));
				requestDetails.setTravelEndDate(Timestamp.valueOf(map.get("travel_end_date").toString()));
				if(requestDetails.getEmployeeDetails().getManagerId()==employeeId){
					System.out.println(requestDetails.getEmployeeDetails().getManagerId());
					employeeList.add(requestDetails);
				}
				else if(!checkSlab(requestDetails)){
					System.out.println(requestDetails.getEmployeeDetails().getManagerId());
			        employeeList.add(requestDetails);
				}
		}

		return employeeList;
		
	}
	public List<TravelRequestDetails> getAgentTravelRequest()
	{
		
		sql = "select * from travel_request_master where  status=?";

		List<TravelRequestDetails> employeeList = new ArrayList<TravelRequestDetails>();
		Object[] args = new Object[] {"approved"};
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql,args);

		for (Map<String, Object> map : rows) {
			TravelRequestDetails requestDetails = new TravelRequestDetails();
			requestDetails.setRequestId(Integer.parseInt(map.get("TRAVEL_REQUEST_ID").toString()));
			
			int employeeId=Integer.parseInt(map.get("EMPLOYEE_ID").toString());
			EmployeeDetails employeeDetails=employeeDAO.getEmployee(employeeId);
			
			if (employeeDetails == null)
				requestDetails.setEmployeeDetails(new EmployeeDetails());
			else
				requestDetails.setEmployeeDetails(employeeDetails);
				requestDetails.setStatus(map.get("STATUS").toString());
				requestDetails.setTravelFrom(map.get("REQUEST_SOURCE").toString());
				requestDetails.setTravelTo(map.get("REQUEST_DESTINATION").toString());
				requestDetails.setModeOfTravel(map.get("MODE_OF_TRAVEL").toString());
				requestDetails.setDomesticOrInternational(map.get("DOMESTIC_INTERNATIONAL").toString());
				requestDetails.setEligibleForExchange(map.get("ELIGIBLE_FOR_EXCHANGE").toString());
				requestDetails.setTravelStartDate(Timestamp.valueOf(map.get("travel_start_date").toString()));
				requestDetails.setTravelEndDate(Timestamp.valueOf(map.get("travel_end_date").toString()));
			    employeeList.add(requestDetails);
		}

		return employeeList;	
		
	} 
		
	
	public boolean checkSlab(TravelRequestDetails request){
		//System.out.println(request.getEmployeeDetails().getSlabDetails());
		SlabDetails slab=request.getEmployeeDetails().getSlabDetails();
		//System.out.println(slab);
		long a=request.getTravelEndDate().getTime()-request.getTravelStartDate().getTime();
		long b=a/(24*60*60*1000);
		//System.out.println(a/(24*60*60*1000));
		if(!(request.getDomesticOrInternational().equals(slab.getDomesticInternational())))
		{	//System.out.println("dom");
			
			return false;
		}
		else if(!(request.getModeOfTravel().equals("air")&& slab.getTravelByAir().equals("yes"))){
			//System.out.println("air");
			
			return false;
			
		}
		else if(b>slab.getMaxNoDays()){
			//System.out.println("days");
			
			return false;
		}
		else if(!(slab.getEligibleForExchange().equals(request.getEligibleForExchange()))){
			//System.out.println("exhange");
			
			return false;
		}
		return true;	
	}
	
	class TravelRequestRowMapper implements RowMapper<TravelRequestDetails>{

		@Override
		public TravelRequestDetails mapRow(ResultSet rs, int arg1) throws SQLException {
			TravelRequestDetails requestDetails = new TravelRequestDetails();
			requestDetails.setRequestId(rs.getInt("TRAVEL_REQUEST_ID"));

			int employeeId=rs.getInt("employee_ID");
			EmployeeDetails employeeDetails=employeeDAO.getEmployee(employeeId);
			if (employeeDetails == null)
				requestDetails.setEmployeeDetails(new EmployeeDetails());
			else
				requestDetails.setEmployeeDetails(employeeDetails);
			requestDetails.setStatus(rs.getString("status"));
			requestDetails.setTravelFrom(rs.getString("REQUEST_SOURCE"));
			requestDetails.setTravelTo(rs.getString("REQUEST_DESTINATION"));
			requestDetails.setModeOfTravel(rs.getString("MODE_OF_TRAVEL"));
			requestDetails.setDomesticOrInternational(rs.getString("DOMESTIC_INTERNATIONAL"));
			requestDetails.setEligibleForExchange(rs.getString("ELIGIBLE_FOR_EXCHANGE"));
			requestDetails.setTravelStartDate(rs.getTimestamp("travel_start_date"));
			requestDetails.setTravelEndDate(rs.getTimestamp("travel_end_date"));
			return requestDetails;
		}
		
	}
	public boolean book(int requestId)
	{
		sql="update travel_request_master set status=? where travel_request_id=?";
		Object[] args=new Object[]{"booked",requestId};
		count=jdbcTemplate.update(sql,args);
		if(count>0)
			return true;
		return false;
	}
	
	
}