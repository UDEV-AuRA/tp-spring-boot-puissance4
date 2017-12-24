package com.igs.ipi.tpspringbootrousselot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.igs.ipi.tpspringbootrousselot.component.PartieEnCours;

import model.GameModel;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameService gameService;  
	
	@GetMapping("/new")
    public ModelAndView newGame() {
		GameModel gm = gameService.newGame(); 
		partieEnCours.setPartieEnCours(gm); 
		// on redirige automatiquement la page de creation du jeu vers la page de jeu 
		ModelAndView mav = new ModelAndView("redirect:/game");
    	mav.addObject("gm", gm);	
        return mav;     
    }
	
	public GameController(GameService gameService, PartieEnCours partieEnCours) {
		super();
		this.gameService = gameService;
		this.partieEnCours = partieEnCours;
	}

	@Autowired
	private PartieEnCours partieEnCours; 
	
	@GetMapping("")
    public ModelAndView Game() {
		GameModel gm2 = partieEnCours.getPartieEnCours(); 
    	ModelAndView mav = new ModelAndView("game"); 
    	mav.addObject("gm", gm2);
    	if (gm2==null) {
    		throw new RuntimeException("Pas de partie en cours. Veuillez d'abord aller sur cette page http://localhost:8080/game/new pour initialiser la partie");
    	}
        return mav;     
    }
	
	@GetMapping("/drop/{i}")
	public ModelAndView drop(@PathVariable("i") Integer Colonne) {
		// on redirige automatiquement la page d ajout d un jeton vers la page du jeu
		ModelAndView mav = new ModelAndView("redirect:/game");
		GameModel gameModel = partieEnCours.getPartieEnCours();
		// la 1er colonne a pour numéro 1, dans le gameModel c'est 0
		int index = Colonne - 1;
		gameModel.addJeton(index);
		mav.addObject("game", gameModel);
		return mav;
	}
	

}
