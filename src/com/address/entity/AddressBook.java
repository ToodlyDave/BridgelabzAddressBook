package com.address.entity;

import java.util.ArrayList;

import com.address.service.ContactPerson;

public class AddressBook {

	public static ArrayList<ContactPerson> contacts;

	public static ArrayList<ContactPerson> getContacts() {
		return contacts;
	}

	public static void setContacts(ArrayList<ContactPerson> contacts) {
		AddressBook.contacts = contacts;
	}
}

