package com.juanjo.ocp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockExample {
	public static class Food {}
	public static class Water {}
	public static class Fox {
		public void eatAndDrink(Food food, Water water) {
			synchronized(food) {
				System.out.println("Got Food!");
				move();
				synchronized (water) {
					System.out.println("Got water!");
				}
			}
		}
		public void drinkAndEat(Food food, Water water) {
			synchronized (water) {
				System.out.println("Got Water!");
				move();
				synchronized (food) {
					System.out.println("Got Food!");
				}
			}
		}
		public void move() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("InterruptedException");
			}
		}
	}
	
	public static void main(String[] args) {
		Fox foxy = new Fox();
		Fox tails = new Fox();
		Food food = new Food();
		Water water = new Water();
		ExecutorService service = null;
		try {
			service = Executors.newScheduledThreadPool(10);
			service.submit(() -> foxy.eatAndDrink(food, water));
			service.submit(() -> tails.drinkAndEat(food, water));
		} finally {
			if(service != null) service.shutdown();
		}
	}
}
