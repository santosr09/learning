package com.juanjo.ocp.concurrency;

public class PrintDataRunnable implements Runnable{
	
	public static void main(String[] args) {
		(new Thread(new PrintDataRunnable())).start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Printing record: " + i);
		}
	}
	
}
