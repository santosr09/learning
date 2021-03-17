package com.juanjo.ocp.collections;

import java.util.Arrays;
import java.util.List;

public class ArrListEx {
	
	public static void main(String[] args) {
		//String[] arr = new String[]; //DOES NOT COMPILE: Array initializer expected
		String[] arr = new String[2]; //Array initializer expected
		arr[0] = "Cake";
		arr[1] = "Tea";
		
		System.out.println("arr[0]: " + arr[0]);
		
		List<String> texts = Arrays.asList(arr);
		texts.set(0, "Coffe");
		System.out.println("texts: " + texts);
		
		texts.add("Chocolate"); //UnsopportedOperationException thrown at runtime
		
	}
}
