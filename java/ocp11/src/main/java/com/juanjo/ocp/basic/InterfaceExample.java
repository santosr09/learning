package com.juanjo.ocp.basic;

public class InterfaceExample {
	
	interface InterfaceA {
		default void methodA() {		}
	}
	
	interface InterfaceB {
		default void methodA() {		}
	
	}
	
	// DOES NOT COMPILE, ConcreteClass inherits unrelated defaults for methodA() from types interfaceA and interfaceB
	// class ConcreteClass implements interfaceA, interfaceB {	}
	
	// DOES NOT COMPILE, even abstract class, inherits unrelated defaults
	// abstract class ConcreteClass implements interfaceA, interfaceB {	}
	
	abstract class ConcreteClass implements InterfaceA, InterfaceB {
		// void methodA() {		} // DOES NOT COMPILE, Attempting to assign weaker access privileges ('package-private'); was 'public'
		
		public void methodA() {		}
		
		public void  getInterfaceAMethod() {
			// default method is treated as part of the instance, since it CAN NOT BE OVERRIDEN; CAN NOT be called like a static method
			//InterfaceA.methodA(); // DOES NOT COMPILE
			
			// Which inherited method is called? In fact, the compiler won't allow this even if there is only one inherited default method, as an interface is not part of the class hierarchy.
			//super.methodA(); // DOES NOT COMPILE
			
			InterfaceA.super.methodA();
		}
		
 	}
	
}
