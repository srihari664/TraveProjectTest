package com.mindgate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mindgate.dao.SlabDAOImpl;
import com.mindgate.pojo.SlabDetails;

@Service

public class SlabServiceImpl implements SlabService {
	@Autowired
	SlabDAOImpl slabDAO;
	@Override
	public boolean addSlab(SlabDetails slabDetails) {
		// TODO Auto-generated method stub
		return slabDAO.addSlab(slabDetails);
	}

	@Override
	public boolean updateSlab(int slabId, SlabDetails slabDetails) {
		// TODO Auto-generated method stub
		return slabDAO.updateSlab(slabId,slabDetails);
	}

	@Override
	public boolean deleteSlab(int slabId) {
		// TODO Auto-generated method stub
		return slabDAO.deleteSlab(slabId);
	}

	@Override
	public SlabDetails getSlab(int slabId) {
		// TODO Auto-generated method stub
		return slabDAO.getSlab(slabId);
	}

	@Override
	public List<SlabDetails> getAllSlab() {
		// TODO Auto-generated method stub
		return slabDAO.getAllSlab();
	}

	
}