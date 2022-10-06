package com.codingdojo.daikichiroutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/daikichi")
public class HomeController {
	
	//TASK: Have an http GET request to 'http://localhost:8080/daikichi' display text that says 'Welcome!'
	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}
	
	//TASK: Have an http GET request to 'http://localhost:8080/daikichi/today' display text that says 
	//'Today you will find luck in all your endeavors!'
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	//TASK: Have an http GET request to 'http://localhost:8080/daikichi/tomorrow' display text that says 
	//'Tomorrow, an opportunity will arise, so be sure to be open to new ideas!'
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
}
