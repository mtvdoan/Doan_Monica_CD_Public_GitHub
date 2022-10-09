package com.codingdojo.hopperreceipt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

@Controller
public class HomeController {
	
	// class definition and imports here...
    @RequestMapping("/")
    public String index(Model model) {
        
        String name = "Grace Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
    
    	// Your code here! Add values to the view model to be rendered
        model.addAttribute("fullName", name);
        model.addAttribute("item", itemName);
        model.addAttribute("cost", price);
        model.addAttribute("details", description);
        model.addAttribute("seller", vendor);
    
        return "index.jsp";
    }
    //...
    


}
