package com.codingdojo.savetravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	
	@GetMapping("/saveTravels/{id}/show")
	public String show(Model model, @PathVariable("id") long id, @ModelAttribute("show") SaveTravels savetravels) {
		model.addAttribute("viewExpense", saveTravelsServices.getOne(id));
		return "show.jsp";
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
	
	
	@GetMapping("/saveTravels/{id}/edit")
	public String edit(Model model, @PathVariable("id") long id, @ModelAttribute("editExpense") SaveTravels saveTravels) {
		model.addAttribute("editExpense", saveTravelsServices.getOne(id));
		
		return "edit.jsp";	
	}
	
	@PutMapping("/saveTravels/{id}")
	public String editExpense(Model model, @Valid @ModelAttribute("editExpense") SaveTravels saveTravels, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} 
		
		else {
			saveTravelsServices.updateSaveTravels(saveTravels);
			return "redirect:/";
		}
	}
	
    @GetMapping("/saveTravels/{id}/delete")
    public String deleteSaveTravels(@PathVariable("id") Long id) {
        saveTravelsServices.deleteSaveTravels(id);
        return "redirect:/";
    }

}