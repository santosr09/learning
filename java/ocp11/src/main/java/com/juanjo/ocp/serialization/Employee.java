package com.juanjo.ocp.serialization;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
* This example makes use of writeObject() and readObject()
 * We skip the 'age' field without using the 'transient' modifier.
 * A java.lang.IllegalArgumentException: no such field age with type int
* */
public class Employee implements Serializable {
	private String name;
	private String ssn;
	private int age;
	private static Map<String, Employee> pool = new ConcurrentHashMap<>();
	
	public synchronized static Employee getEmployee(String name) {
		if(pool.get(name) == null) {
			var e = new Employee();
			e.name = name;
			pool.put(name, e);
		}
		return pool.get(name);
	}
	
	private static String encrypt(String input) {
		return "[=)%#$%&/";
	}
	
	private static String decrypt(String input) {
		return "Hola";
	}
	
	/*
	PutField = Provide programmatic access to the persistent fields to be written to ObjectOutput.
	
	putFields() = Retrieve the object used to buffer persistent fields to be written to the stream.
	     The fields will be written to the stream when writeFields method is called.
	
	writeFields() = Write the buffered fields to the stream.
	
	*/
	
	private void writeObject(ObjectOutputStream s) throws Exception {
		ObjectOutputStream.PutField fields = s.putFields();
		fields.put("name", name);
		fields.put("ssn", encrypt(ssn));
		s.writeFields();
	}
	

	private void readObject(ObjectInputStream s) throws Exception {
		ObjectInputStream.GetField fields = s.readFields();
		this.name = (String) fields.get("name", null);
		this.ssn = decrypt((String)fields.get("ssn", null));
	}
	
	/*
	* Alternatively, you can specify fields to be serialized in an array. Make sure you remember to use the
	* private, static and final modifiers. Otherwise the field will be ignored.
	*
	* You can think of serialPersistentFields as the opposite of transient. A whitelist of fields that should be serialized.
	* */
	private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("name", String.class)};
	
	
	public synchronized Object readResolve() {
		var existingEmployee = pool.get(name);
		if(pool.get(name) == null) {
			// New employee not in memory
			pool.put(name, this);
			return this;
		} else {
			// Existing user already in memory
			existingEmployee.name = this.name;
			existingEmployee.ssn = this.ssn;
			return existingEmployee;
		}
	}
	
	/*
	* The writeReplace() method is run before writeObject() and allows us to replace the object that gets serialized
	* */
	
	public Object writeReplace() throws ObjectStreamException {
		var e = pool.get(name);
		return e != null ? e : this;
	}
	
	/*SUMMARY OF METHODS FOR SERIALIZATION AND DESERALIZIZATION
	* writeReplace() -> Allows replacement of object before serialization
	* writeObject() -> Serializes optionally using PutField
	* readObject() -> Deserializes optionally using GetField
	* readResolve() -> Allows replacement of object after deserialization
	* */
}
