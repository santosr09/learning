package com.juanjo.ocp.streams;

public class TestBair {
	
	String Consecutive(String str) {
		int cont = 0;
		String newStr = "";
		char[] arr = str.toCharArray();
		for(int i=0; i< arr.length; i++) {
			char current = arr[i];
			if ( (i+1 < arr.length)&&(current == arr[i + 1])) {
				cont++;
			} else if ((cont == 1)){
				cont = 0;
				newStr+=current;
			} else {
				cont = 0;
			}
		}
		return newStr;
		}
		
	
	public static void main(String[] args) {
		TestBair obj = new TestBair();
		obj.Consecutive("133555777aa66");
		System.out.println(obj.Consecutive("133555777aa66"));
		
	}
}

