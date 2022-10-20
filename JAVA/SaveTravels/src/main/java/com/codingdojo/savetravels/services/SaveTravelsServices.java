package com.codingdojo.savetravels.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.savetravels.models.SaveTravels;
import com.codingdojo.savetravels.repositories.SaveTravelsRepository;

@Service
public class SaveTravelsServices{
	@Autowired
    private final SaveTravelsRepository saveTravelsRepository;
    
	public SaveTravelsServices(SaveTravelsRepository saveTravelsRepository) {
		this.saveTravelsRepository = saveTravelsRepository;
	}
	
	public List<SaveTravels> getAll(){
		return saveTravelsRepository.findAll();
	}
	
	public SaveTravels getOne(Long id) {
		Optional<SaveTravels> saveTravels = saveTravelsRepository.findOneById(id);
		if(saveTravels.isPresent()) {
			return saveTravels.get();
		}
		else {
			return null;
		}
	}
	
	public SaveTravels createSaveTravels(SaveTravels saveTravels) {
		return saveTravelsRepository.save(saveTravels);
	}
	
	public SaveTravels findSaveTravels(Long id) {
		Optional<SaveTravels> optionalSaveTravels = saveTravelsRepository.findById(id);
		if(optionalSaveTravels.isPresent()) {
	      return optionalSaveTravels.get();
		} 
		else {
			return null;
		}
	}
	
	public SaveTravels updateSaveTravels(SaveTravels saveTravels) {
		return saveTravelsRepository.save(saveTravels);
    }
	
	public void deleteSaveTravels(Long id) {
		Optional<SaveTravels> optionalSaveTravels = saveTravelsRepository.findById(id);
		if(optionalSaveTravels.isPresent()) {
			saveTravelsRepository.deleteById(id);
		}
	}

}


//import java.util.List;
//import java.util.Optional;
//
////...
//import org.springframework.stereotype.Service;
//
//import com.codingdojo.renderingbooksform.models.Book;
//import com.codingdojo.renderingbooksform.repositories.BookRepository;
//@Service
//public class BookService {
// // adding the book repository as a dependency
//    private final BookRepository bookRepository;
//    
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//    // returns all the books
//    public List<Book> allBooks() {
//        return bookRepository.findAll();
//    }
//    // creates a book
//    public Book createBook(Book b) {
//        return bookRepository.save(b);
//    }
//    // retrieves a book
//    public Book findBook(Long id) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if(optionalBook.isPresent()) {
//            return optionalBook.get();
//        } else {
//            return null;
//        }
//    }
//    
//    // updateBook will take in a Book object and save it to our database
//    // our repository will automatically update an existing Book object if their IDs match
//    public Book updateBook(Book book) {
//        return bookRepository.save(book);
//    }
//    
//    // to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
//    public void deleteBook(Long id) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if(optionalBook.isPresent()) {
//            bookRepository.deleteById(id);
//        }
//    }
//    public BookRepository getBookRepository() {
//        return bookRepository;
//    }
//    
