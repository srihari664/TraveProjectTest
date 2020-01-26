package com.mindgate.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.pojo.SlabDetails;
import com.mindgate.service.SlabServiceImpl;

@CrossOrigin(value="*")
@RestController
@RequestMapping("/slab")
public class SlabController 
{

	
	
	@Autowired
	private  SlabServiceImpl slabServiceImpl;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public boolean addSlab(@RequestBody SlabDetails slabDetails) 
	{
		System.out.println(slabDetails);
		return slabServiceImpl.addSlab(slabDetails);
	}
	
	@RequestMapping(value = "/{slabId}", method = RequestMethod.PUT)
	public boolean updateEmployee(@PathVariable("slabId") int slabId, @RequestBody SlabDetails slabDetails) {
		return slabServiceImpl.updateSlab(slabId, slabDetails);
	}
	
	@RequestMapping(value = "/{slabId}", method = RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable("slabId") int slabId,@RequestBody SlabDetails slabDetails) {
		return slabServiceImpl.deleteSlab(slabId);
	}
	
	@RequestMapping(value = "/{slabId}", method = RequestMethod.GET)
	public SlabDetails getAgent(@PathVariable("slabId") int slabId) {
		
		return slabServiceImpl.getSlab(slabId);

	}


	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<SlabDetails> getAllSlabDetails() {
			System.out.println("we r in getting all slab details");
			return slabServiceImpl.getAllSlab();
	
}
		
}
	
	