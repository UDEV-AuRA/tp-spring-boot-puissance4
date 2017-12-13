package com.igs.ipi.tpspringbootpetrillo.controller;

import com.igs.ipi.tpspringbootpetrillo.model.GameModel;
import com.igs.ipi.tpspringbootpetrillo.service.GameService;
import com.igs.ipi.tpspringbootpetrillo.service.PartieEnCours;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

    private GameService gameService;
    private PartieEnCours partieEnCours;

    public GameController(GameService gameService, PartieEnCours partieEnCours) {
        this.gameService = gameService;
        this.partieEnCours = partieEnCours;
    }

    @RequestMapping("/game/new")
    public ModelAndView newGame() {
        ModelAndView mv = new ModelAndView("game");
        GameModel gameModel = gameService.newGame();
        partieEnCours.setGameModel(gameModel);
        mv.addObject("game", gameModel);
        return mv;
    }

    @RequestMapping("/game")
    public ModelAndView game() {
        ModelAndView mv = new ModelAndView("game");
        GameModel gameModel = partieEnCours.getGameModel();
        mv.addObject("game", gameModel);
        return mv;
    }
}
