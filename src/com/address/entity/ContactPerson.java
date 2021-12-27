package com.address.entity;

import java.util.Objects;

public class ContactPerson {

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private int phoneNumber;
	private String email;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactPerson other = (ContactPerson) obj;
		return Objects.equals(firstName, other.firstName);
	}

	public String getFirstName() {
		return firstName;
	}

	public boolean equalsCustom(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactPerson other = (ContactPerson) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && phoneNumber == other.phoneNumber
				&& Objects.equals(state, other.state) && zip == other.zip;
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
		return "\n ==== " + firstName + " " + lastName + " ====\n" + " Address: " + this.address + "\n" + " City: "
				+ this.city + "\n" + " State: " + this.state + "\n" + " Zip: " + this.zip + "\n" + " Phone number: "
				+ this.phoneNumber + "\n" + " Email: " + this.email + "\n";

	}

	public String toCSV() {
		return firstName + "," + lastName + "," + this.address + "," + this.city + "," + this.state + "," + this.zip
				+ "," + this.phoneNumber + "," + this.email;
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
