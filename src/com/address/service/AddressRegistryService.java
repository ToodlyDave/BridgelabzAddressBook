package com.address.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.address.entity.AddressBook;
import com.address.entity.AddressBookRegistry;

public class AddressRegistryService {
	
	Scanner scan = new Scanner(System.in);

	public void addAddressBook() {
		System.out.print(" Please enter the name of the new address book: ");
		String name = scan.next();
		
		if (!checkUnique(name)) {
			System.out.println(" An address book of this name already exists! ");
			return;
		}
		
		ArrayList<AddressBook> temp = AddressBookRegistry.getAddressBookList();
		temp.add(new AddressBook(name));
		AddressBookRegistry.setAddressBookList(temp);
		
	}
	
	public boolean checkUnique(String name) {
		ArrayList<AddressBook> temp = AddressBookRegistry.getAddressBookList();
		
		if (temp == null) {
			return true;
		}
		for (AddressBook addressBook : temp) {
			if(addressBook.getName().equals(name)) {
				return false;
			}
		}
		
		return true;
	}
}
