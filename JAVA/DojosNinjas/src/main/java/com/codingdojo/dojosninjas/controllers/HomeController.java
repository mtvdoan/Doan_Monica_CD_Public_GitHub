package com.codingdojo.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninjas.models.Dojos;
import com.codingdojo.dojosninjas.models.Ninjas;
import com.codingdojo.dojosninjas.services.DojosServices;
import com.codingdojo.dojosninjas.services.NinjasServices;


@Controller
public class HomeController {
	@Autowired
	private DojosServices dojosServices;
	@Autowired
	private NinjasServices ninjasServices;

	@GetMapping("/")
	public String index(Model model, @ModelAttribute("dojos") Dojos dojos) {
		model.addAttribute("dojos", dojosServices.getAll());
		
		return "index.jsp";
	}
	
	@GetMapping("/createNinjas")
	public String newNinjaForm(@ModelAttribute("newNinja") Ninjas ninjas, Model model) {
		model.addAttribute("dojos", dojosServices.getAll());
		return "createNinjas.jsp";
	}

	@GetMapping("/createDojos")
	public String newDojo(@ModelAttribute("newDojo") Dojos dojos) {
		return "createDojos.jsp";
	}
	
	@GetMapping("/ninjas/{id}/show")
	public String showNinjas(Model model, @PathVariable("id") long id, @ModelAttribute("showNinjas") Ninjas ninjas) {
		model.addAttribute("ninja", ninjasServices.getOne(id));
		return "show.jsp";
	}
	
	@GetMapping("/dojos/{id}/show")
	public String showDojos(Model model, @PathVariable("id") long id, @ModelAttribute("showDojos") Dojos dojos) {
		model.addAttribute("dojo", dojosServices.getOne(id));
		return "show.jsp";
	}
	
	@GetMapping("/createNewNinjas")
	public String createNinjasPage(Model model, @ModelAttribute("newNinja") Ninjas ninjas) {
		model.addAttribute("ninjas", ninjasServices.getAll());
		return "createNinjas.jsp";
	}
	
	@PostMapping("/createNewDojos")
	public String createDojo(Model model, @Valid @ModelAttribute("newDojo") Dojos dojos, BindingResult result) {
		
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojosServices.getAll());

			return "createDojos.jsp";
		} 
		
		else {
			dojosServices.createDojos(dojos);
			return "redirect:/";
		}
	}
	
	@PostMapping("/createNewNinjas")
	public String createNinja(Model model, @Valid @ModelAttribute("newNinja") Ninjas ninjas, BindingResult result) {
		
		if (result.hasErrors()) {
			model.addAttribute("ninjas", ninjasServices.getAll());

			return "createNinjas.jsp";
		} 
		
		else {
			ninjasServices.createNinjas(ninjas);
			return "redirect:/";
		}
	}
	
	
}
