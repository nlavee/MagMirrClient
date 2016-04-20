package org.nlavee.skidmore.webapps.database.beans;

public class Coords {
	private Double lat;
	private Double lon;
	
	public Coords(Double lat, Double lon) {
		this.lat = lat;
		this.lon = lon;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "Coords [lat=" + lat + ", lon=" + lon + "]";
	}
	
	
}
