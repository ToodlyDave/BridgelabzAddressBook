package com.address.service;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {

		System.out.println(" Welcome to Address Book Program");
		
		Scanner scan = new Scanner(System.in);
		int ch;
		
		AddressBookService obj = new AddressBookService();
		
		while (true) {
			System.out.println(" 1. Add\n 2. Print Contacts\n 3. Edit Contact\n 4. Delete Contact\n 5. Exit ");
			System.out.println(" Please enter your choice: ");
			
			ch = scan.nextInt();
			
			switch(ch) {
			case 1: 
				obj.addContact();
				break;
			case 2: 
				obj.printContacts();
				break;
			case 3:
				obj.editContact();
				break;
			case 4:
				obj.deleteContact();
				break;
			case 5:
				System.out.println(" Good bye!! ");
				scan.close();
				return;
			}
		}
	}
}
