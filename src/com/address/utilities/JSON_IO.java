package com.address.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.address.entity.AddressBook;
import com.address.entity.AddressBookRegistry;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSON_IO implements FileIOInterface {

	@Override
	public void writeAddressBookFile() {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String output = gson.toJson(AddressBookRegistry.getAddressBookList());

		try {
			FileWriter fwriter = new FileWriter("src/AddressBookRegistry.json");
			fwriter.write(output);
			fwriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<AddressBook> readAddressBookFile() {

		ArrayList<AddressBook> addressBookRegistryDB = new ArrayList<>();
		Gson gson = new Gson();
		try {
			FileReader freader = new FileReader("src/AddressBookRegistry.json");

			Type addressBookType = new TypeToken<ArrayList<AddressBook>>() {
			}.getType();
			ArrayList<AddressBook> temp = gson.fromJson(freader, addressBookType);

			for (AddressBook addressBook : temp)
				addressBookRegistryDB.add(addressBook);

			System.out.println(addressBookRegistryDB);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return addressBookRegistryDB;

	}

}
