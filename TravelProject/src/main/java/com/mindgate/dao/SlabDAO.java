package com.mindgate.dao;

import java.util.List;

import com.mindgate.pojo.SlabDetails;

public interface SlabDAO {
	
	public boolean addSlab(SlabDetails slabDetails);
	public boolean updateSlab(int slabId,SlabDetails slabDetails);
	public boolean deleteSlab(int slabId);
	public SlabDetails getSlab(int slabId);
	public List<SlabDetails> getAllSlab();
}