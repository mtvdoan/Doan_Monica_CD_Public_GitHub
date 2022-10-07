package com.codingdojo.hellohuman;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
   
    @RequestMapping("/")
    public String name(
        @RequestParam(value = "name", required = false) String name, 
        @RequestParam(value  ="lastname", required = false) String lastname,
        @RequestParam(value = "times", required = false) int times) { 
     
        //http://localhost:8080/
        if(times == 0) {
            times = 1; 
        }
        
        if(name == null || lastname == null || times == 0) {
            return "Hello Human";
        }
        else{
            String x = "";
            //http://localhost:8080/?name=Monica&lastname=Doan&times=3
            String entry1 = ("Hello " + name + " " + lastname + ". ");
            for(int i = 1; i <= times; i ++) {
                x += entry1;
            }

            return x;
        }        
    }
}
    
