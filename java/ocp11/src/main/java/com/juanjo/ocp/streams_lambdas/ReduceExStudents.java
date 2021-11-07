package com.juanjo.ocp.streams_lambdas;

import java.util.List;
import java.util.Optional;

public class ReduceExStudents {
	
	static List<Student> students = StudentDataBase.getAllStudents();

	// Get the student with the Highest GPA
	public static Optional<Student> getHighestGPAStudent(List<Student> list) {
		return list.stream()
				.reduce((s1, s2) -> {
					if(s1.getGpa() > s2.getGpa()){
						return s1;
					} else {
						return s2;
					}
				});
	}
	
	public static Optional<Student> getHighestGPAStudentSimplified(List<Student> list) {
		return list.stream()
				.reduce((s1, s2) -> (s1.getGpa() > s2.getGpa()) ? s1: s2);
	}
	
	public static void main(String[] args) {
		
		System.out.println(getHighestGPAStudent(students).get());
		
		System.out.println(getHighestGPAStudentSimplified(students).get().getName());
	}
}
