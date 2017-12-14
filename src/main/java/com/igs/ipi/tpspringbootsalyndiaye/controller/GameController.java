package com.igs.ipi.tpspringbootsalyndiaye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game")
public class GameController {

	@GetMapping("/new")
	public ModelAndView GetnewGame () {
      ModelAndView mav = new ModelAndView("game");
      return mav; 
		                
		    }
			
			
}
