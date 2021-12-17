package com.address.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

import com.address.entity.AddressBook;
import com.address.entity.AddressBookRegistry;
import com.address.entity.ContactPerson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

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

	public void viewPersonAll(String ch) {
		switch (ch) {
		case "c":
		case "city":
			System.out.print(" Please enter the name of the city: ");
			String city = scan.next();
			AddressBookRegistry.getCityPersonMap().entrySet().stream().filter(contact -> contact.getKey().equals(city))
					.forEach(contact -> System.out.println(contact.getValue()));
			break;
		case "s":
		case "state":
			System.out.print(" Please enter the name of the state: ");
			String state = scan.next();
			AddressBookRegistry.getStatePersonMap().entrySet().stream()
					.filter(contact -> contact.getKey().equals(state))
					.forEach(contact -> System.out.println(contact.getValue()));
			break;

		default:
			System.out.println(" Please enter a valid choice!");
		}
	}

	public void searchPersonAll(String name, String ch) {

		switch (ch) {
		case "c":
		case "city":
			System.out.print(" Please enter the name of the city: ");
			String city = scan.next();
			for (AddressBook adbook : AddressBookRegistry.getAddressBookList()) {
				adbook.getContacts().stream().filter(contact -> contact.getCity().equals(city))
						.filter(contact -> contact.getFirstName().equals(name))
						.forEach(contact -> System.out.println(contact));
			}
			break;
		case "s":
		case "state":
			System.out.print(" Please enter the name of the state: ");
			String state = scan.next();
			for (AddressBook adbook : AddressBookRegistry.getAddressBookList()) {
				adbook.getContacts().stream().filter(contact -> contact.getState().equals(state))
						.filter(contact -> contact.getFirstName().equals(name))
						.forEach(contact -> System.out.println(contact));
			}
			break;
		default:
			System.out.println(" Please enter a valid choice!");

		}
	}

	public void countPersons(String ch) {
		switch (ch) {
		case "c":
		case "city":
			System.out.println(" Please enter the name of the city: ");
			String city = scan.next();
			AddressBookRegistry.getCityPersonMap().entrySet().stream().filter(contact -> contact.getKey().equals(city))
					.forEach(contact -> System.out
							.println("Number of ppl in " + city + ": " + contact.getValue().size()));
			break;
		case "s":
		case "state":
			System.out.println(" Please enter the name of the state: ");
			String state = scan.next();
			AddressBookRegistry.getStatePersonMap().entrySet().stream()
					.filter(contact -> contact.getKey().equals(state)).forEach(contact -> System.out
							.println("Number of ppl in " + state + ": " + contact.getValue().size()));
			break;
		default:
			System.out.println(" Please enter a valid choice!");
		}
	}

	public void writeIntoFile() {
		HashSet<AddressBook> temp = AddressBookRegistry.getAddressBookList();

		try {
			FileWriter fw = new FileWriter("src/output.txt");
			fw.write(temp.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readFromFile() {

		Scanner scan;
		try {
			scan = new Scanner(new File("src/output.txt"));
			while (scan.hasNext()) {
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeCSV() {
		FileWriter fw;
		try {
			fw = new FileWriter("src/output.txt");
			CSVWriter cwriter = new CSVWriter(fw);

			for (AddressBook adbook : AddressBookRegistry.getAddressBookList()) {
				for (ContactPerson contact : adbook.getContacts()) {

					String[] contactInfo = contact.toCSV().split(",");
					String[] adBookName = { adbook.getName() };
					String[] csvContact = new String[contactInfo.length + 1];
					System.arraycopy(adBookName, 0, csvContact, 0, 1);
					System.arraycopy(contactInfo, 0, csvContact, 1, contactInfo.length);
					cwriter.writeNext(csvContact);
				}
			}
			cwriter.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readCSV() {
		try {
			FileReader fr = new FileReader("src/output.txt");
			CSVReader creader = new CSVReader(fr);
			String[] contact;
			while ((contact = creader.readNext()) != null) {
				ContactPerson newContact = new ContactPerson(contact[1], contact[2], contact[3], contact[4], contact[5],
						Integer.valueOf(contact[6]), Integer.valueOf(contact[7]), contact[8]);

				System.out.println(newContact);
			}

			creader.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeJson() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String output = gson.toJson(AddressBookRegistry.getAddressBookList());

		try {
			FileWriter fwriter = new FileWriter("src/output.json");
			fwriter.write(output);
			fwriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void readJson() {
		Gson gson = new Gson();
		try {
			FileReader freader = new FileReader("src/output.json");
//			HashSet<AddressBook> temp = new HashSet<>();
			Object temp = gson.fromJson(freader, Object.class);
			System.out.println(temp);
//			for (AddressBook addressBook : temp) {
//				System.out.println(" *** " + addressBook.getName() + " ***");
//				for (ContactPerson contact : addressBook.getContacts()) {
//					System.out.println(contact);
//				}
//			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
