package com.test.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PersonRecursiveCall {
	private int age;
	private List<PersonRecursiveCall> children = new LinkedList<>();

	@Override
	public String toString() {
		return "Person [value=" + age + ", children=" + children + "]";
	}

	public PersonRecursiveCall(int value, List<PersonRecursiveCall> children) {
		super();
		this.age = value;
		this.children.addAll(children);
	}

	public PersonRecursiveCall(int value, PersonRecursiveCall... children) {
		this(value, Arrays.asList(children));
	}

	public int getValue() {
		return age;
	}

	public List<PersonRecursiveCall> getChildren() {
		return Collections.unmodifiableList(children);
	}

	public Stream<PersonRecursiveCall> flattened() {
		return Stream.concat(Stream.of(this), children.stream().flatMap(PersonRecursiveCall::flattened));
	}

	public static void main(String args[]) {
		List<PersonRecursiveCall> children1 = new ArrayList<>();
		List<PersonRecursiveCall> children2 = new ArrayList<>();
		PersonRecursiveCall child2Tree1 = new PersonRecursiveCall(12, new ArrayList<>());
		children2.add(child2Tree1);
		List<PersonRecursiveCall> children3 = new ArrayList<>();
		PersonRecursiveCall child3Tree1 = new PersonRecursiveCall(13, new ArrayList<>());
		children3.add(child3Tree1);
		PersonRecursiveCall child1Tree1 = new PersonRecursiveCall(10, children2);
		PersonRecursiveCall child1Tree2 = new PersonRecursiveCall(9, children3);
		children1.add(child1Tree1);
		children1.add(child1Tree2);
		PersonRecursiveCall person = new PersonRecursiveCall(100, children1);
		person.flattened().forEach(System.out::println);
		int val2 = person.flattened().map(PersonRecursiveCall::getValue).sorted().findFirst().get();
		System.out.println(val2);
		// Get all values in the person:
		List<Integer> val1 = person.flattened().map(PersonRecursiveCall::getValue).collect(Collectors.toList());
		System.out.println(val1);
	}
}