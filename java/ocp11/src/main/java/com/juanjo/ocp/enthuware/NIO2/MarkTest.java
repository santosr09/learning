package com.juanjo.ocp.enthuware.NIO2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MarkTest {
	
	public static void main(String[] args) {
		try(Reader r = new BufferedReader(new FileReader("src/main/resources/testNio2.txt"))) {
			if(r.markSupported()) {
				BufferedReader in = (BufferedReader) r;
				System.out.println(in.readLine());
				in.mark(10);
				System.out.print(in.readLine());
				System.out.print(in.readLine());
				in.reset();
				System.out.print(in.readLine());
				in.reset();
				System.out.println(in.readLine());
			} else {
				System.out.println("Mark not supported");
			}
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}
