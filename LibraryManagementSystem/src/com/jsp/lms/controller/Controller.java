package com.jsp.lms.controller;

import java.util.ArrayList;
import java.util.List;
import com.jsp.lms.model.Book;
import com.jsp.lms.model.Library;
import com.jsp.lms.view.View;


public class Controller {
	private Library library = View.getLibrary();

	public void addBook(Book book) {
		List<Book> books = library.getBooks();
		if (books == null) {
			books = new ArrayList<>();
		}
		books.add(book);
		library.setBooks(books);
	}

	public boolean removeBook(String bookName) {
		Book book = getBook(bookName); // Book
		if (book != null) {
			List<Book> books = library.getBooks(); // List of Books from Library
			boolean bookRemove = books.remove(book); // Remove Book from List of Books from Library
			library.setBooks(books); // Update List of Books from Library
			return true; // Book exist
		}
		return false; // Book does not exist
	}

	public boolean update(Book bookExist, Book bookUpdate) {
		List<Book> books = library.getBooks();
		for (Book book : books) {
			if (book.getBookName().equalsIgnoreCase(bookExist.getBookName())) {
				books.remove(bookExist);
				books.add(bookUpdate);
				library.setBooks(books);
				return true;
			}
		}
		return false;
	}

	public Book getBook(String bookName) {
		List<Book> books = library.getBooks();
		if (books!=null) { //List of book exist //Linear Search
			for (Book book : books) {
				if(book.getBookName().equalsIgnoreCase(bookName)){
					return book;
				}
			}
		}
		return null;
	}

}
