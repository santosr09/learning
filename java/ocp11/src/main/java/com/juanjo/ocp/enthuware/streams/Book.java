package com.juanjo.ocp.enthuware.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Book {
	private String title;
	private String genre;
	
	public Book(String title, String genre) {
		this.title = title;
		this.genre = genre;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "Book{" +
							 "title='" + title + '\'' +
							 ", genre='" + genre + '\'' +
							 '}';
	}
}

class UseBook {
	
	private void orderBooks() {
		List<Book> books = Arrays.asList(new Book[]{new Book("Book1", "SCIFI"),
				new Book("OCP", "programming"),
				new Book("Book2", "programming"),
				new Book("Animals", "nature"),
				new Book("book2", "programming")});
				Comparator<Book> c1 =  (b1, b2)->b1.getGenre().compareTo(b2.getGenre()); //1
		Stream<Book> orderedBooks = books.stream().sorted(c1.thenComparing(Book::getTitle)); //2
		System.out.println(books);
		System.out.println("OrderedBooks: ");
		orderedBooks.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		UseBook obj = new UseBook();
		obj.orderBooks();
	}
}