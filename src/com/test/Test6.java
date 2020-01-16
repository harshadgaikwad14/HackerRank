package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test6 {

	static List<Role> getMediaTypes(List<Employee> employee) {
		return employee.stream().flatMap(e -> e.getRoles().stream()).collect(Collectors.toList());
	}

	public static void main(String[] args) throws FileNotFoundException {

		Role r1= new Role(1, "ADMIN");
		Role r2= new Role(2, "USER");
		Role r3= new Role(3, "MANAGER");
		Role r4= new Role(4, "SUPER ADMIN");
		
		final List<Employee> employeelist = new ArrayList<>();
		employeelist.add(new Employee(1, "Test1", Arrays.asList(r1,r2)));
		employeelist.add(new Employee(2, "Test2", Arrays.asList(r3,r4)));
		employeelist.add(new Employee(3, "Test3", Arrays.asList(r4,r1)));
		final List<Role> r = getMediaTypes(employeelist );
		System.out.println(r);
	}

}

class Role {

	private long id;
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}

class Employee {

	private long id;
	private String name;
	private List<Role> roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Employee(long id, String name, List<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.roles = roles;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}