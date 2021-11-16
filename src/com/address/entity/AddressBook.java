package com.address.entity;

import java.util.ArrayList;

public class AddressBook {

	private ArrayList<ContactPerson> contacts = new ArrayList<ContactPerson>();
	private String name;

	public ArrayList<ContactPerson> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<ContactPerson> contacts) {
		this.contacts = contacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressBook(String name) {
		super();
		this.name = name;
	}
	
	
}

