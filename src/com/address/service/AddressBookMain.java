package com.address.service;

import java.util.Scanner;

public class AddressBookMain {

	public static void main(String[] args) {
		
		System.out.println(" Welcome to Address Book Program");
		
		Scanner scan = new Scanner(System.in);
		int ch;
		
		AddressBookService obj = new AddressBookService();
		AddressRegistryService adObj = new AddressRegistryService();
		
		while (true) {
			 System.out.println(" 1. Add Contact\n 2. Add Multiple Contacts\n 3. Print Contacts\n 4. Edit Contact\n 5. Delete Contact\n 6. Add Address Book\n 7. Exit ");
			System.out.print(" Please enter your choice: ");
			
			ch = scan.nextInt();
			
			switch(ch) {
			case 1: 
				obj.addContact();
				break;
			case 2: 
				obj.addMultipleContacts();
				break;
			case 3:
				obj.printContacts();
				break;
			case 4:
				obj.editContact();
				break;
			case 5:
				obj.deleteContact();
				break;
			case 6:
				adObj.addAddressBook();
				break;
			case 7: 
				System.out.println(" Good bye!! ");
				scan.close();
				return;
			default:
				System.out.println(" Please enter a valid input");
			}
		}
	}
}
