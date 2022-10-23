package com.codingdojo.savetravels.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.savetravels.models.SaveTravels;

@Repository
public interface SaveTravelsRepository extends CrudRepository<SaveTravels, Long> {
	// this method retrieves all the books from the database
	List<SaveTravels> findAll();
	// this method finds books with descriptions containing the search string
	List<SaveTravels> findByDescriptionContaining(String search);
//	// this method counts how many titles contain a certain string
//	Long countByExpenseNameContaining(String search);
//	// this method deletes a book that starts with a specific title
//	String deleteByExpenseNameStartingWith(String search);
	
	Optional<SaveTravels>findOneById(Long id);	
}

