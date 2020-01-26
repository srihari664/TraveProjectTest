package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.pojo.AgentDetails;
import com.mindgate.pojo.EmployeeDetails;
import com.mindgate.service.AgentServiceImpl;
@CrossOrigin(value="*")
@RestController
@RequestMapping("/agent")
public class AgentController {
	@Autowired
	private AgentServiceImpl agentServiceImpl;

	public AgentController() {
		System.out.println("in ctrl");
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public boolean addAgent(@RequestBody AgentDetails agentDetails) {
		System.out.println(agentDetails);
		return agentServiceImpl.addAgent(agentDetails);

	}

	@RequestMapping(value = "/{agent_id}", method = RequestMethod.PUT)
	public boolean updateAgent(@PathVariable("agent_id") int agentId, @RequestBody AgentDetails agentDetails) {
		System.out.println(agentDetails);
		return agentServiceImpl.updateAgent(agentId, agentDetails);

	}

	@RequestMapping(value = "/{agent_id}", method = RequestMethod.DELETE)
	public boolean deleteAgent(@PathVariable("agent_id") int agentId) {
		System.out.println("Delete agentDetails");

		return agentServiceImpl.deleteAgent(agentId);

	}

	@RequestMapping(value = "/{agent_id}", method = RequestMethod.GET)
	public AgentDetails getAgent(@PathVariable("agent_id") int agentId) {
		System.out.println("Hello get Agent");
		System.out.println("Bye");
		return agentServiceImpl.getAgent(agentId);

	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<AgentDetails> getAllAgents() {
		System.out.println("in getAllAgents");
		return agentServiceImpl.getAllAgents();
	}
	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public AgentDetails agentLogin(@RequestBody AgentDetails details) {
		return agentServiceImpl.agentLogin(details);
	}
}
