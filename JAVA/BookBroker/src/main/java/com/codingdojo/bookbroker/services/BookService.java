package com.codingdojo.bookbroker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.bookbroker.models.Book;
import com.codingdojo.bookbroker.models.User;
import com.codingdojo.bookbroker.repositories.BookRepository;


@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public List<Book> unborrowedBooks(User user){
		return bookRepository.findByBorrowerIdIsOrUserIdIs(null, user.getId());
	}
	
	public List<Book> borrowedBooks(User user){
		return bookRepository.findByBorrowerIdIs(user.getId());
	}
	
	public List<Book> myBooks(User user){
		return bookRepository.findByUserIdIs(user.getId());
	}
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(Book book) {
		bookRepository.delete(book);
	}
	
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}
		else {
			return null;
		}
	}
	
	//Applies the user id into the book's borrower_id column
	public void removeBorrower(Book book) {
		book.setBorrower(null);
		bookRepository.save(book);
	}
	
	//Removes the user id from the book's borrower_id column
	public void addBorrower(Book book, User user) {
		book.setBorrower(user);
		bookRepository.save(book);
	}

}