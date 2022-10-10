
//Don't forget to change package name.
package com.codingdojo.templatespringstarter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
// New import needed!
import org.springframework.ui.Model;
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
    //Put member variables here: 
    	//example:
    	String name = "Monica";
    	//		double price = 2.25;
    	
    	
    // Your code here! Add values to the view model to be rendered	
    	
        model.addAttribute("name", name);
        //Remember the yellow needs to MATCH THE MEMBER VARIABLE ABOVE.
        return "index.jsp";
    }
}


