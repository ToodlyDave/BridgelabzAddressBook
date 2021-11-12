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
