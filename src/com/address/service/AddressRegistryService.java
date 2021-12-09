package com.address.service;

import java.util.HashSet;
import java.util.Scanner;

import com.address.entity.AddressBook;
import com.address.entity.AddressBookRegistry;
import com.address.entity.ContactPerson;

public class AddressRegistryService {

	Scanner scan = new Scanner(System.in);

	public void addAddressBook() {
		System.out.print(" Please enter the name of the new address book: ");
		String name = scan.next();

		HashSet<AddressBook> temp = AddressBookRegistry.getAddressBookList();

		if (!temp.add(new AddressBook(name)))
			System.out.println(" An address book of this name already exists! ");

		AddressBookRegistry.setAddressBookList(temp);

	}
	
	public void searchPersonAll() {
		System.out.print(" Do you want to search by city or state: ");
		String ch = scan.next();
		
		switch(ch) {
		case "c":
		case "city":
			System.out.print(" Please enter the name of the city: ");
			String city = scan.next();
			for (AddressBook adbook : AddressBookRegistry.getAddressBookList()) {
				for (ContactPerson contact : adbook.getContacts()) {
					if(contact.getCity().equals(city)) {
						System.out.println(" hi there");
						System.out.println(" **** " + adbook.getName() + " ****");
						System.out.println(contact);
					}
				}
			}
			break;
		case "s":
		case "state":
			System.out.print(" Please enter the name of the state: ");
			String state = scan.next();
			for (AddressBook adbook : AddressBookRegistry.getAddressBookList()) {
				for (ContactPerson contact : adbook.getContacts()) {
					if(contact.getState().equals(state)) {
						System.out.println(" **** " + adbook.getName() + " ****");
						System.out.println(contact);
					}
				}
			}
			break;
			
		}
	}

}
