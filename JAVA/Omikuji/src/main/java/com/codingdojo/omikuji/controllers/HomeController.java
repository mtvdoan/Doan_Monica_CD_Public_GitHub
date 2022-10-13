
//Don't forget to change package name.
package com.codingdojo.omikuji.controllers;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {
	

	@GetMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	
	@GetMapping("/omikuji")
	public String omikuji() {
		return "index.jsp";
		
	}
	@GetMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		
		String result = (String) session.getAttribute("omikujiResults");
		model.addAttribute("result", result);
		
		return "showomikuji.jsp";
	}
	
	@PostMapping("/processomikuji")
	public String processForm(
		@RequestParam("number") int number,
		@RequestParam("city") String city,
    	@RequestParam("person") String person,
    	@RequestParam("hobby") String hobby,
    	@RequestParam("living") String living,
    	@RequestParam("message") String message,
		HttpSession session) {	
	
		String omikujiResults = String.format(
			"In %s years you will live in %s with %s as your roommate, %s. The next time you see a %s, you will have good luck. Also, %s.",
			number, city, person, hobby, living, message);
		session.setAttribute("omikujiResults", omikujiResults);
    	return "redirect:/omikuji/show"; 
	}

}


