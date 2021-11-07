package com.juanjo.ocp.streams_lambdas;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamOperationExample {
	
	static List<Integer> integers = Arrays.asList(3, 5, 8, 2, 4);
	
	public static int reduceBySum(List<Integer> list) {
		
		return list.stream()
							 .reduce(1, (a,b) -> a+b);
		
	}
	
	public static Optional<Integer> reduceBySumWrong(List<Integer> list) {
		
		return list.stream()
				.reduce((a,b) -> a+b);
		
	}
	
	public static int reduceByMultip(List<Integer> list) {
		return list.stream()
							 .reduce(1, (a, b) -> a*b);
	}
	
	public static Optional<Integer> reduceByMultipNoIdentity(List<Integer> list) {
		return list.stream()
				.reduce((a, b) -> a*b);
	}
	
	public static void main(String[] args) {
		System.out.println("Reduce by sum(correct result):");
		System.out.println(reduceBySum(integers));
		
		System.out.println("Reduce by sum using IDENTITY(wrong result)");
		System.out.println(reduceBySumWrong(integers));
		
		System.out.println("Reduce using multiplication:");
		System.out.println(reduceByMultip(integers));
		
		System.out.println("Reduce using multiplication (No Identity) Optional result:");
		System.out.println(reduceByMultipNoIdentity(integers));
		
		System.out.println("Reduce using multiplication (No Identity) Optional result:");
		System.out.println(reduceByMultipNoIdentity(Arrays.asList()));
		
	}
}
