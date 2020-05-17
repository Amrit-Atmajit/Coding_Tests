package com.synechron.test.model;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * Added Serial Version UID
	 */
	private static final long serialVersionUID = -3759286626895728008L;
	
	// Properties declaration
	private String name;
	private int id;
	private String department;
	private transient double salary;
	private transient String password;
	
	// getter and setter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", department=" + department + ", salary=" + salary
				+ ", password=" + password + "]";
	}
	

	
}