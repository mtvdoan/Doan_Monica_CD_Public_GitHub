DEPENDENCIES SHOWN SO FAR:

	<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>webjars-locator</artifactId>
        <version>0.30</version>
    </dependency>
    
    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>bootstrap</artifactId>
        <version>5.0.1</version>
    </dependency>
    
    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>jquery</artifactId>
        <version>3.6.0</version>
    </dependency>
    
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>   
    
    
    @Entity: represents an entity model for our application
@Table: sets this as a table in the database
@Id: sets this as the primary key
@GeneratedValue: sets this as an auto-incrementing value
@Size adds validation that the column must be in the specified range
@Min adds validation that the column must be at least the specified value
@NotNull adds validation that the column must be null
@PrePersist runs the method right before the object is created
@PreUpdate runs a method when the object is modified


HOME CONTROLLER NOTES/SAMPLES

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	// ..
//	@RestController
//	@RequestMapping("/hello")
//	@RequestMapping("/greeting")
//	public class HomeController {
//	    @RequestMapping("")
//	    public String index(){
//	      return "This is accessed view http://your_server/simple/root";
//	    }
//	    @RequestMapping("/hello")
//	    public String hello(){
//	      return "Hello world! What route did you use to access me?";
//	    }
//	    @RequestMapping("/goodbye")
//	    public String world(){
//	      return "Goodbye world!";
//	    }
//	}

//Search query
//	@RestController
//	public class HomeController {
//	    @RequestMapping("/")
//	    public String index(@RequestParam(value="q", required=false) String searchQuery) {
//	        return "You searched for: " + searchQuery;
//	    }

//URL-PATH VARIABLES
//	@RestController
//	public class HomeController {
//	    @RequestMapping("/m/{track}/{module}/{lesson}")
//	    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
//	    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
//	    }
//	}

//@Controller
//	@Controller
//	public class HomeController {
//	    
//	 // class definition and imports here...
//	    @RequestMapping("/")
//	    public String index(Model model) {
//	        
//	        String name = "Grace Hopper";
//	        String itemName = "Copper wire";
//	        double price = 5.25;
//	        String description = "Metal strips, also an illustration of nanoseconds.";
//	        String vendor = "Little Things Corner Store";
//	    
//	    	// Your code here! Add values to the view model to be rendered
//	    
//	        return "index.jsp";
//	    }
//	    //...
//	}
	
//Loops-JSTL
	// ...
//    @RequestMapping("/dojos")
//    public String index(Model model) {
//        ArrayList<String> dojos = new ArrayList<String>;
//        dojos.add("Burbank");
//        dojos.add("Chicago");
//        dojos.add("Bellevue");
//        model.addAttribute("dojosFromMyController", dojos);
//        return "index.jsp";
//    }


//Can make an 'item' controller (ex. Fruity Loops)
 // ... imports (Use shift+ctrl+O or shift+cmd+O to import as you code)
//    @Controller
//    public class ItemController {
//        
//        @RequestMapping("/")
//        public String index(Model model) {
//            
//            ArrayList<Item> fruits = new ArrayList<Item>();
//            fruits.add(new Item("Kiwi", 1.5));
//            fruits.add(new Item("Mango", 2.0));
//            fruits.add(new Item("Goji Berries", 4.0));
//            fruits.add(new Item("Guava", .75));
//            
//            // Add fruits your view model here
//            
//            return "index.jsp";
//        }
//    }
//    
//SESSIONS
//    public String index(HttpSession session) {
//        session.setAttribute("count", 0);
//		return "index.jsp";
//	}
    
 //Getting Session Attributes
// 	public String showCount(HttpSession session, Model model) {
// 		Integer currentCount = (Integer) session.getAttribute("count");
// 		model.addAttribute("countToShow", currentCount);
// 		return "showCount.jsp";
// 	}
 
 //Updating Session Attributes
 // ...    
 // ...
// 	public String index(HttpSession session) {
// 		
//     	// If the count is not already in session
// 		if (session.getAttribute("count") == null) {
// 		// Use setAttribute to initialize the count in session
// 		}
// 		else {
// 		// increment the count by 1 using getAttribute and setAttribute
// 		}
// 		return "index.jsp";
// 	}
 
 //Rendering a Form
// 	@Controller
// 	public class MainController {
// 		
// 		@RequestMapping("/")
// 		public String index() {
// 			return "index.jsp";
// 		}
// 	}
//
// 	@RequestMapping("/login")
// 	public String login(
// 		@RequestParam(value="email") String email,
// 	    	@RequestParam(value="password") String password) {
// 	    
// 	    	// CODE TO PROCESS FORM ie. check email and password
// 	    	
// 	    	return "results.jsp"; // <-- we'll change this when we learn redirecting
// 	}
// 	
 	
 	//POST FORM (ex. Login)
// 	@RequestMapping(value="/login", method=RequestMethod.POST)
// 	public String login(
// 	    @RequestParam(value="email") String email,
// 	    @RequestParam(value="password") String password) {
// 	    // CODE TO PROCESS FORM ie. check email and password
// 	    return "redirect:/dashboard";
// 	}
// 	
 	
 	//REDIRECTING
// 	@RequestMapping(value="/processPayment", method=Request.POST)
// 	public String processPayment(
// 	    @RequestParam(value="creditCardNumber") Integer creditCardNumber,
// 	    @RequestParam(value="expDate") Date expDate 
// 	    @RequestParam(value="productID") Integer productID) {
// 	    
// 	    // Code here to get the product price,
// 	    // Call to payment API
// 	    // complete the transaction and charge CC
// 	    System.out.printf("Charging credit, timestamp: %s", new Date());
// 	        
// 	    return "confirmationPage.jsp"; // <-- BAD
// 	    // Refresh the browser and it runs this method again :(
// 	}
//
// 	//REDIRECTING & SESSION
// 	@RequestMapping(value="/processPayment", method=Request.POST)
// 	public String processPayment(
// 	    @RequestParam(value="creditCardNumber") Integer creditCardNumber,
// 	    @RequestParam(value="expDate") Date expDate 
// 	    @RequestParam(value="amount") Double amount {
// 	    
// 	    // Code here to complete the transaction and charge CC
// 	    // ** Put any necessary information in session for later **
// 	        
// 	    return "redirect:/confirm"; // <-- redirects to a /confirm render route.
// 	}

//   @RequestMapping("/confirm")
//   public String confirmationPage(Model model){
//       
       // get any info needed out of session and add to the
       // view model to render on the page.
//           
//       return "confirmation.jsp";
//   }
   //****SHORTCUT FOR @REQUESTMAPPING FOR POST REQUESTS:
	// ...    
//	@PostMapping("/users")
//	public String login() {
//	// ...
//	}

//FLASH DATA (ex. error messages)
//	@Controller
//	public class HomeController {
//		@RequestMapping("/")
//		public String index(Model model) {
//			model.addAttribute("dojoName", "Burbank");
//			return "index.jsp";
//		}
//	 
//		@RequestMapping("/createError")
//		public String flashMessages(RedirectAttributes redirectAttributes) {
//			redirectAttributes.addFlashAttribute("error", "A test error!");
//			return "redirect:/";
//		}
//	}
	
//ERROR HANDLING

//	@Controller
//	public class BooksController {
//	    // other methods removed for brevity
//	    
//	    @GetMapping("/books/new")
//	    public String newBook(@ModelAttribute("book") Book book) {
//	        return "/books/new.jsp";
//	    }
//	    @PostMapping("/books")
//	    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//	        if (result.hasErrors()) {
//	            return "/books/new.jsp";
//	        } else {
//	            bookService.createBook(book);
//	            return "redirect:/books";
//	        }
//	    }
//	}


//DEPENDENCY INJECTION
//	@RequestMapping("/")
//	public String index(Model model) {
//	    model.addAttribute("dojoName", "Burbank");
//	    return "index";
//	}

//SHOWING ALL ITEMS EXAMPLE
	// ... imports removed for brevity
//	@Controller
//	public class BooksController {
//	    private final BookService bookService;
//	    
//	    public BooksController(BookService bookService) {
//	        this.bookService = bookService;
//	    }
//	    
//	    @RequestMapping("/books")
//	    public String index(Model model) {
//	        List<Book> books = bookService.allBooks();
//	        model.addAttribute("books", books);
//	        return "/books/index.jsp";
//	    }
//	}

//CREATING A FORM EXAMPLE:
	// Note: We'll be altering this a bit after we introduce data binding.
//	@PostMapping("/books")
//	public String create(
//	    @RequestParam("title") String title,
//	    @RequestParam("description") String description,
//	    @RequestParam("language") String language,
//	    @RequestParam("pages") Integer pages,) 
//	{
//	    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
//	    Book book = new Book(title, description, language, pages);
//	    bookService.createBook(book);
//	    return "redirect:/dashboard";
//	}


SERVICES NOTES AND SAMPLES
//package com.codingdojo.savetravels.services;
//import java.util.List;
//import java.util.Optional;
//
////...
//import org.springframework.stereotype.Service;
//
//import com.codingdojo.renderingbooksform.models.Book;
//import com.codingdojo.renderingbooksform.repositories.BookRepository;
//@Service
//public class BookService {
// // adding the book repository as a dependency
//    private final BookRepository bookRepository;
//    
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//    // returns all the books
//    public List<Book> allBooks() {
//        return bookRepository.findAll();
//    }
//    // creates a book
//    public Book createBook(Book b) {
//        return bookRepository.save(b);
//    }
//    // retrieves a book
//    public Book findBook(Long id) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if(optionalBook.isPresent()) {
//            return optionalBook.get();
//        } else {
//            return null;
//        }
//    }
//    
//    // updateBook will take in a Book object and save it to our database
//    // our repository will automatically update an existing Book object if their IDs match
//    public Book updateBook(Book book) {
//        return bookRepository.save(book);
//    }
//    
//    // to delete a book, we simply pass in the book ID and if our repository finds it, the book will be deleted
//    public void deleteBook(Long id) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if(optionalBook.isPresent()) {
//            bookRepository.deleteById(id);
//        }
//    }
//    public BookRepository getBookRepository() {
//        return bookRepository;
//    }


MAIN MODEL NOTES AND SAMPLES
//package com.codingdojo.renderingbooksform.models;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.PrePersist;
//import javax.persistence.PreUpdate;
//import javax.persistence.Table;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//import org.springframework.format.annotation.DateTimeFormat;
//@Entity
//@Table(name="books")
//public class Book {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    
//    
//    @NotNull
//    @Size(min = 3, max = 200, message="Title must be at least 3 characters.")    
//    private String title;
//    
//    
//    @NotNull
//    @Size(min = 3, max = 200, message="Description must be at least 3 characters.")    
//    private String description;
//    
//    
//    @NotNull
//    @Size(min = 3, max = 40, message="Language must be at least 3 characters.")
//    private String language;
//    
//    
//    @NotNull(message="Book must be at least 2 pages long.")
//    //Note to self.  Need to put message in the @NotNull section if we are evaluating an integer.
//    @Min(value=2)
//    private Integer numberOfPages;
//    
//
//    @Column(updatable=false)
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private Date createdAt;
//    
//    
//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    private Date updatedAt;
//    
//    public Book() {
//    }
//    
//    public Book(String title, String desc, String lang, int pages) {
//        this.title = title;
//        this.description = desc;
//        this.language = lang;
//        this.numberOfPages = pages;
//    }
//    
//
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//    public String getTitle() {
//        return title;
//    }
//    public void setTitle(String title) {
//        this.title = title;
//    }
//    public String getDescription() {
//        return description;
//    }
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public String getLanguage() {
//        return language;
//    }
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//    public Integer getNumberOfPages() {
//        return numberOfPages;
//    }
//    public void setNumberOfPages(Integer numberOfPages) {
//        this.numberOfPages = numberOfPages;
//    }
//    public Date getCreatedAt() {
//        return createdAt;
//    }
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//    public Date getUpdatedAt() {
//        return updatedAt;
//    }
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//    
//    // other getters and setters removed for brevity
//    @PrePersist
//    protected void onCreate(){
//        this.createdAt = new Date();
//    }
//    @PreUpdate
//    protected void onUpdate(){
//        this.updatedAt = new Date();
//    }


REPOSITORY NOTES & SAMPLES
package com.codingdojo.savetravels.repositories;
//package com.codingdojo.savetravels.repositories;
//
//import java.awt.print.Book;
//import java.util.List;
//
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//public interface SafeTravelsRepository {
//	// ...
//	@Repository
//	public interface BookRepository extends CrudRepository<Book, Long>{
//	    // this method retrieves all the books from the database
//	    List<Book> findAll();
//	    // this method finds books with descriptions containing the search string
//	    List<Book> findByDescriptionContaining(String search);
//	    // this method counts how many titles contain a certain string
//	    Long countByTitleContaining(String search);
//	    // this method deletes a book that starts with a specific title
//	    Long deleteByTitleStartingWith(String search);
//	}

API NOTES & SAMPLES (the API CLASS file goes into the CONTROLLER package)
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




