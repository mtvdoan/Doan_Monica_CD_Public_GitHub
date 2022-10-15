package com.codingdojo.mvc.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
   
    @GetMapping("/")
    public String index(Model model) {
        ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
        model.addAttribute("monicaBooks", books);
        return "index.jsp";
    }

    @GetMapping("/show/{bookId}")
    public String show(Model model, @PathVariable("bookId") Long bookId) {
        Book book = bookService.findBook(bookId);
        ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
        model.addAttribute("book", book);

        return "show.jsp";
    }
    
}
 