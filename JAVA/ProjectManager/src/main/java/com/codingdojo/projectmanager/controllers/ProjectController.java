package com.codingdojo.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.services.ProjectService;
import com.codingdojo.projectmanager.services.UserService;

@Controller
public class ProjectController {
 
	 // Add once service is implemented:
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
  
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("newproject") Project project, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		return "newproject.jsp";
	}
	
	@PostMapping("/projects/new")
	public String addNewProject(@Valid @ModelAttribute("newproject") Project project, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		if(result.hasErrors()) {
			return "newproject.jsp";
		}else {
			User user = userService.findById(userId);
			Project newProject = new Project(project.getTitle(), project.getDescription(), project.getDueDate(), project.getLead());
			newProject.setLead(user);
			projectService.addProject(newProject);
			user.getProjects().add(newProject);
			userService.updateUser(user);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/projects/edit/{id}")
	public String editProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Project project = projectService.findById(id);
		model.addAttribute("project", project);
		return "editproject.jsp";
	}
	
	@PostMapping("/projects/edit/{id}")
	public String updateEditedProject(@PathVariable("id") Long id, @Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findById(userId);
		
		if(result.hasErrors()) {
			return "editproject.jsp";
		}else {
			Project thisProject = projectService.findById(id);
			project.setUsers(thisProject.getUsers());
			project.setLead(user);
		
			projectService.updateProject(project);
			
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/projects/{id}")
	public String projectDetails(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Project project = projectService.findById(id);
		model.addAttribute("project", project);
		return "projectdetails.jsp";
	}
	

	
	@RequestMapping("/dashboard/join/{id}")
	public String joinTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		Project project = projectService.findById(id);
		User user = userService.findById(userId);
		
		user.getProjects().add(project);
		userService.updateUser(user);
		
		model.addAttribute("user", userService.findById(userId));
		model.addAttribute("unassignedProjects", projectService.getUnassignedUsers(user));
		model.addAttribute("assignedProjects", projectService.getAssignedUsers(user));
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/dashboard/leave/{id}")
	public String leaveTeam(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		Project project = projectService.findById(id);
		User user = userService.findById(userId);
		
		//remove function is a part of built in crud
		user.getProjects().remove(project);
		userService.updateUser(user);
		
		model.addAttribute("user", userService.findById(userId));
		model.addAttribute("unassignedProjects", projectService.getUnassignedUsers(user));
		model.addAttribute("assignedProjects", projectService.getAssignedUsers(user));
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/projects/delete/{id}")
	public String deleteProject(@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");
		
		User user = userService.findById(userId);
		
		Project project = projectService.findById(id);

		projectService.deleteProject(project);
		model.addAttribute("unassignedProjects", projectService.getUnassignedUsers(user));
		model.addAttribute("assignedProjects", projectService.getAssignedUsers(user));
		return "redirect:/dashboard";
	}
}