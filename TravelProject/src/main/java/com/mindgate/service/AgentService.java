package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.AgentDetails;

public interface AgentService 
{
	public boolean addAgent(AgentDetails agentDetails);

	public boolean updateAgent(int agentId, AgentDetails agentDetails);

	public boolean deleteAgent(int agentId);

	public AgentDetails getAgent(int agentId);

	public List<AgentDetails> getAllAgents();
}
