package com.example.tpspringbootlorenzo.llopis.controller;

import com.example.tpspringbootlorenzo.llopis.service.GameService;
import com.example.tpspringbootlorenzo.llopis.service.PartieEnCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.tpspringbootlorenzo.llopis.model.GameModel;

@Controller
@RequestMapping("/game")
public class GameController {
	
	private GameModel gameModel;
	private GameService gameService;
	private PartieEnCours partieEnCours;



	@RequestMapping("/new")
	public ModelAndView newGame() {
		ModelAndView nav  = new ModelAndView("game");
		GameModel gameModel=gameService.newGame();
		partieEnCours.setGameModel(gameModel);
		nav.addObject("jeu",gameModel);
		return nav;
	}


	@RequestMapping("")
	public ModelAndView jeuEnCours() {
		ModelAndView nav  = new ModelAndView("game");
		GameModel gameModel=partieEnCours.getGameModel();
		nav.addObject("jeu",gameModel);
		return nav;
	}

	@RequestMapping("/drop/{i}")
	public ModelAndView drop(@PathVariable("i") Integer rangee) {
		ModelAndView nav = new ModelAndView("game");
		GameModel gameModel = partieEnCours.getGameModel();
		int ref = rangee - 1;
		gameModel.ajout(ref);
		nav.addObject("jeu", gameModel);
		return nav;
	}





	public GameController(GameService gameService, PartieEnCours partieEnCours){
		this.gameService=gameService;
		this.partieEnCours=partieEnCours;
	}
}
