//
//package com.codingdojo.savetravels.controllers;
//import java.util.List;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.codingdojo.savetravels.models.SaveTravels;
//import com.codingdojo.savetravels.services.SaveTravelsServices;
//
//public class SaveTravelsApi{
//	
//	private final SaveTravelsServices saveTravelsServices;
//	
//	public SaveTravelsApi(SaveTravelsServices saveTravelsServices){
//		this.saveTravelsServices = saveTravelsServices;
//	}
//	 @RequestMapping("/api/saveTravels")
//	 public List<saveTravels> index() {
//	     return saveTravelsServices.allSaveTravels();
//	 }
//	 
//	 @RequestMapping(value="/api/saveTravels", method=RequestMethod.POST)
//	 public SaveTravels createExpense(
//		 @RequestParam(value="expenseName") String expenseName, 
//		 @RequestParam(value="vendor") String vendor, 
//		 @RequestParam(value="amount") Double amount, 
//		 @RequestParam(value="description") String description) {
//		 SaveTravels saveTravels = new SaveTravels(expenseName, vendor, amount, description);
//
//		 
//		 SaveTravels updatedSaveTravels = saveTravelsServices.updateSaveTravels(saveTravels);
//		 
//	 return saveTravelsServices.createSaveTravels(saveTravels);
//
//	 }
//	 
//	 @RequestMapping(value="/api/saveTravels/{id}", method=RequestMethod.PUT)
//	 // first we get the Book ID from our path, we then get the title, description, language, and pages values
//	 public SaveTravels update(	 
//			 
//			 @RequestParam(value="expenseName") String expenseName, 
//			 @RequestParam(value="vendor") String vendor, 
//			 @RequestParam(value="amount") Double amount, 
//			 @RequestParam(value="description") String description) {
//		 
//			SaveTravels saveTravels = new SaveTravels(expenseName, vendor, amount, description);
//	     
//	     // we then set the ID of the new Book object to equal the ID of the Book we are updating
//	     saveTravels.setId(id);
//	     
//	     SaveTravels updateSaveTravels = saveTravelsServices.updateSaveTravels(saveTravels);
//	     return updateSaveTravels;
//	 }
//	 
//	 @RequestMapping(value="/api/saveTravels/{id}", method=RequestMethod.DELETE)
//	 public void destroy(@PathVariable("id") Long id) {
//	     saveTravelsServices.deleteSaveTravels(id);
//	 }
//    
//}
//



//package com.codingdojo.savetravels.controllers;
//
//import java.awt.print.Book;
//import java.util.List;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//public class SaveTravelsApi {
//
//    private final BookService bookService;
//    public BooksApi(BookService bookService){
//        this.bookService = bookService;
//    }
//    @RequestMapping("/api/books")
//    public List<Book> index() {
//        return bookService.allBooks();
//    }
//    
//    @RequestMapping(value="/api/books", method=RequestMethod.POST)
//    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//        Book book = new Book(title, desc, lang, numOfPages);
//        return bookService.createBook(book);
//    }
//    
//    @RequestMapping("/api/books/{id}")
//    public Book show(@PathVariable("id") Long id) {
//        Book book = bookService.findBook(id);
//        return book;
//    }

//ADDING UPDATE & DELETE
// ..
//
//    private final BookService bookService;
//    public BooksApi(BookService bookService){
//        this.bookService = bookService;
//    }
//    // other methods removed for brevity
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
//    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//        Book book = bookService.updateBook(id, title, desc, lang, numOfPages);
//        return book;
//    }
//    
//    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
//    public void destroy(@PathVariable("id") Long id) {
//        bookService.deleteBook(id);
//    }
//}

//}
