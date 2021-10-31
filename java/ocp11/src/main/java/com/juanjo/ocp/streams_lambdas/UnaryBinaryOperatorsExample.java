package com.juanjo.ocp.streams_lambdas;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryOperatorsExample {
	
	static UnaryOperator<String> unaryOpEx = s -> s.concat(".Default");
	
	static Comparator<Integer> comparatorMax = (a, b) -> a.compareTo(b);
	
	static BinaryOperator<Integer> binaryOpEX = (a, b) -> a * b;
	
	static BinaryOperator<Integer> maximumVal = BinaryOperator.maxBy(comparatorMax);
	
	public static void main(String[] args) {
		
		System.out.println( unaryOpEx.apply("Hello") );
		
		System.out.println(binaryOpEX.apply(5,3));
		
		System.out.println(maximumVal.apply(34, 56));
		
		
	}
}
