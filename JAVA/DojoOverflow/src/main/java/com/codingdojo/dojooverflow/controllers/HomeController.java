package com.codingdojo.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

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

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

@Controller
public class HomeController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private TagService tagService;
	
	@GetMapping("/")
	public String welcome(Model model) {

		
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Question> questions = questionService.AllQuestions();
		List<Tag> tags = tagService.AllTags();
		
		model.addAttribute("questions", questions);
		model.addAttribute("tags", tags);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question, Model model) {
		
		List<Tag> tags = tagService.AllTags();
		model.addAttribute("tags", tags);
		return "newquestion.jsp";
		
	}
	
	@PostMapping("/questions/new")
	public String addNewQuestion(
			@Valid @ModelAttribute("question") Question question, 
			BindingResult result,
			@RequestParam(value="listOfTags") String listOfTags,
			Model model) {
		List<Tag> tags = tagService.AllTags();
		model.addAttribute("tags", tags);
		if(result.hasErrors()) {
			return "newquestion.jsp";
		}else {
			List<Tag> questionTags = checkTags(listOfTags);
			if(questionTags!=null) {	
				Question newQuestion = new Question(question.getText());
				newQuestion.setTags(questionTags);
				questionService.addQuestion(newQuestion);
			}else {
				model.addAttribute("errorMsg", "You can only enter up to three tags (all lowercase and separated by a comma)");
				return "newquestion.jsp";
			}

			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/answers/{id}")
	public String newAnswer(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		Question question = questionService.findById(id);
		model.addAttribute("question", question);
		return "newanswer.jsp";
	}
	
	@PostMapping("/answers/{id}")
	public String addNewAnswer(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("answer") Answer answer, 
			BindingResult result,
			Model model) {
		Question question = questionService.findById(id);
		model.addAttribute("question", question);
		if(result.hasErrors()) {
			return "newanswer.jsp";
		}else {
			Answer newAnswer = new Answer(answer.getText());
			newAnswer.setQuestion(question);
			answerService.addAnswer(newAnswer);
			return "redirect:/answers/"+id;
		}	
	}
	
	private List<Tag> checkTags(String tagsString){
		// Create a List of Strings using the 'tagsString' String, which contains the tags the user has entered
		String[] splitTags = tagsString.trim().split(",");
		// Create a new ArrayList that we will populate with individual Tag objects
		ArrayList<Tag> tempTags = new ArrayList<>();
		
		// If we find more than 3 tags, we return null because we can only have up to 3 tags
		if(splitTags.length>3) {
			return null;
		}
		
		// Using a for loop, we iterate through the 'splitTags' and create new Tag objects for each one that does not exist in our database
		for(String s: splitTags) {
			// First we remove spaces before and after the tag String and convert the tag to all lower case characters
			s = s.trim().toLowerCase();
			// We make sure the Tag object does not exist and that the tag String is at least one character long
			if(tagService.findBySubject(s)==null && s.length()>0) {
				// If the Tag object is not found, we add a new Tag object to our tempTags ArrayList (which will then add it to our database later)
				tempTags.add(new Tag(s));
			}else {
				// If the object is found, we simply add it to the tempTags ArrayList
				tempTags.add(tagService.findBySubject(s));
			}
			
		}

		// Once we pass the tags to our question, it will add all new Tag objects to our database, 
		// pull existing Tag objects we have found, then add those Tag objects to the question
		// This happens on line 71 - 'newQuestion.setTags(questionTags);'
		return tempTags;
	}
	

////	@GetMapping("/product/{id}")
////	public String product(@PathVariable("id") Long ProductId, Model model) {
////		Product product = productService.findProduct(ProductId);
////		model.addAttribute("product", product);
////	    
////		return "product.jsp";
////	}
////	
////	@GetMapping("/category/{id}")
////	public String category(@PathVariable("id") Long CategoryId, Model model) {
////		Category category = categoryService.findCategory(CategoryId);
////		model.addAttribute("category", category);
////	    
////		return "categor.jsp";
////	}
////	
//	@GetMapping("/categories/{id}")
//	public String showCategory(@PathVariable("id") Long id, Model model) {
//		Category category = categoryService.findById(id);
//		model.addAttribute("assignedProducts", productService.getAssignedCategories(category));
//		model.addAttribute("unassignedProducts", productService.getUnassignedCategories(category));
//		model.addAttribute("category", categoryService.findById(id));
//		return "categories.jsp";
//	}
//	
//	@PostMapping("/categories/{id}")
//	public String editCategory(@PathVariable("id") Long id, @RequestParam(value="productId") Long productId, Model model) {
//		Category category = categoryService.findById(id);
//		Product product = productService.findById(productId);
//		category.getProducts().add(product);
//		categoryService.updateCategory(category);
//		model.addAttribute("assignedProducts", productService.getAssignedCategories(category));
//		model.addAttribute("unassignedProducts", productService.getUnassignedCategories(category));
//		return "redirect:/categories/" + id;
//	}
//	
//
//	@GetMapping("/questions/{id}")
//	public String showProduct(@PathVariable("id") Long id, Model model) {
//		Product product = productService.findById(id);
//		model.addAttribute("assignedCategories", categoryService.getAssignedProducts(product));
//		model.addAttribute("unassignedCategories", categoryService.getUnassignedProducts(product));
//		model.addAttribute("product", product);
//		return "questions.jsp";
//	}
//	
//	@PostMapping("/questions/{id}")
//	public String editProduct(@PathVariable("id") Long id, @RequestParam(value="categoryId") Long catId,  Model model) {
//		Product product = productService.findById(id);
//		Category category = categoryService.findById(catId);
//		product.getCategories().add(category);
//		productService.updateProduct(product);
//		model.addAttribute("assignedCategories", categoryService.getAssignedProducts(product));
//		model.addAttribute("unassignedCategories", categoryService.getUnassignedProducts(product));
//		return "redirect:/questions/" + id;
//	}
//	
//	
////	//After user fills out information to register and confirms, this will direct the page to view their welcome page with allbooks (allBooks.jsp)
////	@PostMapping("/register")
////	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
////		User user = userService.register(newUser, result);
////		
////	    if(result.hasErrors()) {
////	    	
////	        // Be sure to send in the empty LoginUser before re-rendering the page.
////	        model.addAttribute("newLogin", new LoginUser());
////	        return "index.jsp";
////	    }
////	    session.setAttribute("userId", user.getId());
////	 
////	    return "redirect:/bookmarket";
////	}
////	
////	//After user logs in, this will direct the page to view their welcome page with all books (allBooks.jsp)
////	@PostMapping("/login")
////	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
////		User user = userService.login(newLogin, result);
////		
////		//If there is no such user...
////	    if(result.hasErrors() || user==null) {
////	        model.addAttribute("newUser", new User());
////	        return "index.jsp";
////	    }
////	    //If the login is successful...You get logged in.
////	    session.setAttribute("userId", user.getId());
////	 
////	    return "redirect:/bookmarket";
////	}
////
////	//For logout/clear session button
////	@GetMapping("/logout")
////	public String logout(HttpSession session) {
////	 
////		// Set userId to null and redirect to login/register page
////		session.setAttribute("userId", null);
////	     
////	    return "redirect:/";
////	}
////	
////
////	//When user clicks on ONE book to view.
////	@GetMapping("/books/{id}")
////	public String showOneBook(@PathVariable("id") Long id, HttpSession session, Model model) {
////	 
////		Long userId = (Long) session.getAttribute("userId");
////		if(userId == null) {
////			return "redirect:/logout";
////		}
////		
////		model.addAttribute("user", userService.findById(userId));
////	     
////		Product product = productService.findProduct(id);
////		model.addAttribute("book", product);
////	     
////	    return "show.jsp";
////	}
////	
////	//When user clicks on a book that they own to edit...
////	@GetMapping("/books/edit/{id}")
////	public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {	
////		
////		if(session.getAttribute("userId") == null) {
////			return "redirect:/logout";
////		}
////		 
////		Product product = productService.findProduct(id);
////		model.addAttribute("book", product);
////		return "edit.jsp";
////	}
////	
////	//When a user finishes editing the book...
////	@PutMapping("/books/edit/{id}")
////	public String update(
////			@PathVariable("id") Long id,
////			@Valid @ModelAttribute("book") Product product, 
////			BindingResult result, 
////			HttpSession session) {	
////		
////		if(session.getAttribute("userId") == null) {
////			return "redirect:/logout";
////		}
////		 
////		if(result.hasErrors()) {
////			return "edit.jsp";
////		}else {
////			productService.updateProduct(product);
////			return "redirect:/bookmarket";
////		}
////	}
////	
////	//Shows a button to "create a new book" for user to click 
////	@GetMapping("/new")
////	public String addProduct(Model model, @ModelAttribute("newbook") Product product, HttpSession session) {
////        model.addAttribute("book", productService.allProducts());
////        model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
////		if(session.getAttribute("userId") == null) {
////			return "redirect:/logout";
////		}
////		
////		return "new.jsp";
////	}
////	
////	//User clicks this button once they are done creating their book post.
////	@PostMapping("/newbook")
////	public String addProduct(@Valid @ModelAttribute("newbook") Product product, BindingResult result, HttpSession session) {
////		Long userId = (Long) session.getAttribute("userId");
////		if(userId == null) {
////			return "redirect:/logout";
////		}
////	    if(result.hasErrors()) {
////	    	return "new.jsp";
////	    }
////	    else {
////	    	productService.addProduct(new Product(product.getTitle(), product.getAuthor(), product.getThoughts(), userService.findById(userId)));
////	    	return "redirect:/bookmarket";
////	    }
////	}
////	
////	//Shows delete button on the 'allBooks.jsp'.  If statement are in 'allBooks.jsp'...
////	@RequestMapping("/books/delete/{id}")
////	public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
////		 
////		if(session.getAttribute("userId") == null) {
////			return "redirect:/logout";
////		}
////    	 
////    	productService.deleteProduct(productService.findProduct(id));
////    	 
////    	return "redirect:/bookmarket";
////	}
////	
////	//Shows all BORROWED AND UNBORROWED books in a signed in user's page.  
////	@GetMapping("/bookmarket")
////	public String bookmarket(HttpSession session, Model model) {
////		Long userId = (Long) session.getAttribute("userId");
////		
////		if(userId == null) {
////			return "redirect:/logout";
////		}
////		
////		model.addAttribute("user", userService.findById(userId));
////
////		//List of books NOT borrowed by user.  Able to be borrowed by displaying a 'borrow' button
////		List<Product> questions = productService.unborrowedProducts(userService.findById(userId));
////		model.addAttribute("books", questions);
////
////		//List of borrowed books under 'myBooks' methodAttribute.  Need to use ${myBooks} to call from jsp.
////		List<Product> myProducts = productService.borrowedProducts(userService.findById(userId));
////		model.addAttribute("myBooks", myProducts);
////		 
////		return "allBooks.jsp";
////	}
////	
////	//When user clicks on 'borrow' button, the user's id number gets ADDED to the Product's db 'borrower_id' column
////	@RequestMapping("/bookmarket/{bookID}")
////	public String borrowBook(@PathVariable("bookID") Long bookID, HttpSession session) {
////		Long userId = (Long) session.getAttribute("userId");
////		
////		if(userId == null) {
////			return "redirect:/logout";
////		}
////		productService.addBorrower(productService.findProduct(bookID), userService.findById(userId));
////		 
////		return "redirect:/bookmarket";
////	}
////	
////	//When user clicks on 'borrow' button, the user's id number gets REMOVED to the Product's db 'borrower_id' column
////	@RequestMapping("/bookmarket/return/{bookID}")
////	public String returnBook(@PathVariable("bookID") Long bookID, HttpSession session) {
////	 
////		if(session.getAttribute("userId") == null) {
////			return "redirect:/logout";
////		}
////		productService.removeBorrower(productService.findProduct(bookID));
////		 
////		return "redirect:/bookmarket";
////	}
//	
}