package com.juanjo.ocp.concurrency;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReduceCollectExample {
	
	private static void groupingByExample() {
		var ohMy = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, List<String>> map = ohMy.collect(
				Collectors.groupingByConcurrent(String::length));
		System.out.println(map);
	}
	
	private static void parallelReductionExample() {
		Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();
		ConcurrentMap<Integer, String> map = ohMy
				.collect(Collectors.toConcurrentMap(String::length,
						k -> k,
						(s1,s2) -> s1 + "," +s2));
		System.out.println(map);
		System.out.println(map.getClass());
	}
	
	private static void collectExample() {
		Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
		SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new,
				Set::add,
				Set::addAll);
		System.out.println(set);
	}
	private static String reduceExample() {
		return List.of('w','o','l','f')
				.parallelStream()
				.reduce("",
						(s1,c) -> s1 + c,
						(s2,s3) -> s2 + s3);
	}
	
	public static void main(String[] args) {
		//System.out.println(reduceExample());
		//collectExample();
		//parallelReductionExample();
		groupingByExample();
	}
}
