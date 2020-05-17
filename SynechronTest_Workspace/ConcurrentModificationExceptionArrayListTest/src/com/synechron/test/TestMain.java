package com.synechron.test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import com.synechron.test.model.Person;

public class TestMain {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Amrit", 30, "India"));
		personList.add(new Person("Thomas", 40, "USA"));
		personList.add(new Person("Shahar", 35, "Israel"));
		personList.add(new Person("Chin Yong", 25, "China"));
		personList.add(new Person("David", 28, "USA"));
		personList.add(new Person("Raj", 38, "India"));
		personList.add(new Person("Shafeer", 45, "Israel"));
		
		System.out.println("Original PersoList :: " + personList);
		
		System.out.println("*** Concurrent Modification Exception test by removing the element during ieration of ArrayList ***");
		try {
			List<Person> cmExceptionList = testConcurrentModificationException(personList);
		} catch (ConcurrentModificationException ex) {
			System.err.println(
					"ConcurrentModificationException is trown due to removing the element during iteration of the list");
		}
		
		System.out.println("*** Avoid Concurrent Modification Exception test by removing the element during correct way of ieration of ArrayList ***");
		List<Person> updatedPersonList = testAvoidException(personList);
		System.out.println("Person list after removing the elements :: " + updatedPersonList);
	}

	// ConcurrentModificationExceptionTest - by removing the persons whose address
	// is Israel
	private static List<Person> testConcurrentModificationException(List<Person> personList) {
		for (Person person : personList) {
			if (person.getAddress().equalsIgnoreCase("Israel")) {
				personList.remove(person);
			}
		}
		return personList;
	}

	// Avoid ConcurrentModificationExceptionTest - by Right way of iterating elements using Iterator's remove() method
	private static List<Person> testAvoidException(List<Person> personList) {
		for (Iterator<Person> personItr = personList.iterator(); personItr.hasNext();) {
			Person person = personItr.next();
			if (person.getAddress().equalsIgnoreCase("Israel")) {
				personItr.remove();
			}
		}
		return personList;
	}
}
