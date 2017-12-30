package com.igs.ipi.tpspringbootClementBey.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igs.ipi.tpspringbootClementBey.model.GameModel;
import com.igs.ipi.tpspringbootClementBey.service.GameService;

@Controller
public class GameController {
	
	@Autowired
	private GameService gameServ;
	
	@RequestMapping("/game/new")
	public ModelAndView NewGame() {
		GameModel toto = this.gameServ.newGame();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("title","Puissance 4").addObject("toto",toto);
		mav.setViewName("game");
		return mav;
		
	}
}