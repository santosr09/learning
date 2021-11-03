package com.juanjo.ocp.streams_lambdas;

import java.util.Comparator;
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
	
	public static List<String> distinctActivitesAvailable() {
		return StudentDataBase.getAllStudents().stream()
				.map(Student::getActivities)
				.flatMap(List::stream)
				.distinct()
				.collect(Collectors.toList());
	}
	
	public static List<String> distinctActivitesAvailableSorted() {
		return StudentDataBase.getAllStudents().stream()
				.map(Student::getActivities)
				.flatMap(List::stream)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
	}
	
	public static Long countActivites() {
		return StudentDataBase.getAllStudents().stream()
				.map(Student::getActivities)
				.flatMap(List::stream)
				.distinct()
				.count();
	}
	
	public static List<Student> sortedByNameComparator() {
		return StudentDataBase.getAllStudents()
				.stream()
				.sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
				
	}
	
	public static void main(String[] args) {
	
		mapStudentToName().stream().forEach(System.out::println);
		
		System.out.println(flatMapStudentToActivity());
		
		System.out.println("Activities available for students: " + distinctActivitesAvailable());
		
		System.out.println("Activities available sorted BY NATURAL ORDER: " + distinctActivitesAvailableSorted());
		
		System.out.println("Total number of activities: " + countActivites());
		
		System.out.println("Students sorted by Comparator");
		System.out.println(sortedByNameComparator());
	}
	
}
