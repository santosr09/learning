package com.juanjo.ocp.concurrency;

import java.util.concurrent.*;

public class ScheduledExecutorExample {
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		Runnable task1 = () -> System.out.println("Hello Zoo");
		Runnable task3 = () -> System.out.println("Hello Zoo Fixed Delay");
		Runnable task4 = () -> System.out.println("Hello Zoo Fixed Rate");
		Callable<String> task2 = () -> {
			System.out.println("Monkey");
			return "Monkey";
		};
		ScheduledFuture<?> r1 = service.schedule(task1, 2, TimeUnit.SECONDS);
		ScheduledFuture<?> r2 = service.schedule(task2, 5, TimeUnit.SECONDS);
		service.scheduleAtFixedRate(task4, 4, 1, TimeUnit.SECONDS);
		service.scheduleWithFixedDelay(task3, 6, 3, TimeUnit.SECONDS);
		//service.shutdown();
	}
}
