package com.juanjo.ocp.nestedClasses;

public class Outer {
	
	private static String outerName = "OuterName";
	private String finalValue = "finalInstanceValue";
	
	public String getFinalValue() {
		return this.finalValue;
	}
	
/*Static Nested Class*/
	public static class StaticNested {
		public String nestedName = "Static Nested Name";
		
		public void printNestedInfo() {
			System.out.println("OuterName from SaticNestedClass: " + outerName);
		}
	}
	
	/*Member Inner Class*/
	private class MemberInnerClass {
		private String nameInnerClass = "InnerMember";
		
		public MemberInnerClass(){
			System.out.println("MemberInnerClass creada...");
		}
		
		public String getName() {
			return this.nameInnerClass;
		}
		//public static void staticMethod() { }//Does not compile: Inner classes cannot have static declarations
	}
	
	public MemberInnerClass getInnerClass(){
		return new MemberInnerClass();
	}
	
	public void instanceMethod(String methodParam) {
		//methodParam = "newValue"; // Does NOT Compile: Variable 'methodParam' is accessed from within inner class, needs to be final or effectively final
		//Modifier 'public' not allowed here
		class LocalInnerClass {
			String localValue = finalValue + "localName";
			
			private String getMethodParam() {
				return methodParam.concat(" processed...");
			}
			
		}
		LocalInnerClass localInner = new LocalInnerClass();
		System.out.println(localInner.getMethodParam());
	}
	
	public static void main(String[] args) {
		Outer.StaticNested nested = new Outer.StaticNested();
		nested.printNestedInfo();
		System.out.println("NestedName: " + nested.nestedName);
		
		Outer outer = new Outer();
		outer.getInnerClass();
		
		outer.instanceMethod("param1");
	}
	
}
