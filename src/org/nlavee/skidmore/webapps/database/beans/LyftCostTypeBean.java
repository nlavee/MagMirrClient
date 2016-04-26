package org.nlavee.skidmore.webapps.database.beans;

public class LyftCostTypeBean {

	String displayName;
	double estimatedDurationSeconds;
	double estimatedDurationMiles;
	double estimatedCostMin;
	double estimatedCostMax;
	String primeTimeSurcharge;
	String currency;
	
	public LyftCostTypeBean(String displayName,
			double estimatedDurationSeconds, double estimatedDurationMiles,
			double estimatedCostMin, double estimatedCostMax,
			String primeTimeSurcharge, String currency) {
		super();
		this.displayName = displayName;
		this.estimatedDurationSeconds = estimatedDurationSeconds;
		this.estimatedDurationMiles = estimatedDurationMiles;
		this.estimatedCostMin = estimatedCostMin;
		this.estimatedCostMax = estimatedCostMax;
		this.primeTimeSurcharge = primeTimeSurcharge;
		this.currency = currency;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public double getEstimatedDurationSeconds() {
		return estimatedDurationSeconds;
	}

	public void setEstimatedDurationSeconds(double estimatedDurationSeconds) {
		this.estimatedDurationSeconds = estimatedDurationSeconds;
	}

	public double getEstimatedDurationMiles() {
		return estimatedDurationMiles;
	}

	public void setEstimatedDurationMiles(double estimatedDurationMiles) {
		this.estimatedDurationMiles = estimatedDurationMiles;
	}

	public double getEstimatedCostMin() {
		return estimatedCostMin;
	}

	public void setEstimatedCostMin(double estimatedCostMin) {
		this.estimatedCostMin = estimatedCostMin;
	}

	public double getEstimatedCostMax() {
		return estimatedCostMax;
	}

	public void setEstimatedCostMax(double estimatedCostMax) {
		this.estimatedCostMax = estimatedCostMax;
	}

	public String getPrimeTimeSurcharge() {
		return primeTimeSurcharge;
	}

	public void setPrimeTimeSurcharge(String primeTimeSurcharge) {
		this.primeTimeSurcharge = primeTimeSurcharge;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "LyftCostTypeBean [displayName=" + displayName
				+ ", estimatedDurationSeconds=" + estimatedDurationSeconds
				+ ", estimatedDurationMiles=" + estimatedDurationMiles
				+ ", estimatedCostMin=" + estimatedCostMin
				+ ", estimatedCostMax=" + estimatedCostMax
				+ ", primeTimeSurcharge=" + primeTimeSurcharge + ", currency="
				+ currency + "]";
	}
	
	

}
