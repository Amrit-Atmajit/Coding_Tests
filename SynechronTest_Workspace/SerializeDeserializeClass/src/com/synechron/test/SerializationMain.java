package com.synechron.test;

import java.io.IOException;

import com.synechron.test.model.Employee;
import com.synechron.test.utils.SerializationUtils;

public class SerializationMain {

	public static void main(String[] args) {
		String fileName="Employee.txt";
		Employee emplSer = new Employee();
		emplSer.setId(101);
		emplSer.setName("Amrit Atmajit");
		emplSer.setDepartment("Product Development");
		emplSer.setSalary(10000.00);
		emplSer.setPassword("test123");

		//serialize to file
		try {
			SerializationUtils.serialize(emplSer, fileName);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		Employee emplDes = null;
		try {
			emplDes = (Employee) SerializationUtils.deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("Employee object before serialization :: "+ emplSer);
		System.out.println("Employee object after deserialization :: " + emplDes);
	}

}
