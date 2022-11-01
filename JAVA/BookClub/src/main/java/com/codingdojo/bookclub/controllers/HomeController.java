package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class HomeController {
    
    @Autowired
    private UserService userServ;
    
    @Autowired
    private BookService bookService;
    
    //Page to Login/Register (index.jsp) 
    @GetMapping("/")
    public String index(Model model) {
        
        // Bind empty User and LoginUser objects to the JSP to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        User user = userServ.register(newUser, result);
        
        // to do some extra validations and create a new user!
        if(result.hasErrors()) {
        	
            // Be sure to send in the empty LoginUser before re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        // No errors! TO-DO Later: Store their ID from the DB in session, 
        session.setAttribute("userId", user.getId());
        
        // in other words, log them in.
        return "redirect:/home";
    }
    
    //When an existing user logs in...
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = userServ.login(newLogin, result);
        
        if(result.hasErrors() || user == null) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        // No errors! TO-DO Later: Store their ID from the DB in session, 
        session.setAttribute("userId", user.getId());
        
        // in other words, log them in.
        return "redirect:/home";
    }
    
    //Shows what the user's home page will look like.  Has all books from db.
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        
        //If no userId is found, redirect to logout.
        if(session.getAttribute("userId") == null) {
            return "redirect:/logout";
        }
        
        model.addAttribute("books", bookService.allBooks());
        model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
        
        return "allBooks.jsp";
    }
    
    //Clears session when user decides to logout.
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.setAttribute("userId", null);
        
        return "redirect:/";
    }

    //Shows page with ONE book's details
    @GetMapping("/show/{bookId}")
    public String show(Model model, @PathVariable("bookId") Long bookId) {
        Book book = bookService.findBook(bookId);
        
        model.addAttribute("book", book);
        
        return "show.jsp";
    }
    
    //Shows page where user can create a new book.
    @GetMapping("/books/new")
    public String newBook(Model model, HttpSession session, @ModelAttribute("newBook") Book book) {
        model.addAttribute("book", bookService.allBooks());
        model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
        
        return "new.jsp";
    }
    
    //Once user creates a book and clicks submit, redirects back to user's home page where new book shows up.
    @PostMapping("/newBook")
    public String create(@Valid @ModelAttribute("newBook") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "new.jsp";
        } 
        
        else {
            bookService.createBook(book);
            return "redirect:/home";
        }
    }
        
    //User clicks book that they want to edit, the 'edit.jsp' will show up.    
    @GetMapping("/books/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id, HttpSession session) {
        model.addAttribute("user", userServ.findById((Long)session.getAttribute("userId")));
        
        if(session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        
        return "edit.jsp";
    }
    
    //Once the user is done editing their book and clicks submit, the page gets rerouted to the user's home page.
    @PutMapping("/books/{id}")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
        
        if (result.hasErrors()) {
            return "editPage.jsp";
        }
        
        bookService.updateBook(book);
        
        return "redirect:/home";
    }
        
        
    @DeleteMapping("/books/{id}")
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/home";
    }
    
    
}

    