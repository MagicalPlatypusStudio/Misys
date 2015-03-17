package com.rizomm.vibestemptation.bo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Client implements Serializable, Comparable<Client> {

	private static final long serialVersionUID = -6186603359686273975L;

	private String firstName;
	private String lastName;
	private String nickName;
	private Adress adress;
	private int age;
	private int id;
	private ClientCategory category;

	public Client(String firstname, String lastname, ClientCategory category) {
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.setClientCategory(category);
	}
	
	public Client(String firstname, String lastname, ClientCategory category, int id) {
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.setClientCategory(category);
		this.setId(id);		
	}
	
	public Client(String firstname, String lastname, String nickName, Adress adress, int age, ClientCategory category) {
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.setNickName(nickName);
		this.setAdress(adress);
		this.setAge(age);
		this.setClientCategory(category);
	}
	
	public Client(String firstname, String lastname, String nickName, Adress adress, int age, ClientCategory category, int id) {
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.setNickName(nickName);
		this.setAdress(adress);
		this.setAge(age);
		this.setClientCategory(category);
		this.setId(id);		
	}
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName(){
		return nickName;
	}
	
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
	
	public Adress getAdress(){
		return this.adress;
	}
	
	public void setAdress(Adress adress){
		this.adress = new Adress(adress);
	}
	
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	public ClientCategory getClientCategory(){
		return category;
	}
	
	public void setClientCategory(ClientCategory category){
		this.category = category;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Client other = (Client) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int compareTo(Client arg0) {
		// TODO Auto-generated method stub
		return id - arg0.getId();
	}
}
