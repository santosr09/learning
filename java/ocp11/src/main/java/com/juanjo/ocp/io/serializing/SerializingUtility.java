package com.juanjo.ocp.io.serializing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializingUtility {
	
	public void saveToFile(List<Chimpanzee> chimpances, File dataFile) throws IOException {
		try (var out = new ObjectOutputStream(
						 new BufferedOutputStream(
						 		new FileOutputStream(dataFile)))) {
			for (Chimpanzee item: chimpances)
				out.writeObject(item);
		}
	}
	
	public List<Chimpanzee> readFromFile(File dataFile) throws IOException, ClassNotFoundException {
		var chimpances = new ArrayList<Chimpanzee>();
		try (var in = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(dataFile)))) {
			while (true) {
				var object = in.readObject();
				if (object instanceof Chimpanzee)
					chimpances.add((Chimpanzee) object);
			}
		} catch (EOFException e) {
			System.out.println(e);
		}
		return chimpances;
	}
}
