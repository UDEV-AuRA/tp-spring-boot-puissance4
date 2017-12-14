package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class GameController {

	@GetMapping("http://localhost:8080/game/new") 
	public ModelAndView newGame() {
		 ModelAndView nav  = new ModelAndView("game");
		 
		return nav;
	}
}
