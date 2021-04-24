package com.juanjo.ocp.concurrency;

public class ThreadStarterExample {
	
	public static void main(String[] args) {
		System.out.println("begin");
		(new ReadInventoryThread()).start();
		(new Thread(new PrintDataRunnable())).start();
		(new ReadInventoryThread()).start();
		System.out.println("end");
		
		//Calling run() on a Thread or a Runnable does not actually start a new Thread
		System.out.println("begin");
		(new ReadInventoryThread()).run();
		(new Thread(new PrintDataRunnable())).run();
		(new ReadInventoryThread()).run();
		System.out.println("end");
	}
}
