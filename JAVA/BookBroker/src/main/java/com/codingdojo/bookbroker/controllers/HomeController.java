package com.codingdojo.bookbroker.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookbroker.models.Book;
import com.codingdojo.bookbroker.models.LoginUser;
import com.codingdojo.bookbroker.models.User;
import com.codingdojo.bookbroker.services.BookService;
import com.codingdojo.bookbroker.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	//View login/registration page
	@GetMapping("/")
	public String index(Model model) {
	 
	    // Bind empty User and LoginUser objects to the JSP to capture the form input
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new LoginUser());
	    
	    return "index.jsp";
	}
	
	//After user fills out information to register and confirms, this will direct the page to view their welcome page with allbooks (allBooks.jsp)
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		User user = userService.register(newUser, result);
		
	    if(result.hasErrors()) {
	    	
	        // Be sure to send in the empty LoginUser before re-rendering the page.
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/bookmarket";
	}
	
	//After user logs in, this will direct the page to view their welcome page with all books (allBooks.jsp)
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		User user = userService.login(newLogin, result);
		
		//If there is no such user...
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "index.jsp";
	    }
	    //If the login is successful...You get logged in.
	    session.setAttribute("userId", user.getId());
	 
	    return "redirect:/bookmarket";
	}

	//For logout/clear session button
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	 
		// Set userId to null and redirect to login/register page
		session.setAttribute("userId", null);
	     
	    return "redirect:/";
	}
	

	//When user clicks on ONE book to view.
	@GetMapping("/books/{id}")
	public String showOneBook(@PathVariable("id") Long id, HttpSession session, Model model) {
	 
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("user", userService.findById(userId));
	     
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
	     
	    return "show.jsp";
	}
	
	//When user clicks on a book that they own to edit...
	@GetMapping("/books/edit/{id}")
	public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {	
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		 
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "edit.jsp";
	}
	
	//When a user finishes editing the book...
	@PutMapping("/books/edit/{id}")
	public String update(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("book") Book book, 
			BindingResult result, 
			HttpSession session) {	
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		 
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
			bookService.updateBook(book);
			return "redirect:/bookmarket";
		}
	}
	
	//Shows a button to "create a new book" for user to click 
	@GetMapping("/new")
	public String addBook(Model model, @ModelAttribute("newbook") Book book, HttpSession session) {
        model.addAttribute("book", bookService.allBooks());
        model.addAttribute("user", userService.findById((Long)session.getAttribute("userId")));
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		return "new.jsp";
	}
	
	//User clicks this button once they are done creating their book post.
	@PostMapping("/newbook")
	public String addBook(@Valid @ModelAttribute("newbook") Book book, BindingResult result, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/logout";
		}
	    if(result.hasErrors()) {
	    	return "new.jsp";
	    }
	    else {
	    	bookService.addBook(new Book(book.getTitle(), book.getAuthor(), book.getThoughts(), userService.findById(userId)));
	    	return "redirect:/bookmarket";
	    }
	}
	
	//Shows delete button on the 'allBooks.jsp'.  If statement are in 'allBooks.jsp'...
	@RequestMapping("/books/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, HttpSession session) {
		 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
    	 
    	bookService.deleteBook(bookService.findBook(id));
    	 
    	return "redirect:/bookmarket";
	}
	
	//Shows all BORROWED AND UNBORROWED books in a signed in user's page.  
	@GetMapping("/bookmarket")
	public String bookmarket(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/logout";
		}
		
		model.addAttribute("user", userService.findById(userId));

		//List of books NOT borrowed by user.  Able to be borrowed by displaying a 'borrow' button
		List<Book> books = bookService.unborrowedBooks(userService.findById(userId));
		model.addAttribute("books", books);

		//List of borrowed books under 'myBooks' methodAttribute.  Need to use ${myBooks} to call from jsp.
		List<Book> myBooks = bookService.borrowedBooks(userService.findById(userId));
		model.addAttribute("myBooks", myBooks);
		 
		return "allBooks.jsp";
	}
	
	//When user clicks on 'borrow' button, the user's id number gets ADDED to the Book's db 'borrower_id' column
	@RequestMapping("/bookmarket/{bookID}")
	public String borrowBook(@PathVariable("bookID") Long bookID, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/logout";
		}
		bookService.addBorrower(bookService.findBook(bookID), userService.findById(userId));
		 
		return "redirect:/bookmarket";
	}
	
	//When user clicks on 'borrow' button, the user's id number gets REMOVED to the Book's db 'borrower_id' column
	@RequestMapping("/bookmarket/return/{bookID}")
	public String returnBook(@PathVariable("bookID") Long bookID, HttpSession session) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		bookService.removeBorrower(bookService.findBook(bookID));
		 
		return "redirect:/bookmarket";
	}
	
}