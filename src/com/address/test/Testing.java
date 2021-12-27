package com.address.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.address.entity.ContactPerson;
import com.address.jdbc.Config;
import com.address.jdbc.Statements;
import com.address.jdbc.entites.AddressBookDB;

public class Testing {

	@Test
	public void testConnectionHappy() {
		Connection connection = Config.connection;
		boolean comparison = true;
		Statements queries = new Statements();
		queries.readAddressBook();
		

		ArrayList<ContactPerson> arrayForComparison = new ArrayList<>();
		arrayForComparison.add(
				new ContactPerson("David", "Alapat", "India", "Thrissur", "Kerala", 123, 1234567890, "hi@gmail.com"));
		arrayForComparison
				.add(new ContactPerson("James", "Rollins", "US", "Brooklyn", "NY", 456, 1987456129, "hey@gmail.com"));
		arrayForComparison.add(new ContactPerson("Bill", "Gates", "US", "SF", "Cali", 159, 567892139, "win@gmail.com"));

		for (int i = 0; i < arrayForComparison.size(); i++) {
			if (!arrayForComparison.get(i).equalsCustom(AddressBookDB.getAddressBookDB().get(i))) {
				comparison = false;
				break;
			}
		}
		
		assertTrue(comparison);
	}
}
