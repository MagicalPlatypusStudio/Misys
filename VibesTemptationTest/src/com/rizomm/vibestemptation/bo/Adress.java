package com.rizomm.vibestemptation.bo;

public class Adress {
	private int clientID;
	private String firstName;
	private String lastName;
	private String streetNumber;
	private String streetName;
	private int postalCode;
	private String town;
	private String country;
	
	public Adress(){
	}
	
	public Adress(Adress adress){
		this.setClientID(adress.getClientID());
		this.setFirstName(adress.getFirstName());
		this.setLastName(adress.getLastName());
		this.setStreetNumber(adress.getStreetNumber());
		this.setStreetName(adress.getStreetName());
		this.setPostalCode(adress.getPostalCode());
		this.setTown(adress.getTown());
		this.setCountry(adress.getCountry());
	}
	
	public Adress(String firstName, String lastName, String streetNumber, String streetName, int postalCode, String town, String country){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setStreetNumber(streetNumber);
		this.setStreetName(streetName);
		this.setPostalCode(postalCode);
		this.setTown(town);
		this.setCountry(country);
	}
	
	public Adress(int clientID, String firstName, String lastName, String streetNumber, String streetName, int postalCode, String town, String country){
		this.setClientID(clientID);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setStreetNumber(streetNumber);
		this.setStreetName(streetName);
		this.setPostalCode(postalCode);
		this.setTown(town);
		this.setCountry(country);
	}
	
	public int getClientID(){
		return this.clientID;
	}
	
	public void setClientID(int clientID){
		this.clientID = clientID;
	}
	
	public String getFirstName(){
		return this.firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getStreetNumber(){
		return this.streetNumber;
	}
	
	public void setStreetNumber(String streetNumber){
		this.streetNumber = streetNumber;
	}
	
	public String getStreetName(){
		return this.streetName;
	}
	
	public void setStreetName(String streetName){
		this.streetName = streetName;
	}
	
	public int getPostalCode(){
		return this.postalCode;
	}
	
	public void setPostalCode(int postalCode){
		this.postalCode = postalCode;
	}
	
	public String getTown(){
		return this.town;
	}
	
	public void setTown(String town){
		this.town = town;
	}
	
	public String getCountry(){
		return this.country;
	}
	
	public void setCountry(String country){
		this.country = country;
	}
}

