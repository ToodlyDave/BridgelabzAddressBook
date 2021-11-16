package com.address.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.address.entity.AddressBook;
import com.address.entity.AddressBookRegistry;
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
	
	AddressBook adBook;
	Scanner scan = new Scanner(System.in);
	
	public AddressBookService() {
		super();
		scan.useDelimiter("\r?\n");
	}

	private void readContactInfo() {
		
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
		
		adBook = findAddressBook();
		
		if (adBook == null) {
			return;
		}
		
		ArrayList<ContactPerson> contacts = adBook.getContacts();		
		
		readContactInfo();
		ContactPerson newContact = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
		contacts.add(newContact);
		adBook.setContacts(contacts);
		 
		System.out.println(newContact);
	}
	
	public void printContacts() {
		
		ArrayList<AddressBook> temp = AddressBookRegistry.getAddressBookList();
		
		for (AddressBook addressBook : temp) {
			System.out.println(" ******** " + addressBook.getName() + " ********");
			for (ContactPerson contactPerson : addressBook.getContacts()) {
				System.out.println(contactPerson);
			}
		}
	}
	
	private ContactPerson findContact(AddressBook adBook) {
		
		System.out.print(" Please enter the name of the contact: ");
		String name = scan.next();
		
		ArrayList<ContactPerson> contacts = adBook.getContacts();
		int count = 0;
		ContactPerson temp = null;
		
		for (ContactPerson contactPerson : contacts) {
			if ( contactPerson.getFirstName().equals(name) ) {
				count++;
				temp = contactPerson;
			}
		}
		
		if (count < 2) {
			return temp;
		}
		
		System.out.print(" There are multiple contacts with that name.\n Please enter their email id to confirm: ");
		String checkEmail = scan.next();
		for (ContactPerson contactPerson : contacts) {
			if ( contactPerson.getFirstName().equals(name) && contactPerson.getEmail().equals(checkEmail)) {
				return contactPerson;
			}
		}
		
		return null;
	}
	
	private AddressBook findAddressBook() {
		
		
		ArrayList<AddressBook> temp = AddressBookRegistry.getAddressBookList();
		
		if (temp.size() == 0) {
			System.out.println(" Please create an address book first!");
			return null;
		}
		
		System.out.print(" Please enter the name of the address book: ");
		String adBookName = scan.next();
		
		for (AddressBook addressBook : temp) {
			if (addressBook.getName().equals(adBookName)) {
				return addressBook;
			}
		}
		
		System.out.println(" Address book does not exist!");
		return null;
	}
	
	public void editContact() {
		
		adBook = findAddressBook();
		
		if (adBook == null) {
			return;
		}
		
		ContactPerson obj = findContact(adBook);
		if(obj == null) {
			System.out.println(" Couldn't find contact");
			return;
		}
		
		System.out.println(" Please enter which detail you want to edit: ");
		System.out.print(" 1. Address\n 2. City\n 3. State\n 4. Zip\n 5. Phone number\n Choice: ");
		int ch = scan.nextInt();
		
		switch(ch) {
		case 1: 
			System.out.print(" Please enter the new address: ");
			String newAddress = scan.next();
			obj.setAddress(newAddress);
			break;
		case 2: 
			System.out.print(" Please enter the new city: ");
			String newCity = scan.next();
			obj.setCity(newCity);
			break;
		case 3: 
			System.out.print(" Please enter the name of the new state: ");
			String newState = scan.next();
			obj.setState(newState);
			break;
		case 4: 
			System.out.print(" Please enter the new zip code: ");
			int newZip = scan.nextInt();
			obj.setZip(newZip);
			break;
		case 5: 
			System.out.println(" Please enter the new phone number: ");
			int newPhone = scan.nextInt();
			obj.setPhoneNumber(newPhone);
			break;
		default:
			System.out.println(" Please enter a valid choice!");
			
		}
		System.out.println(" the new contact is : ");
		System.out.println(obj);
	}
	
	public void deleteContact() {
		
		adBook = findAddressBook();
		
		if (adBook == null) {
			return;
		}
		
		ContactPerson obj = findContact(adBook);
		if(obj == null) {
			System.out.println(" Couldn't find contact");
			return;
		}
		
		ArrayList<ContactPerson> contacts = adBook.getContacts();
		contacts.remove(obj);
	}

	public void addMultipleContacts() {
		System.out.println(" Please enter how many contacts you want to add: ");
		int n = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			addContact();
		}
	}
	
}
