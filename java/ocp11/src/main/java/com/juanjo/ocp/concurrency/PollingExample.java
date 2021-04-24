package com.juanjo.ocp.concurrency;

public class PollingExample {
	private static int counter = 0;
	public static void main(String[] args) throws InterruptedException {
		//PollingExample.badPolling();
		PollingExample.usingSleep();
	}
	
	private static void usingSleep() throws InterruptedException {
		new Thread(() -> {
			for(int i = 0; i < 1000; i++) PollingExample.counter++;
		}).start();
		while(PollingExample.counter < 100) {
			System.out.println("Not reached yet");
			Thread.sleep(1000);
		}
		System.out.println("Reached!");
	}
	
	private static void badPolling() {
		new Thread(() -> {
			for(int i = 0; i < 1000; i++) PollingExample.counter++;
		}).start();
		while(PollingExample.counter < 100) {
			System.out.println("Not reached yet");
		}
		System.out.println("Reached!");
	}
	
}
