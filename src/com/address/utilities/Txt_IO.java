package com.address.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.address.entity.AddressBook;
import com.address.entity.AddressBookRegistry;

public class Txt_IO implements FileIOInterface {

	@Override
	public void writeAddressBookFile() {
		HashSet<AddressBook> temp = AddressBookRegistry.getAddressBookList();

		try {
			FileWriter fw = new FileWriter("src/AddressBookRegistry.txt");
			fw.write(temp.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<AddressBook> readAddressBookFile() {

		ArrayList<AddressBook> addressBookDB = new ArrayList<>();
//		Scanner scan;

		Path path = Paths.get("src/AddressBookRegistry.txt");
		try {
			List<String> content = Files.readAllLines(path);
			
			for (String string : content) {
				System.out.println(string);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			scan = new Scanner(new File("src/AddressBookRegistry.txt"));
//			while (scan.hasNext()) {
//				System.out.println(scan.nextLine());
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		return addressBookDB;
	}

}
