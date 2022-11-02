package com.codingdojo.bookbroker.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.bookbroker.models.Book;
import com.codingdojo.bookbroker.models.User;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
	// this method retrieves all the books from the database
	List<Book> findAll();
	
	List<Book> findByThoughtsContaining(String search);
	
	// this method counts how many titles contain a certain string
	Long countByTitleContaining(String search);
	 
	// this method deletes a book that starts with a specific title
	Long deleteByTitleStartingWith(String search);
	
	List<Book> findAllByUser(User user);
	 
	Optional<Book> findOneById(Long id);
	 
	List<Book> findByUserIdIs(Long userId);
	
	List<Book> findByBorrowerIdIs(Long userId);
	
	List<Book> findByBorrowerIdIsOrUserIdIs(Long borrowerID, Long userId);
}


