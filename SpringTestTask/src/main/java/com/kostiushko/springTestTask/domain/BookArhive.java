package com.kostiushko.springTestTask.domain;

import java.util.ArrayList;

public class BookArhive {

    private ArrayList<Book> arhive;

    @Override
    public String toString() {
	return "BookArhive [arhive=" + arhive + "]";
    }

    public ArrayList<Book> getArhive() {
	return arhive;
    }

    public void setArhive(ArrayList<Book> arhive) {
	this.arhive = arhive;
    }

    public void addBook(Book book) {
	arhive.add(book);
    }

    public void addBooks(ArrayList<Book> books) {
	arhive.addAll(books);
    }

    public Book getBook(Book book) {
	Book ret = arhive.get(book.getId());
	arhive.remove(book);
	return ret;
    }

    public Book getBook(Integer bookId) {

	for (Book book : arhive) {
	    if (book.getId() == bookId) {
		arhive.remove(book);
		return book;
	    }

	}
	return null;
    }
}
