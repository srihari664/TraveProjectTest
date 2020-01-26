package com.mindgate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mindgate.pojo.EmployeeDetails;
import com.mindgate.pojo.SlabDetails;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;
	private int count;
	
	@Autowired
	private SlabDAOImpl slabDAO;
	
	@Override
	public boolean addEmployee(EmployeeDetails EmployeeDetails) 
	{
		sql = "insert into Employee_master values(Employee_id.nextVal,?,?,?,?,?,?)";//database column names
		Object[] args = new Object[] {EmployeeDetails.getName(),EmployeeDetails.getEmail(),EmployeeDetails.getPassword(),EmployeeDetails.getSlabDetails().getSlabId(),EmployeeDetails.getManagerId(),EmployeeDetails.getDesignation()};
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateEmployee(int EmployeeId, EmployeeDetails EmployeeDetails) 
	{
		sql="update Employee_master set name=?,email=?,password=?,slab_Id=?,manager_Id=?,designation=? where Employee_id = ? ";//database column names
		Object[] args = new Object[] {EmployeeDetails.getName(),EmployeeDetails.getEmail(),EmployeeDetails.getPassword(),EmployeeDetails.getSlabDetails().getSlabId(),EmployeeDetails.getManagerId(),EmployeeDetails.getDesignation(),EmployeeId};
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteEmployee(int EmployeeId) 
	{
		 String sql="delete from Employee_master where Employee_id=?";//database column names
		 Object[] args = new Object[] {EmployeeId};
		 count = jdbcTemplate.update(sql,args);
			if (count > 0)
				return true;
			return false; 
	}

	@Override
	public EmployeeDetails getEmployee(int EmployeeId) 
	{
		sql = "select * from Employee_master where Employee_id=?";//database column names
		Object[] args = new Object[] { EmployeeId };
		EmployeeDetails EmployeeDetails = jdbcTemplate.queryForObject(sql, args, new EmployeeRowMapper());
		return EmployeeDetails;
	}

	@Override
	public List<EmployeeDetails> getAllEmployees()
	{
		sql = "select * from Employee_master";//database column names

		List<EmployeeDetails> EmployeeList = new ArrayList<EmployeeDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows)
		{
			EmployeeDetails employeeDetails = new EmployeeDetails();
			//database column names
			employeeDetails.setEmployeeId(Integer.parseInt(map.get("Employee_id").toString()));
			employeeDetails.setPassword(map.get("password").toString());
			employeeDetails.setName(map.get("name").toString());
			employeeDetails.setEmail(map.get("email").toString());
			employeeDetails.setManagerId(Integer.parseInt(map.get("manager_Id").toString()));
			employeeDetails.setDesignation(map.get("designation").toString());
			int slabId=Integer.parseInt(map.get("slab_Id").toString());
			SlabDetails slabDetails=slabDAO.getSlab(slabId);
		
			if (slabDetails == null)
				employeeDetails.setSlabDetails(new SlabDetails());
			else
				employeeDetails.setSlabDetails(slabDetails);
			EmployeeList.add(employeeDetails);
		}

		return EmployeeList;
	}
	public EmployeeDetails employeeLogin(EmployeeDetails details) {
		sql = "select * from Employee_master where Employee_id=?";//database column names
		Object[] args = new Object[] {details.getEmployeeId()};
		EmployeeDetails employeeDetails = jdbcTemplate.queryForObject(sql, args, new EmployeeRowMapper());
		return employeeDetails;
	}
	
	class EmployeeRowMapper implements RowMapper<EmployeeDetails> 
	{

		@Override
		public EmployeeDetails mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			EmployeeDetails employeeDetails = new EmployeeDetails();
			//database column names
			employeeDetails.setEmployeeId(rs.getInt("Employee_id"));
			employeeDetails.setPassword(rs.getString("password"));
			employeeDetails.setName(rs.getString("name"));
			employeeDetails.setEmail(rs.getString("email"));
			employeeDetails.setManagerId(rs.getInt("manager_Id"));
			employeeDetails.setDesignation(rs.getString("designation"));
			
			int slabId=rs.getInt("slab_Id");
			SlabDetails slabDetails=slabDAO.getSlab(slabId);
		
			if (slabDetails == null)
				employeeDetails.setSlabDetails(new SlabDetails());
			else
				employeeDetails.setSlabDetails(slabDetails);

			return employeeDetails;
			
		}

	}

}
