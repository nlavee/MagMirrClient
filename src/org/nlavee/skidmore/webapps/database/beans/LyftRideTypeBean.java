package org.nlavee.skidmore.webapps.database.beans;

public class LyftRideTypeBean {
	
	String displayName;
	String imgUrl; 
	int seats;
	int costPerMinute;
	int baseCharge;
	int minCost;
	int costPerMile;
	String currency;
	
	public LyftRideTypeBean()
	{
		
	}

	public LyftRideTypeBean(String displayName, String imgUrl, int seats,
			int costPerMinute, int baseCharge, int minCost, int costPerMile,
			String currency) {
		this.displayName = displayName;
		this.imgUrl = imgUrl;
		this.seats = seats;
		this.costPerMinute = costPerMinute;
		this.baseCharge = baseCharge;
		this.minCost = minCost;
		this.costPerMile = costPerMile;
		this.currency = currency;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getCostPerMinute() {
		return costPerMinute;
	}

	public void setCostPerMinute(int costPerMinute) {
		this.costPerMinute = costPerMinute;
	}

	public int getBaseCharge() {
		return baseCharge;
	}

	public void setBaseCharge(int baseCharge) {
		this.baseCharge = baseCharge;
	}

	public int getMinCost() {
		return minCost;
	}

	public void setMinCost(int minCost) {
		this.minCost = minCost;
	}

	public int getCostPerMile() {
		return costPerMile;
	}

	public void setCostPerMile(int costPerMile) {
		this.costPerMile = costPerMile;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "LyftRideType [displayName=" + displayName + ", imgUrl="
				+ imgUrl + ", seats=" + seats + ", costPerMinute="
				+ costPerMinute + ", baseCharge=" + baseCharge + ", minCost="
				+ minCost + ", costPerMile=" + costPerMile + ", currency="
				+ currency + "]";
	}

	
}
