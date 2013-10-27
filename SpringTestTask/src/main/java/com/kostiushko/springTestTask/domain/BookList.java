package com.kostiushko.springTestTask.domain;

import java.util.ArrayList;

public class BookList {

    private ArrayList<Book> bookList;
    private Book book;

    public ArrayList<Book> getBookList() {
	return bookList;
    }

    public void setBookList(ArrayList<Book> bookList) {
	this.bookList = bookList;
    }

    @Override
    public String toString() {
	return "BookList [bookList=" + bookList + "]";
    }

    public Book getBook() {

	return book;
    }

    public void setBook(Book book) {
	bookList.add(book);
	this.book = book;
    }

    public void removeBook(Book book) {
	bookList.remove(book);
    }

    public void addBook(Book book) {
	bookList.add(book);
    }

    public Book extractBook(Integer bookId) {

	for (Book book : bookList) {
	    if (book.getId() == bookId) {
		bookList.remove(book);
		return book;
	    }

	}
	return null;
    }
}
