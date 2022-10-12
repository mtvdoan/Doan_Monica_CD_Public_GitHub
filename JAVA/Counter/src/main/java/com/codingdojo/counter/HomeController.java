
//Don't forget to change package name.
package com.codingdojo.counter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
// New import needed!
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class HomeController {
	

	@RequestMapping("/")
	public String index(HttpSession session) {
		
    	// If the count is not already in session
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount += 1; 
			session.setAttribute("count", currentCount);
		}
		return "index.jsp";
	}

	
	@RequestMapping("/counter")
	public String showCount(HttpSession session, Model model, HttpServletRequest request) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		
		String homeUrl = request.getRequestURL().toString();
		model.addAttribute("page", homeUrl.substring(0,homeUrl.length()-9)); 
		
		return "counter.jsp";
	}
	
	@RequestMapping("/reset-counter/")
	public String resetCounter(HttpSession session, Model model) {
		
		session.setAttribute("count", 0);

		return "redirect:/counter/";
	}
	
	@RequestMapping("/doublecounter")
	public String showDoubleCount(HttpSession session, Model model, HttpServletRequest request) {
		if (session.getAttribute("count2") == null) {
			session.setAttribute("count2", 0);
		}
		else {
			Integer currentCount2 = (Integer) session.getAttribute("count2");
			currentCount2 += 2;
			//NOTE: THIS currentCount REFLECTS THE PREVIOUS VISIT from method above.
			//adds 1 to the previous currentCount so it increments by a total of two.
			session.setAttribute("count2", currentCount2);
		}
		
		Integer currentCount2 = (Integer) session.getAttribute("count2");
		model.addAttribute("doubleCountToShow", currentCount2);
		
		String homeUrl = request.getRequestURL().toString();
		model.addAttribute("page", homeUrl.substring(0,homeUrl.length()-14)); 
		
		return "doublecounter.jsp";
	}
	
	@RequestMapping("/reset-doublecounter/")
	public String resetDoubleCounter(HttpSession session, Model model) {
		
		session.setAttribute("count2", -2);

		return "redirect:/doublecounter/";
	}
	
}


