package com.juanjo.ocp.concurrency;

import java.util.concurrent.*;

public class WaitingTasks {
	
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> result = service.submit(() -> 30 +11);
			System.out.println(result.get());
		} finally {
			if(service != null) service.shutdown();
		}
		if(service != null) {
			service.awaitTermination(1, TimeUnit.MINUTES);
			if(service.isTerminated()) System.out.println("Finished!");
			else System.out.println("At least one task is still running");
		}
	}
}
