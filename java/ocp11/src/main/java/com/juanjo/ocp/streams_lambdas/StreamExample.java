package com.juanjo.ocp.streams_lambdas;

import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
	
	public static List<String> mapStudentToName() {
		return StudentDataBase.getAllStudents().stream()
				.map(Student::getName)
				.collect(Collectors.toList());
		
	}
	
	public static void main(String[] args) {
	
		mapStudentToName().stream().forEach(System.out::println);
	}
}
