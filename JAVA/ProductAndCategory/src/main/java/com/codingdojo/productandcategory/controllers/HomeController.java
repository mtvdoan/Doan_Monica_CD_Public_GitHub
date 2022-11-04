package com.codingdojo.productandcategory.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.models.Product;
import com.codingdojo.productandcategory.services.CategoryService;
import com.codingdojo.productandcategory.services.ProductService;

@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String index(Model model) {

		model.addAttribute("products", productService.AllProducts());
 	    model.addAttribute("categories", categoryService.AllCategories());

	    return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(Model model, @ModelAttribute("newproduct") Product product) {
		
		model.addAttribute("products", productService.AllProducts());
	    return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("newproduct") Product product, BindingResult result) {
		if(result.hasErrors()) {
	    	return "newProduct.jsp";
	    }
		productService.addProduct(product);

    	return "redirect:/";
	}

	@GetMapping("/categories/new")
	public String newCategory(Model model, @ModelAttribute("newcategory") Category category) {
		model.addAttribute("categories", categoryService.AllCategories());
	    return "newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("newcategory") Category category, BindingResult result) {
		if(result.hasErrors()) {
	    	return "newCategory.jsp";
	    }
		categoryService.addCategory(category);

    	return "redirect:/";
	}
	
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findById(id);
		model.addAttribute("assignedProducts", productService.getAssignedCategories(category));
		model.addAttribute("unassignedProducts", productService.getUnassignedCategories(category));
		model.addAttribute("category", categoryService.findById(id));
		return "categories.jsp";
	}
	
	@PostMapping("/categories/{id}")
	public String editCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId, Model model) {
		Category category = categoryService.findById(id);
		Product product = productService.findById(productId);
		category.getProducts().add(product);
		categoryService.updateCategory(category);
		model.addAttribute("assignedProducts", productService.getAssignedCategories(category));
		model.addAttribute("unassignedProducts", productService.getUnassignedCategories(category));
		return "redirect:/categories/" + id;
	}
	

	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findById(id);
		model.addAttribute("assignedCategories", categoryService.getAssignedProducts(product));
		model.addAttribute("unassignedCategories", categoryService.getUnassignedProducts(product));
		model.addAttribute("product", product);
		return "products.jsp";
	}
	
	@PostMapping("/products/{id}")
	public String editProduct(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long catId,  Model model) {
		Product product = productService.findById(id);
		Category category = categoryService.findById(catId);
		product.getCategories().add(category);
		productService.updateProduct(product);
		model.addAttribute("assignedCategories", categoryService.getAssignedProducts(product));
		model.addAttribute("unassignedCategories", categoryService.getUnassignedProducts(product));
		return "redirect:/products/" + id;
	}

}