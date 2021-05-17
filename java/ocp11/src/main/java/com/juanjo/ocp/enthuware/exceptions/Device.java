package com.juanjo.ocp.enthuware.exceptions;

import java.io.IOException;

public class Device implements AutoCloseable{
	String header = null;
	 public void open() throws IOException {
	 	header = "OPENED";
		 System.out.println("Device opened");
		 throw new IOException("Unknown");
	 }
	 
	 public String read() throws IOException{
	 	return "";
	 }
	
	@Override
	public void close() {
		System.out.println("Closing device");
		header = null;
		throw new RuntimeException("RTE");
	
	}
	
	public static void main(String[] args) throws Exception{
		try(Device deviceObj = new Device()) {
			throw new Exception("test");
			/*
			If an exception is thrown within the try-with-resources block, then that is the exception that the caller gets.
			But before the try block returns, the resource's close() method is called and if the close() method throws an exception as well,
			then this exception is added to the original exception as a supressed exception. */
			
		}
	}
}
