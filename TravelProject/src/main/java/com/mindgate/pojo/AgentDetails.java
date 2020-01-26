package com.mindgate.pojo;

import org.springframework.stereotype.Component;

@Component
public class AgentDetails
{
	private int agentId;
	private String name;
	private String email;
	private String password;
	
	
	public AgentDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public AgentDetails(int agentId, String name, String email, String password) {
		super();
		this.agentId = agentId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AgentDetails [agentId=" + agentId + ", name=" + name + ", email=" + email + ", password=" + password
				+ "]";
	}

	
}