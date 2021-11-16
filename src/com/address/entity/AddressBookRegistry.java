package com.address.entity;

import java.util.ArrayList;

public class AddressBookRegistry {

	private static ArrayList<AddressBook> AddressBookList = new ArrayList<AddressBook>();

	public static  ArrayList<AddressBook> getAddressBookList() {
		return AddressBookList;
	}

	public static void setAddressBookList(ArrayList<AddressBook> addressBookList) {
		AddressBookList = addressBookList;
	}
	
	
}
