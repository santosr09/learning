package com.juanjo.ocp.concurrency;

import java.util.List;

public class ParalleDecomposition {
	
	private static int doWork(int input) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		return input;
	}
	private static void usingSerialStream() {
		long start = System.currentTimeMillis();
		List.of(1,2,3,4,5)
				.stream()
				.map(w -> doWork(w))
				.forEach(s -> System.out.print( s + " "));
		
		System.out.println();
		var timeTaken = (System.currentTimeMillis() - start) / 1000;
		System.out.println("Time: " + timeTaken + " seconds");
	}
	
	// With parallel stream the map() and forEach() operations are applied concurrently
	private static void usingParallelStream() {
		long start = System.currentTimeMillis();
		List.of(1,2,3,4,5)
				.parallelStream()
				.map(w -> doWork(w))
				
				//.forEach(s -> System.out.print( s + " "));
				
				//It forces a parallel stream to process the results in order at the cost of performance
				.forEachOrdered(s -> System.out.print( s + " "));
		
		System.out.println();
		var timeTaken = (System.currentTimeMillis() - start) / 1000;
		System.out.println("Time: " + timeTaken + " seconds");
	}
	
	public static void main(String[] args) {
		//usingSerialStream();
		usingParallelStream();
	}
}
