package com.codingdojo.productandcategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.models.Product;
import com.codingdojo.productandcategory.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> AllCategories() {
		return categoryRepository.findAll();
	}
	
	public List<Category> getAssignedProducts(Product product){
		return categoryRepository.findAllByProducts(product);
	}

	public List<Category> getUnassignedProducts(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
	
	public Category findById(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}else {
			return null;
		}
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}
	// updateCategory will take in a Category object and save it to our database.
	// Our repository will automatically update an existing Category object if their
	// IDs match
	public Category updateCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public void deleteCategory(Category category) {
		categoryRepository.delete(category);
	}
	
}

