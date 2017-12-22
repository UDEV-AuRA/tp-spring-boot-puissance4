package com.igs.ipi.tpspringbootsalyndiaye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igs.ipi.tpspringbootsalyndiaye.modele.GameModele;
import com.igs.ipi.tpspringbootsalyndiaye.service.GameService;

import Session.PartieEnCours;

@Controller
@RequestMapping("/game")
public class GameController {
	
	
	@Autowired
	private GameService gameService;
	
	@Autowired
	private PartieEnCours partieEnCours;
	
	public GameController(GameService gameService) {
		
	}
	
	public GameController(GameService gameService, PartieEnCours partieEnCours) {
		this.gameService = gameService;
		this.partieEnCours = partieEnCours;
	}
	
	
	@GetMapping("/new")
	public ModelAndView SetnewGame () {
    GameModele gameModele = gameService.newGame();
    partieEnCours.setGameModele(gameModele);
    ModelAndView mav = new ModelAndView("game");
    mav.addObject("gameModele", gameModele); 
    return mav; 
		                
		    }
	
	@GetMapping("/game")
	public ModelAndView GetnewGame () {
    GameModele gameModele = gameService.newGame();
    partieEnCours.getGameModele(gameModele);
    ModelAndView mav = new ModelAndView("game");
    mav.addObject("gameModele", gameModele); 
    return mav; 
		              
		    }
	
	@GetMapping("/game/drop/{i}")
	public ModelAndView drop(@PathVariable("i") Integer numColonne) {
	ModelAndView mav = new ModelAndView("game");
	GameModel gameModel = partieEnCours.getGameModele();
	int index = numColonne - 1;
	gameModel.add(index);
	mav.addObject("gameModele", gameModele); 
	return mav; 
		                
		    }
	
}
