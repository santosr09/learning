package com.juanjo.ocp.exceptions;

import java.io.*;

public class TryWithParamsEx {
	
	public static void openFile(){
		try (
				BufferedReader in = new BufferedReader(new FileReader("some.txt"));
				//TryWithParamsEx obj = new TryWithParamsEx(); //DOESN'T COMPILE - NOT AUTOCLOSABLE
				 PrintWriter out = new PrintWriter(new FileWriter("output.txt"))
		){
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
