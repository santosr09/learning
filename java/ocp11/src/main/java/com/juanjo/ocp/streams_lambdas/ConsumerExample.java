package com.juanjo.ocp.streams_lambdas;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerExample {
	
	static Consumer<Student> namePrinter = (student) -> System.out.print("Student: " + student.getName());
	static Consumer<Student> activitiesPrinter = (student) -> System.out.println(" | activites: " + student.getActivities());
	
	static BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out.println(name + " : " + activities);
	
	static Predicate<Student> gradePredicate = (s) -> s.getGradeLevel() >= 3;
	static Predicate<Student> gpaPredicate = (s) -> s.getGpa() >= 3.9;
	
	static Consumer<Student> consumerEx = student -> {
		if(gradePredicate.and(gpaPredicate).test(student)){
			biConsumer.accept(student.getName(), student.getActivities());
		}
	};
	
	static private void consumerExample(List<Student> listStudents) {
		
		listStudents.forEach(consumerEx);
		
	}
	
	public static void main(String[] args) {
		
		List<Student> students = StudentDataBase.getAllStudents();
		
		System.out.println("=== Two simple consumer chained");
		students.forEach(namePrinter.andThen(activitiesPrinter)); //Consumer chaining
		
		System.out.println("=== BiConsumer example:");
		//students.forEach(biConsumer); //WRONG: Required Consumer, Provided BiConsumer
		students.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
		
		System.out.println("=== A Consumer using predicates and biConsumer:");
		consumerExample(students);
		
	}
}
