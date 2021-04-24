package com.juanjo.ocp.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AvoidingStateful {
	
	private static List<Integer> statefuelAddValues(IntStream source) {
		var data = Collections.synchronizedList(new ArrayList<Integer>());
		source.filter(s -> s % 2 == 0)
				.forEach(i -> { data.add(i); }); //STATEFUL : DON'T DO THIS!
		//The problem is that our lambda expression is stateful and modifies a list that is outside our stream.
		return data;
	}
	
	private static List<Integer> statelessAddValues(IntStream source) {
		//This method process the stream and then collects all the results into a new list,
		// It produces the same result on both serial and parallel streams.
		return source.filter(s -> s % 2 == 0)
				.boxed()
				.collect(Collectors.toList());
		//The implementation removes the stateful operation and relies on the collector to assemble the elements
	}
	
	public static void main(String[] args) {
		var list = statefuelAddValues(IntStream.range(1, 11));
		System.out.println(list);
		
		var listParallel = statefuelAddValues(IntStream.range(1, 11).parallel());
		//With a parallel stream, the order of the output becomes random.
		//Side effect of stateful
		System.out.println(listParallel);
		List<?> listOfUnknownType = new ArrayList<>();
		//listOfUnknownType.add(""); //DOES NOT COMPILE , ReadOnly, you can't add nothing except null
		//listOfUnknownType.add(new Object()); //DOES NOT COMPILE , ReadOnly, you can't add nothing except null
		listOfUnknownType.add(null);
	}
}
