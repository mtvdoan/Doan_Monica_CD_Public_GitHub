package com.codingdojo.productandcategory.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	List<Product> findAll();
	List<Product> findProductById(Long productId);
	List<Product> findAllByCategories(Category category);
	List<Product> findByCategoriesNotContains(Category category);
	
	Optional<Product>findByName(String name);
	Optional<Product>findById(Long id);
	Product findByIdIs(Long id);
	Optional<Product> findOneById(Long id);
    // Retrieves a list of all categories for a particular product
//    List<Product> findAllByCategories(Category category);
//    
//    // Retrieves a list of any categories a particular product
//    // does not belong to.
//    List<Product> findByCategoriesNotContains(Category category);
}



