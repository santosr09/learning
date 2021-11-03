package com.juanjo.ocp.streams_lambdas;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
	
	public static List<String> mapStudentToName() {
		return StudentDataBase.getAllStudents().stream()
				.map(Student::getName)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
	}
	
	public static List<String> flatMapStudentToActivity() {
		return StudentDataBase.getAllStudents().stream()
				.map(Student::getActivities)
				.flatMap(List::stream)
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
	
		mapStudentToName().stream().forEach(System.out::println);
		
		System.out.println(flatMapStudentToActivity());
	}
}
