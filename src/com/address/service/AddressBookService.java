package com.address.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.address.entity.AddressBook;
import com.address.entity.ContactPerson;

public class AddressBookService {

	public void addContact() {
		
		ArrayList<ContactPerson> contacts = AddressBook.getContacts();
		
		Scanner scan = new Scanner(System.in);
		System.out.print(" Please enter the first name: ");
		String firstName = scan.next();
		
		System.out.print(" Please enter the last name: ");
		String lastName = scan.next();
		
		System.out.print(" Please enter the address: ");
		String address = scan.next();
		
		System.out.print(" Please enter the city: ");
		String city = scan.next();
		
		System.out.print(" Please enter the state: ");
		String state = scan.next();
		
		System.out.print(" Please enter the zip: ");
		int zip = scan.nextInt();
		
		System.out.print(" Please enter the phone number: ");
		int phoneNumber = scan.nextInt();
		
		System.out.print(" Please enter the email: ");
		String email = scan.next();
		
		ContactPerson newContact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
		contacts.add(newContact);
		AddressBook.setContacts(contacts);
		 
		System.out.println(newContact);
	}
	
	public void printContacts() {
		
		ArrayList<ContactPerson> contacts = AddressBook.getContacts();
		
		for (ContactPerson contactPerson : contacts) {
			System.out.println(contactPerson);
		}
	}
}
