package com.mindgate.pojo;

import org.springframework.stereotype.Component;

@Component
public class SlabDetails {
	private int slabId;
	private String designation;
	private String travelByAir;
	private int maxNoDays;
	private String eligibleForExchange;
	private String domesticInternational;

	public SlabDetails() {
	}

	public SlabDetails(int slabId, String designation, String travelByAir, int maxNoDays, String eligibleForExchange,
			String domesticInternational) {
		super();
		this.slabId = slabId;
		this.designation = designation;
		this.travelByAir = travelByAir;
		this.maxNoDays = maxNoDays;
		this.eligibleForExchange = eligibleForExchange;
		this.domesticInternational = domesticInternational;
	}

	public int getSlabId() {
		return slabId;
	}

	public void setSlabId(int slabId) {
		this.slabId = slabId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getTravelByAir() {
		return travelByAir;
	}

	public void setTravelByAir(String travelByAir) {
		this.travelByAir = travelByAir;
	}

	public int getMaxNoDays() {
		return maxNoDays;
	}

	public void setMaxNoDays(int maxNoDays) {
		this.maxNoDays = maxNoDays;
	}

	public String getEligibleForExchange() {
		return eligibleForExchange;
	}

	public void setEligibleForExchange(String eligibleForExchange) {
		this.eligibleForExchange = eligibleForExchange;
	}

	public String getDomesticInternational() {
		return domesticInternational;
	}

	public void setDomesticInternational(String domesticInternational) {
		this.domesticInternational = domesticInternational;
	}

	@Override
	public String toString() {
		return "SlabDetails [slabId=" + slabId + ", designation=" + designation + ", travelByAir=" + travelByAir
				+ ", maxNoDays=" + maxNoDays + ", eligibleForExchange=" + eligibleForExchange
				+ ", domesticInternational=" + domesticInternational + "]";
	}

}
