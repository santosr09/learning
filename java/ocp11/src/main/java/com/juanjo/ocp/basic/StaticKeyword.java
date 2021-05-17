package com.juanjo.ocp.basic;

public class StaticKeyword {
	
	/*
	Static indicates a particular member belongs to a type itself, rather to an instance of that type.
	Static can be applied to:
	1- Class variables
	2- Class Method
	3- Blocks
	4- Nested Class
	
	CAN NOT be used in conjunction with:
	abstract
	
	static METHODS
	static METHODS CAN'T BE Overriden
	Sattic methods CAN NOT access instance members (instance variables and methods)
	 */
	static String staticVar;
	
	private String instanceVar;
	
	static void methodStatic() {
		
		// 'this' cannot be referenced from a static context
		// this.instanceMethod(); // DOES NOT COMPILE
		
		// Non-static method 'instanceMethod()' cannot be referenced from a static context
		// instanceMethod(); // DOES NOT COMPILE
	}
	
	private void instanceMethod() {
		this.methodStatic();
	}
	
	//STATIC CLASS
	static class InnerStaticClass {
		static String innerStaticVar;
		
		static void innerStaticMethod() {
		
		}
		static class InsideInnerClass {
		
		}
		
	}
	
}

// SUBCLASS
class SubClass extends StaticKeyword {
	
	// Instance method 'methodStatic()' in 'SubClass' cannot override static method 'methodStatic()' in 'StaticKeyword'
	// void methodStatic() {		} // DOES NOT COMPILE
	
	// private void methodStatic() {		} // DOES NOT COMPILE , attempting to assign weaker access priviliges
	
	public static void subStaticMethod() {
		
		// super and this CAN NOT be used in static context
		//super.methodStatic() {		}
		
	}
}