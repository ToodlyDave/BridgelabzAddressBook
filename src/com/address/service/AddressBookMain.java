package com.address.service;

import java.util.Scanner;

import com.address.entity.ContactPerson;
import com.address.utilities.FileHandler;
import com.address.utilities.FileHandlerOptions;

public class AddressBookMain {

	public static ContactPerson readContactInfo() {

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

		return new ContactPerson(firstName, lastName, address, city, state, zip, phoneNumber, email);

	}

	public static void main(String[] args) {

		System.out.println(" Welcome to Address Book Program");

		Scanner scan = new Scanner(System.in);
		String ch;

		AddressBookService obj = new AddressBookService();
		AddressRegistryService adObj = new AddressRegistryService();

		while (true) {
			System.out.println(" 1. Add Contact\n 2. Add Multiple Contacts\n 3. Print Contacts\n 4. Edit Contact\n"
					+ " 5. Delete Contact\n 6. Add Address Book\n 7. Search by City/State\n "
					+ "8. View by City/State\n 9. Count by City/State\n"
					+ " 10. Sort Contacts by name\n 11. File Operations \n" + " 12. Exit ");
			System.out.print(" Please enter your choice: ");

			ch = scan.next();

			switch (ch) {
			case "1":
				obj.addContact(readContactInfo());
				break;
			case "2":
				System.out.println(" Please enter how many contacts you want to add: ");
				int n = scan.nextInt();

				for (int i = 0; i < n; i++) {
					obj.addContact(readContactInfo());
				}
				break;
			case "3":
				obj.printContacts();
				break;
			case "4":
				obj.editContact();
				break;
			case "5":
				obj.deleteContact();
				break;
			case "6":
				adObj.addAddressBook();
				break;
			case "7":
				System.out.print(" Please enter the name of the person: ");
				String name = scan.next();
				System.out.print(" Do you want to search by city or state: ");
				String choice = scan.next();
				adObj.searchPersonAll(name, choice);
				break;
			case "8":
				System.out.print(" Do you want to search by city or state: ");
				String choice1 = scan.next();
				adObj.viewPersonAll(choice1);
				break;
			case "9":
				System.out.print(" Do you want to count by city or state: ");
				String choice2 = scan.next();
				adObj.countPersons(choice2);
				break;
			case "10":
				System.out.print(" Please enter how you want to sort(name/city/state/zip): ");
				String choice3 = scan.next();
				obj.printSortedContacts(choice3);
				break;
			case "11":
				System.out.print(" Do you want to read or write?(r/w) : ");
				String readOrWrite = scan.next();

				System.out.println(" 1. TXT file\n 2. CSV file\n 3. JSON file");
				System.out.print(" Please select which file format you would like to handle: ");
				int fileType = scan.nextInt();

				FileHandlerOptions operation, type;
				if (readOrWrite.equalsIgnoreCase("r"))
					operation = FileHandlerOptions.READ;
				else if (readOrWrite.equalsIgnoreCase("w"))
					operation = FileHandlerOptions.WRITE;
				else {
					System.out.println(" Please enter a valid choice");
					break;
				}

				if (fileType == 1)
					type = FileHandlerOptions.TXT;
				else if (fileType == 2)
					type = FileHandlerOptions.CSV;
				else if (fileType == 3)
					type = FileHandlerOptions.JSON;
				else {
					System.out.println(" Please enter a valid choice");
					break;
				}

				FileHandler.filehandler(operation, type);
				break;
			case "12":
				System.out.println(" Good bye!! ");
				scan.close();
				return;
			default:
				System.out.println(" Please enter a valid input");
			}
		}
	}
}
