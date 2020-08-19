package com.moviecatalogservice.model;

public class MovieCatalog {

	private String movName;
	private String movDescription;
	private int movRatings;
	public String getMovName() {
		return movName;
	}
	public void setMovName(String movName) {
		this.movName = movName;
	}
	public String getMovDescription() {
		return movDescription;
	}
	public void setMovDescription(String movDescription) {
		this.movDescription = movDescription;
	}
	public int getMovRatings() {
		return movRatings;
	}
	public void setMovRatings(int movRatings) {
		this.movRatings = movRatings;
	}
	public MovieCatalog(String movName, String movDescription, int movRatings) {
		super();
		this.movName = movName;
		this.movDescription = movDescription;
		this.movRatings = movRatings;
	}
	public MovieCatalog() {
		super();
	}
	
	
}
