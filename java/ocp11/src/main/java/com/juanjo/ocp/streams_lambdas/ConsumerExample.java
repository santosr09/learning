package com.juanjo.ocp.streams_lambdas;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	
	static Consumer<Student> namePrinter = (student) -> System.out.println("Student: " + student.getName());
	
	public static void main(String[] args) {
		
		List<Student> students = StudentDataBase.getAllStudents();
		
		students.forEach(namePrinter);
		
	}
}
