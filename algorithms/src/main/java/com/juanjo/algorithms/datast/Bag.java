package com.juanjo.algorithms.datast;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
	private Node first; // first node in list
	private int N;
	
	private class Node {
		Item item;
		Node next;
	}
	
	public void add(Item item) { // same as push() in Stack
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}
	
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		public boolean hasNext() {
			return current != null;
		}
		
		public void remove() {
		}
		
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
