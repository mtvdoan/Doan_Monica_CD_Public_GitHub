package com.codingdojo.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/gold", method = { RequestMethod.GET, RequestMethod.POST })
	public String index(
			HttpSession session, 
			Model model, 
			@RequestParam(value="farm", required=false) String farm,
			@RequestParam(value="cave", required=false) String cave,
			@RequestParam(value="house", required=false) String house,
			@RequestParam(value="quest", required=false) String quest,
			@RequestParam(value="spa", required=false) String spa
			) {
		
		SimpleDateFormat format = new SimpleDateFormat("MMMM d Y h:mm a");
		
		Integer gold = 0;
		ArrayList<String> actions = new ArrayList<>();
		
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("actions", actions);
		}else {
			gold = (Integer) session.getAttribute("gold");
			actions = (ArrayList<String>) session.getAttribute("actions");
			session.setAttribute("actions", actions);
		}
		
		if(gold < -50) {
			return "redirect:/prison";
		}
		
		if(farm != null) {
			//returns number between 0-20
			Integer amount = new Random().nextInt(21);
			gold += amount;
					
			session.setAttribute("gold", gold);
			actions.add(0, "You entered a farm and earned " + amount + " gold. (" + format.format(new Date()) + ")");

			return "redirect:/gold";
		}
		
		if(cave != null) {
			Integer amount = new Random().nextInt(21);
			gold += amount;
			
			session.setAttribute("gold", gold);
			actions.add(0, "You entered a cave and earned " + amount + " gold. (" + format.format(new Date()) + ")");
			
			return "redirect:/gold";
		}
		
		if(house != null) {
			Integer amount = new Random().nextInt(21);	
			gold += amount;
			
			session.setAttribute("gold", gold);
			actions.add(0, "You entered a house and earned " + amount + " gold. (" + format.format(new Date()) + ")");
			
			return "redirect:/gold";
		}
		
		if(quest != null) {
			Integer amount = new Random().nextInt(101) - 50;
			gold += amount;
			
			session.setAttribute("gold", gold);
			if(amount<0) {
				actions.add(0, "You failed the quest and lost " + (amount * -1) + " gold. (" + format.format(new Date()) + ")");
			}else {
				actions.add(0, "You completed the quest and earned " + amount + " gold. (" + format.format(new Date()) + ")");
			}
			
			return "redirect:/gold";
		}
		
		// BONUS
		if(spa != null) {
			Integer amount = new Random().nextInt(16) + 5;
			gold -= amount;
			
			session.setAttribute("gold", gold);
			actions.add(0, "You entered a spa and lost " + amount + " gold. (" + format.format(new Date()) + ")");
			
			return "redirect:/gold";
		}
		
		return "index.jsp";
	}
	
	// BONUS
	@RequestMapping(value = "/reset", method = { RequestMethod.GET, RequestMethod.POST })
	public String reset(HttpSession session) {
		
		session.setAttribute("gold", 0);
		session.setAttribute("actions", new ArrayList<String>());
		
		return "redirect:/gold";
	}
	
	// BONUS
	@RequestMapping("/prison")
	public String prison() {		
		return "prison.jsp";
	}

}