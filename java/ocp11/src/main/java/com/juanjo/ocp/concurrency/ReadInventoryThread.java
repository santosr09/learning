package com.juanjo.ocp.concurrency;

public class ReadInventoryThread extends Thread{
	
	public void run() {
		System.out.println("printing inventory");
	}
	
	public static void main(String[] args) {
		(new ReadInventoryThread()).start();
	}
	
}
