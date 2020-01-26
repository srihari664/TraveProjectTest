package com.mindgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.mindgate.dao.AgentDAOImpl;
import com.mindgate.pojo.AgentDetails;
import com.mindgate.pojo.EmployeeDetails;

@Service
public class AgentServiceImpl implements AgentService
{
	
	@Autowired
	private AgentDAOImpl AgentDAOImpl;
	
	@Override
	public boolean addAgent(AgentDetails agentDetails) {
		return AgentDAOImpl.addAgent(agentDetails);
	}

	@Override
	public boolean updateAgent(int agentId, AgentDetails agentDetails) {
		return AgentDAOImpl.updateAgent(agentId, agentDetails);
	}

	@Override
	public boolean deleteAgent(int agentId) {
		return AgentDAOImpl.deleteAgent(agentId);
	}

	@Override
	public AgentDetails getAgent(int agentId) {
		return AgentDAOImpl.getAgent(agentId);
	}

	@Override
	public List<AgentDetails> getAllAgents() 
	{
		System.out.println("Service get All");
		return AgentDAOImpl.getAllAgents();
	}
	public AgentDetails agentLogin(@RequestBody AgentDetails details) {
		return AgentDAOImpl.agentLogin(details);
	}

}
