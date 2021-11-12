package com.address.entity;

import java.util.ArrayList;

public class AddressBook {

	public static ArrayList<ContactPerson> contacts = new ArrayList<ContactPerson>();

	public static ArrayList<ContactPerson> getContacts() {
		return contacts;
	}

	public static void setContacts(ArrayList<ContactPerson> contacts) {
		AddressBook.contacts = contacts;
	}
}

