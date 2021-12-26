package com.address.utilities;

public class FileHandler {

	public static void filehandler(FileHandlerOptions readOrWrite, FileHandlerOptions fileType) {

		if (fileType == FileHandlerOptions.TXT) {
			Txt_IO txtFileHandler = new Txt_IO();
			if (readOrWrite == FileHandlerOptions.READ)
				txtFileHandler.readAddressBookFile();
			else
				txtFileHandler.writeAddressBookFile();
		}

		else if (fileType == FileHandlerOptions.CSV) {
			CSV_IO csvFileHandler = new CSV_IO();
			if (readOrWrite == FileHandlerOptions.READ)
				csvFileHandler.readAddressBookFile();
			else
				csvFileHandler.writeAddressBookFile();
		}

		else if (fileType == FileHandlerOptions.JSON) {
			JSON_IO jsonFileHandler = new JSON_IO();
			if (readOrWrite == FileHandlerOptions.READ)
				jsonFileHandler.readAddressBookFile();
			else
				jsonFileHandler.writeAddressBookFile();
		}

	}
}
