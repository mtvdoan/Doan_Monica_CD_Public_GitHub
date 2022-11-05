//
//package com.codingdojo.dojooverflow.repositories;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import com.codingdojo.dojooverflow.models.Category;
//import com.codingdojo.dojooverflow.models.Product;
//
//@Repository
//public interface CategoryRepository extends CrudRepository<Category, Long> {
//	List<Category> findAll();
//	List<Category> findAllByProducts(Product product);
//	List<Category> findByProductsNotContains(Product product);
//	List<Category> findCategoryById(Long categoryId);
//	Optional<Category>findByName(String name);
//	Optional<Category>findById(Long id);
//	Optional<Category> findOneById(Long id);
//	Category findByIdIs(Long id);
//	
////    // Retrieves a list of all categories for a particular product
////    List<Category> findAllByProducts(Product product);
////    
////    // Retrieves a list of any categories a particular product
////    // does not belong to.
////    List<Category> findByProductsNotContains(Product product);
//}
