package com.address.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.address.entity.AddressBook;
import com.address.entity.ContactPerson;

public class AddressBookService {
	
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	int phoneNumber;
	String email;
	
	Scanner scan = new Scanner(System.in);
	
	public void getContact() {
		
		System.out.print(" Please enter the first name: ");
		firstName = scan.next();
		
		System.out.print(" Please enter the last name: ");
		lastName = scan.next();
		
		System.out.print(" Please enter the address: ");
		address = scan.next();
		
		System.out.print(" Please enter the city: ");
		city = scan.next();
		
		System.out.print(" Please enter the state: ");
		state = scan.next();
		
		System.out.print(" Please enter the zip: ");
		zip = scan.nextInt();
		
		System.out.print(" Please enter the phone number: ");
		phoneNumber = scan.nextInt();
		
		System.out.print(" Please enter the email: ");
		email = scan.next();
		
	}

	public void addContact() {
		
		ArrayList<ContactPerson> contacts = AddressBook.getContacts();		
		
		getContact();
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
	
	public ContactPerson findContact(String name) {
		
		ArrayList<ContactPerson> contacts = AddressBook.getContacts();
		
		for (ContactPerson contactPerson : contacts) {
			if ( contactPerson.getFirstName().equals(name) ) {
				return contactPerson;
			}
		}
		
		return null;
	}
	
	public void editContact() {
		
		System.out.println(" Please enter the name of the contact you want to edit: ");
		String name = scan.next();
		ContactPerson obj = findContact(name);
		
		if(obj == null) {
			System.out.println(" Couldn't find contact");
			return;
		}
		
		getContact();
		obj.setContacts(firstName, lastName, address, city, state, zip, phoneNumber, email);
		System.out.println(" the new contact is : ");
		System.out.println(obj);
	}
}
