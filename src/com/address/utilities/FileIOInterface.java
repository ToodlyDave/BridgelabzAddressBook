package com.address.utilities;

import java.util.ArrayList;

import com.address.entity.AddressBook;

public interface FileIOInterface {

	public ArrayList<AddressBook> readAddressBookFile();

	public void writeAddressBookFile();
}
