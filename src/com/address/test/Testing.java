package com.address.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.address.entity.ContactPerson;
import com.address.jdbc.Statements;

public class Testing {

	@Test
	public void testConnectionHappy() {
		boolean comparison = true;
		Statements queries = new Statements();
		ArrayList<ContactPerson> resultDB = queries.readAddressBook();
		

		ArrayList<ContactPerson> arrayForComparison = new ArrayList<>();
		arrayForComparison.add(
				new ContactPerson("David", "Alapat", "India", "Thrissur", "Kerala", 123, 1234567890, "hi@gmail.com"));
		arrayForComparison
				.add(new ContactPerson("James", "Rollins", "US", "Brooklyn", "NY", 456, 1987456129, "hey@gmail.com"));
		arrayForComparison.add(new ContactPerson("Bill", "Gates", "US", "SF", "Cali", 159, 567892139, "win@gmail.com"));

		
		for (int i = 0; i < arrayForComparison.size(); i++) {
			if (!arrayForComparison.get(i).equalsCustom(resultDB.get(i))) {
				comparison = false;
				break;
			}
		}
		
		assertTrue(comparison);
	}
}
