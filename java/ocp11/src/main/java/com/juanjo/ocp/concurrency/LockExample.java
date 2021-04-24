package com.juanjo.ocp.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
	public static void printMessage(Lock lock){
		try {
			lock.lock();
			System.out.println("Printing a message from a thread-safe method...");
		} finally {
			System.out.println("..Releasing the lock in printMessage()");
			lock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Lock lockObj = new ReentrantLock();
		new Thread(() -> printMessage(lockObj)).start();
		//if(lockObj.tryLock()) {
		if(lockObj.tryLock(2, TimeUnit.SECONDS)) {
			try {
				System.out.println("Lock obtained, entering protected code");
			} finally {
				System.out.println("...lockObj.unlock()");
				lockObj.unlock();
			}
		} else {
			System.out.println("Unable to acquire lock, doing something else");
		}
		lockExample();
	}
	
	private static void lockExample() {
		Lock lockObj = new ReentrantLock();
		new Thread(() -> printMessage(lockObj)).start();
		if(lockObj.tryLock()) {
			try {
				lockObj.lock();
				System.out.println("lockExample(): Lock obtained, entering protected code");
			} finally {
				System.out.println("lockExample():  ...lockObj.unlock()");
				lockObj.unlock();
			}
		}
	}
	
}
