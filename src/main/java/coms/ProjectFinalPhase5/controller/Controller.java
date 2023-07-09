package coms.ProjectFinalPhase5.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	@GetMapping("/")
	public String greet() {
		return "Page";
	}
}
