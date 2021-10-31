package com.juanjo.ocp.streams_lambdas;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	
	static Consumer<Student> namePrinter = (student) -> System.out.print("Student: " + student.getName());
	static Consumer<Student> activitiesPrinter = (student) -> System.out.println(" | activites: " + student.getActivities());
	
	public static void main(String[] args) {
		
		List<Student> students = StudentDataBase.getAllStudents();
		students.forEach(namePrinter.andThen(activitiesPrinter)); //Consumer chaining
		
	}
}
