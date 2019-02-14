package com.chainsys.jdbc;

public class BookValidator {
	public void validateBook(Book book) throws Exception {
		if (book.name == null) {
			throw new Exception("Invalid name");
		}
		if(book.price<=0){
			throw new Exception("Invalid price may be less or equal to zero");
		}
	}
}
