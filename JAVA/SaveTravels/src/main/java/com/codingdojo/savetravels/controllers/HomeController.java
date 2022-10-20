package com.codingdojo.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.savetravels.models.SaveTravels;
import com.codingdojo.savetravels.services.SaveTravelsServices;

@Controller
public class HomeController {
	@Autowired
	private SaveTravelsServices saveTravelsServices;

	@GetMapping("/")
	
	public String index(Model model, @ModelAttribute("addExpense") SaveTravels saveTravels) {
		model.addAttribute("saveTravels", saveTravelsServices.getAll());
		return "index.jsp";
	}
	
	@GetMapping("/create")
		public String newSaveTravels(@ModelAttribute("addExpense") SaveTravels saveTravels) {

		return "index.jsp";	
	}
	
	@PostMapping("/createSaveTravels")
	public String createSaveTravels(Model model, @Valid @ModelAttribute("addExpense") SaveTravels saveTravels, BindingResult result) {
		
		if (result.hasErrors()) {
			model.addAttribute("saveTravels", saveTravelsServices.getAll());

			return "index.jsp";
		} 
		
		else {
			saveTravelsServices.createSaveTravels(saveTravels);
			return "redirect:/";
		}
	}
	

	
//    @GetMapping("/show/{bookId}")
//    public String show(Model model, 
//            @PathVariable("bookId") Long bookId) {
//        Book book = bookService.findBook(bookId);
//        ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
//        model.addAttribute("book", book);
//
//        return "show.jsp";
//    }
}

//	@GetMapping("/allSaveTravels")
//	public String index(@ModelAttribute("saveTravels") SaveTravels saveTravels, Model model) {
//		SaveTravels savetravels = saveTravelsServ.getOne(id);
//		model.addAttribute("saveTravel", saveTravels);
//		return "index.jsp";
//	}
//	
//	@GetMapping("/saveTravels/{id}")
//	public String viewSaveTravel(@PathVariable(name="id") Long id, Model model) {
//		SaveTravels saveTravels = saveTravelsServices.getOne(id);
//		model.addAttribute("saveTravels", saveTravels);
//		return "viewSaveTravel.jsp";
//	}






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

// Getting Session Attributes
// 	public String showCount(HttpSession session, Model model) {
// 		Integer currentCount = (Integer) session.getAttribute("count");
// 		model.addAttribute("countToShow", currentCount);
// 		return "showCount.jsp";
// 	}

// Updating Session Attributes
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

// Rendering a Form
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

// POST FORM (ex. Login)
// 	@RequestMapping(value="/login", method=RequestMethod.POST)
// 	public String login(
// 	    @RequestParam(value="email") String email,
// 	    @RequestParam(value="password") String password) {
// 	    // CODE TO PROCESS FORM ie. check email and password
// 	    return "redirect:/dashboard";
// 	}
// 	

// REDIRECTING
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
// ****SHORTCUT FOR @REQUESTMAPPING FOR POST REQUESTS:
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

//}
