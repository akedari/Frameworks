package edu.kedari.dto;

import javax.persistence.Embeddable;

@Embeddable
public class College {
	
	private String Name;
	private String city;
	private String country;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
