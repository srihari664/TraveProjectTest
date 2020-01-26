package com.mindgate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.pojo.SlabDetails;
@Repository
public class SlabDAOImpl implements SlabDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;
	private int count;
	@Override
	public boolean addSlab(SlabDetails details) {
		sql = "insert into slab_master values(slab_id.nextval,?,?,?,?,?)";
		Object[] args = new Object[] { details.getDesignation(),details.getTravelByAir(),details.getMaxNoDays(),details.getEligibleForExchange(),details.getDomesticInternational() };
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return false;
	}
	@Override
	public boolean updateSlab(int slabId, SlabDetails details) {
		sql = "update slab_master set slabId=?,designation=?,travelByAir=?,maxNoDays=?,eligibleForExchange=?,domesticInternational=? where slab_id = ? ";
		Object[] args = new Object[] { details.getSlabId(),details.getDesignation(),details.getTravelByAir(),details.getMaxNoDays(),details.getEligibleForExchange(),details.getDomesticInternational() };
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return false;
	}
	@Override
	public boolean deleteSlab(int slabId) {
		String sql = "delete from slab_master where slab_id=?";
		Object[] args = new Object[] {slabId };
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return false;
	}
	@Override
	public SlabDetails getSlab(int slabId) {

		sql = "select * from slab_master where slab_id=?";
		Object[] args = new Object[] { slabId };

		SlabDetails details = jdbcTemplate.queryForObject(sql, args, new SlabRowMapper());
		return details;
		//return null;
	}
	@Override
	public List<SlabDetails> getAllSlab() {
		System.out.println("DAO get all");
		sql = "select * from slab_master";

		List<SlabDetails> details=new ArrayList<SlabDetails>() ;
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> map : rows) {
			SlabDetails details2= new SlabDetails();
			details2.setSlabId(Integer.parseInt(map.get("slab_id").toString()));
			details2.setDesignation(map.get("designation").toString());
			details2.setTravelByAir(map.get("travel_by_air").toString());
			details2.setMaxNoDays(Integer.parseInt(map.get("max_no_days").toString()));
			details2.setEligibleForExchange(map.get("eligible_for_exchange").toString());
			details2.setDomesticInternational(map.get("domestic_international").toString());
			details.add(details2);
		}

		return details;
	}
	
	
	
	class SlabRowMapper implements RowMapper<SlabDetails> {

		

		@Override
		public SlabDetails mapRow(ResultSet rs, int arg1) throws SQLException {
			SlabDetails details=new SlabDetails();
			details.setSlabId(rs.getInt("slab_Id"));
			details.setDesignation(rs.getString("designation"));
			details.setTravelByAir(rs.getString("travel_By_Air"));
			details.setMaxNoDays(rs.getInt("max_No_Days"));
			details.setEligibleForExchange(rs.getString("eligible_For_Exchange"));
			details.setDomesticInternational(rs.getString("domestic_International"));
			
			

			return details;
		}

	
	

}
}