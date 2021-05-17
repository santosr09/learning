package com.juanjo.ocp.basic;

public enum EnumExample {
	ROJO("RED"), AZUL("BLUE"), AMARILLO("YELLOW");
	String word;
	EnumExample(String english) {
		this.word = english;
	}
	
}
