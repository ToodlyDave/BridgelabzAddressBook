package com.address.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.address.entity.AddressBook;
import com.address.entity.AddressBookRegistry;
import com.address.entity.ContactPerson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

public class CSV_IO implements FileIOInterface{

	@Override
	public void writeAddressBookFile() {
		FileWriter fw;
		try {
			fw = new FileWriter("src/AddressBookRegistry.csv");
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

	@Override
	public ArrayList<AddressBook> readAddressBookFile() {
		
		ArrayList<AddressBook> addressBookDB = new ArrayList<>();
	
		try {
			FileReader fr = new FileReader("src/AddressBookRegistry.csv");
			CSVReader creader = new CSVReader(fr);
			String[] contact;
			while ((contact = creader.readNext()) != null) {
				ContactPerson newContact = new ContactPerson(contact[1], contact[2], contact[3], contact[4], contact[5],
						Integer.valueOf(contact[6]), Integer.valueOf(contact[7]), contact[8]);

				if(addressBookDB.size() > 0 && addressBookDB.get(addressBookDB.size() - 1).getName().equals(contact[0])) {
					addressBookDB.get(addressBookDB.size() - 1).getContacts().add(newContact);
				}
				
				else {
					AddressBook newAdBook = new AddressBook(contact[0]);
					newAdBook.getContacts().add(newContact);
					addressBookDB.add(newAdBook);
				}
//				System.out.println(newContact);
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
		
		System.out.println(addressBookDB);
		return addressBookDB;
	}

}
