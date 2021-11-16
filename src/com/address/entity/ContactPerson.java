package com.address.entity;

public class ContactPerson {
	
	private String firstName;	
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;	
	private int phoneNumber;
	private String email;
	
	public String getFirstName() {
		return firstName;
	}
	
	
	
	

	public String getEmail() {
		return email;
	}





	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public int getZip() {
		return zip;
	}



	public void setZip(int zip) {
		this.zip = zip;
	}



	public int getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public ContactPerson(String firstName, String lastName, String address, String city, String state, int zip,
			int phoneNumber, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	@Override
	public String toString() {
		System.out.println("\n ==== " + firstName + " " + lastName + " ====");
		System.out.println(" Address: " + this.address);
		System.out.println(" City: " + this.city);
		System.out.println(" State: " + this.state);
		System.out.println(" Zip: " + this.zip);
		System.out.println(" Phone number: " + this.phoneNumber);
		System.out.println(" Email: " + this.email);
		return "";
	}
	
	public void setContacts(String firstName, String lastName, String address, String city, String state, int zip,
			int phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
}
