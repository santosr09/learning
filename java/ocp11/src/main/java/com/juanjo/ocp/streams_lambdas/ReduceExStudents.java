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
	
	//Return the number of notebooks
	private static int noOfNoteBooks(List<Student> list) {
		return list.stream()
				.map(Student::getNoteBooks)
				//.reduce(0, (a , b) -> a+b);
		    .reduce(0, Integer::sum);
	}
	
	private static int noOfNoteBooksFiltering(List<Student> list) {
		return list.stream()
				.filter((student -> student.getGradeLevel() >=3))
				.map(Student::getNoteBooks)
				.reduce(0, Integer::sum);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Number of NoteBooks");
		System.out.println(noOfNoteBooks(students));
		
		System.out.println("Number of NoteBooks, when grade level >3");
		System.out.println(noOfNoteBooksFiltering(students));
		
		System.out.println("Get the student with Highest GPA");
		System.out.println(getHighestGPAStudent(students).get());
		
		System.out.println("Get the student with Highest GPA");
		System.out.println(getHighestGPAStudentSimplified(students).get().getName());
		
	}
}
