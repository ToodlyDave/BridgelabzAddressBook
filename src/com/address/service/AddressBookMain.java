package com.address.service;

public class AddressBookMain {

	public static void main(String[] args) {

		System.out.println(" Welcome to Address Book Program");
		
		AddressBookService obj = new AddressBookService();
		obj.addContact();
	}
}
