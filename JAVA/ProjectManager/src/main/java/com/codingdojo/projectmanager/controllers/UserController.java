package com.codingdojo.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.projectmanager.models.LoginUser;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.services.ProjectService;
import com.codingdojo.projectmanager.services.UserService;

@Controller
public class UserController {
 
 // Add once service is implemented:
@Autowired
private UserService userService;

@Autowired
private ProjectService projectService;
  
	@GetMapping("/")
	public String index(Model model) {
	 
	     // Bind empty User and LoginUser objects to the JSP
	     // to capture the form input
	     model.addAttribute("newUser", new User());
	
	     model.addAttribute("newLogin", new LoginUser());
	     return "index.jsp";
	 }
 

	 @PostMapping("/register")
	 public String register(
			 @Valid @ModelAttribute("newUser") User newUser, 
	         BindingResult result, 
	         Model model, 
	         HttpSession session) {
     
     // TO-DO Later -- call a register method in the service 
	 User user = userService.register(newUser, result);
     // to do some extra validations and create a new user!
     
     if(result.hasErrors()) {
         // Be sure to send in the empty LoginUser before 
         // re-rendering the page.
         model.addAttribute("newLogin", new LoginUser());
         return "index.jsp";
     }
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     session.setAttribute("userId", user.getId());
     // in other words, log them in.
 
     return "redirect:/dashboard";
	 }
 
	 @PostMapping("/login")
	 public String login
	 	(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	 	BindingResult result, 
	 	Model model, 
	 	HttpSession session) {
		 
	     // Add once service is implemented:
	     User user = userService.login(newLogin, result);
	 
	     if(result.hasErrors() || user == null) {
	         model.addAttribute("newUser", new User());
	         return "index.jsp";
	     }
	     // No errors! 
	     // TO-DO Later: Store their ID from the DB in session, 
	     session.setAttribute("userId", user.getId());
	     // in other words, log them in.
	 
	     return "redirect:/dashboard";
 		}
 
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
	 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		model.addAttribute("user", userService.findById(userId));
		model.addAttribute("unassignedProjects", projectService.getUnassignedUsers(userService.findById(userId)));
		model.addAttribute("assignedProjects", projectService.getAssignedUsers(userService.findById(userId)));
		 
		return "dashboard.jsp";
	}

	@GetMapping("/logout")
	 	public String logout(HttpSession session) {
	 
	 	// TO-DO - Reject values or register if no errors:
	 
	 // Reject if email is taken (present in database)
		// Reject if password doesn't match confirmation
		session.setAttribute("userId", null);
	
		return "redirect:/";
	 }

}