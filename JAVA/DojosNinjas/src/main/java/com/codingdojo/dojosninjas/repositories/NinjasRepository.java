package com.codingdojo.dojosninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosninjas.models.Dojos;
import com.codingdojo.dojosninjas.models.Ninjas;

@Repository
public interface NinjasRepository extends CrudRepository<Ninjas, Long> {
	// this method retrieves all the books from the database
	List<Ninjas> findAll();
	// this method finds books with descriptions containing the search string

	Optional<Ninjas>findOneById(Long id);	

	List<Ninjas> findAllByDojos(Dojos dojos);

}

