package com.springDemo.mycoolapp.rest;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}
	@GetMapping("/workout")
	public String getDailyWorkout(){
		return "welcom to gym";
	}
	@GetMapping("/fortune")
	public String getFortune(){
		return "You got to fulfill all the dreams u have";
	}
}











