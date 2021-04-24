package com.juanjo.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LionPenManager {
	private void removeLions() {
		System.out.println("Removing Lions");
	}
	private void cleanPen() {
		System.out.println("Cleaning the pen");
	}
	private void addLions() {
		System.out.println("Adding Lions");
	}
	public void performTask() {
		removeLions();
		cleanPen();
		addLions();
	}
	
	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(4);
			var manager = new LionPenManager();
			for(int i = 0; i < 4; i++)
				service.submit(() -> manager.performTask());
		} finally {
			if (service != null) service.shutdown();
		}
	}
}
