package com.address.jdbc.entites;

import java.util.ArrayList;

import com.address.entity.ContactPerson;

public class AddressBookDB {

	static ArrayList<ContactPerson> addressBookDB = new ArrayList<>();
	
	public static ArrayList<ContactPerson> getAddressBookDB() {
		return addressBookDB;
	}
}
