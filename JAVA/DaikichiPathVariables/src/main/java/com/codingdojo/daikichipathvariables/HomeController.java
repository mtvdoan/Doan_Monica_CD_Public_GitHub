package com.codingdojo.daikichipathvariables;

import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	//Have an http GET request to 'http://localhost:8080/daikichi/travel/kyoto' where 
	//the url will take any string for the city, and display text that says for example, 
	//'Congratulations! You will soon travel to kyoto!'.
	@RequestMapping("/travel/{Location}")
	public String travelHonolulu(@PathVariable("Location") String Location) {
		
		String s = Location;
		
		//Capitalize FIRST letter and store just that letter to s1
		String s1 = Location.substring(0, 1).toUpperCase();
		
		//s2 will hold all lowercase letters together as LOWERCASE (originally)
		String s2 = Location.substring(1); 
		
		//Join s1 & s2 :)
		String res = Location.substring(0, 1).toUpperCase() + Location.substring(1); 
		
		return "Congratulations! You will soon travel to " + res;
	}
	
	//TASK: Have an http GET request to 'http://localhost:8080/daikichi/lotto/8', where the url will take any integer. 
	//If the number is even, display text that says 
	//'You will take a grand journey in the near future, but be weary of tempting offers'. 
	//If it is odd, display text that says 
	//"You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends."
	@RequestMapping("/lotto/{lottoNumber}")
	public String lotto(@PathVariable("lottoNumber") int lottoNumber) {
		if(lottoNumber%2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
		
	}
	
}
