package com.juanjo.algorithms.datast;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.InputStream;
import java.util.Scanner;


public class Stats {
	
	public static void main(String[] args) {
		ClassLoader classLoader = Stats.class.getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream("stats_input.txt");
		StdIn.setNewScanner(new Scanner(inputStream));
		
		Bag<Double> numbers = new Bag<Double>();
		
		while (!StdIn.isEmpty())
			numbers.add(StdIn.readDouble());
		int N = numbers.size();
		double sum = 0.0;
		for (double x : numbers)
			sum += x;
		double mean = sum / N;
		sum = 0.0;
		for (double x : numbers)
			sum += (x - mean) * (x - mean);
		double std = Math.sqrt(sum / (N - 1));
		for(double item : numbers)
			System.out.println("item in numbers: " + item);
		StdOut.printf("Mean: %.2f\n", mean);
		StdOut.printf("Std dev: %.2f\n", std);
	}
}
