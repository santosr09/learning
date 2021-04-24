package com.juanjo.ocp.concurrency;

import java.util.List;
import java.util.Optional;

public class ParallelReduction {
	public static Integer findAnyExample() {
		return List.of(1,2,3,4,5,6)
				.stream()
				.findAny().get();
	}
	
	public static Integer findAnyWithParallel() {
			return List.of(1,2,3,4,5,6)
								 .parallelStream()
								 .findAny().get();
		}
	public static void main(String[] args) {
		System.out.println(findAnyWithParallel());
	}
}
