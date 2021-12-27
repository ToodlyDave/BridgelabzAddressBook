package com.address.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.address.entity.AddressBook;
import com.address.entity.ContactPerson;
import com.address.jdbc.entites.AddressBookDB;

public class Statements {

	final String READ_QUERY = "SELECT ab.first_name, ab.last_name, a.address, a.city, a.state, a.zip, "
			+ "ab.phone_number, ab.email FROM address_book ab LEFT JOIN address a ON ab.first_name = a.first_name";

	public AddressBook readAddressBook() {

		Connection connection = Config.connection;

		try {
			Statement fetchStatement = connection.createStatement();
			ResultSet result = fetchStatement.executeQuery(READ_QUERY);

			while (result.next()) {
				AddressBookDB.getAddressBookDB()
						.add(new ContactPerson(result.getString(1), result.getString(2),
								result.getString(3), result.getString(4), result.getString(5), result.getInt(6),
								result.getInt(7), result.getString(8)));
			}
			
			System.out.println(" The stuff in the db: ");
			System.out.println(AddressBookDB.getAddressBookDB());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
