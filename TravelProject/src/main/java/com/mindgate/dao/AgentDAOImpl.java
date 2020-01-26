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

import com.mindgate.dao.EmployeeDAOImpl.EmployeeRowMapper;
import com.mindgate.pojo.AgentDetails;
import com.mindgate.pojo.EmployeeDetails;

@Repository
public class AgentDAOImpl implements AgentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;
	private int count;

	@Override
	public boolean addAgent(AgentDetails agentDetails) {
		sql = "insert into agent_master values(agent_id.nextval,?,?,?)";
		Object[] args = new Object[] { agentDetails.getPassword(), agentDetails.getName(),
				agentDetails.getEmail() };
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateAgent(int agentId, AgentDetails agentDetails) {
		sql = "update agent_master set password=?,name=?,email=? where agent_id = ? ";
		Object[] args = new Object[] { agentDetails.getPassword(), agentDetails.getName(), agentDetails.getEmail(),
				agentId };
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteAgent(int agentId) {
		String sql = "delete from agent_master where agent_id=?";
		Object[] args = new Object[] { agentId };
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public AgentDetails getAgent(int agentId) {
		sql = "select * from agent_master where agent_id=?";
		Object[] args = new Object[] { agentId };

		AgentDetails agentDetails = jdbcTemplate.queryForObject(sql, args, new AgentRowMapper());
		return agentDetails;
	}
	public AgentDetails agentLogin(AgentDetails details) {
		sql = "select * from Agent_master where agent_id=?";//database column names
		Object[] args = new Object[] {details.getAgentId()};

		AgentDetails agentDetails = jdbcTemplate.queryForObject(sql, args, new AgentRowMapper());
		return agentDetails;
	}

	@Override
	public List<AgentDetails> getAllAgents() {
		System.out.println("DAO get all");
		sql = "select * from agent_master";

		List<AgentDetails> agentList = new ArrayList<AgentDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			AgentDetails agentDetails = new AgentDetails();
			agentDetails.setAgentId(Integer.parseInt(map.get("agent_id").toString()));
			agentDetails.setPassword(map.get("password").toString());
			agentDetails.setName(map.get("name").toString());
			agentDetails.setEmail(map.get("email").toString());

			agentList.add(agentDetails);
		}

		return agentList;
	}

	class AgentRowMapper implements RowMapper<AgentDetails> {

		@Override
		public AgentDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			AgentDetails agentDetails = new AgentDetails();
			agentDetails.setAgentId(rs.getInt("agent_id"));
			agentDetails.setPassword(rs.getString("password"));
			agentDetails.setName(rs.getString("name"));
			agentDetails.setEmail(rs.getString("email"));

			

			return agentDetails;
		}

	}

}
