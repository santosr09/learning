package com.juanjo.ocp.concurrency;

import java.util.concurrent.*;

public class CheckResults {
	private static int counter = 0;
	
	public static void main(String[] args) throws Exception{
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<?> result = service.submit(() -> {
				for(int i = 0; i < 1000; i++) CheckResults.counter++;
					});
			result.get(1, TimeUnit.SECONDS);
			System.out.println("Reached!");
		} catch (TimeoutException e) {
			System.out.println("Not reached in time");
		} finally {
			if(service != null) service.shutdown();
		}
	}
}
