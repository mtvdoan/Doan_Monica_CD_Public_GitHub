package com.codingdojo.dojosninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosninjas.models.Dojos;

@Repository
public interface DojosRepository extends CrudRepository<Dojos, Long> {
	// this method retrieves all the books from the database
	List<Dojos> findAll();
	// this method finds books with descriptions containing the search string

	Optional<Dojos>findOneById(Long id);	
}

