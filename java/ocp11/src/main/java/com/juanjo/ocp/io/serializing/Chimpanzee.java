package com.juanjo.ocp.io.serializing;

import java.io.Serializable;

public class Chimpanzee implements Serializable {
	
	private transient String name;
	private transient int age = 10;
	private static char type = 'C';
	{ this.age = 14; }
	
	public Chimpanzee() {
		this.name = "Unknown";
		this.age = 12;
		this.type = 'Q';
	}
	
	public Chimpanzee(String name, int age, char type) {
		this.name = name;
		this.age = age;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Chimpanzee{" +
							 "name='" + name + '\'' +
							 ", age=" + age +
							 ", type=" + type +
							 '}';
	}
}
