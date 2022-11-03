package com.codingdojo.productandcategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.models.Product;
import com.codingdojo.productandcategory.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> AllProducts() {
        return productRepository.findAll();
    }
    public List<Product> getAssignedCategories(Category category){
    	return productRepository.findAllByCategories(category);
    }
    
    public List<Product> getUnassignedCategories(Category category){
    	return productRepository.findByCategoriesNotContains(category);
    }

    // retrieves a product
    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }

    public Product addProduct(Product product) {
    	return productRepository.save(product);
    }
    
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
    
    // to delete a product, we simply pass in the product ID and if our repository finds it, the product will be deleted
    public void deleteProduct(Product product) {
    	productRepository.delete(product);
    }
    
    public ProductRepository getProductRepository() {
        return productRepository;
    }

}