
//Don't forget to change package name.
package com.codingdojo.templatespringstarter;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {
// ...    
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	// ...
	@RequestMapping("/login")
	public String login(
		@RequestParam(value="email") String email,
    	@RequestParam(value="password") String password,
		HttpSession session)	
	{
	session.setAttribute("email", email);
    
    	// CODE TO PROCESS FORM ie. check email and password
    	//return "welcome.jsp" <--changed to the one below
    	return "redirect:/home"; 
	}
	
	@RequestMapping("/home")
	public String home() {
		return "welcome.jsp";
	}
	
	// ...
	// ...
	@RequestMapping(value="/processPayment")
	public String processPayment(
	    @RequestParam(value="creditCardNumber") Integer creditCardNumber,
	    @RequestParam(value="expDate") Date expDate, 
	    @RequestParam(value="amount") Double amount ){
	    
	    // Code here to complete the transaction and charge CC
	    // ** Put any necessary information in session for later **
	        
	    return "redirect:/confirm"; // <-- redirects to a /confirm render route.
	}
	
	// ...
	@RequestMapping("/confirm")
	public String confirmationPage(Model model){
	    
	    // get any info needed out of session and add to the
	    // view model to render on the page.
	    model.addAttribute(model);
	    return "confirmationPage.jsp";
	}

}


