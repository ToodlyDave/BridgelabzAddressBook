package com.address.service;

import java.util.Scanner;

public class AddressBookService {

	public void addContact() {
		
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
		
		ContactPerson obj = new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);
		System.out.println(obj);
	}
}
