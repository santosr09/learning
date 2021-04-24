package com.juanjo.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// SingleThread Executor example
public class ZooInfo {
	
	public static void main(String[] args) {
		ZooInfo.example();
	}
	
	public static void example() {
		ExecutorService service = null;
		Runnable task1 = () ->
												 System.out.println("Printing Zoo inventory");
		Runnable task2 = () -> {
			for(int i = 0; i < 3; i++) System.out.println("Printing record: " +i);
		};
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("begin");
			service.execute(task1);
			service.execute(task2);
			service.execute(task1);
			System.out.println("end");
		} finally {
			if(service != null) service.shutdown();
		}
	}
	
}
