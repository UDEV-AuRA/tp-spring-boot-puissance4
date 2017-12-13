package com.igs.ipi.tpspringbootpetrillo.controller;

import com.igs.ipi.tpspringbootpetrillo.model.GameModel;
import com.igs.ipi.tpspringbootpetrillo.service.GameService;
import com.igs.ipi.tpspringbootpetrillo.service.PartieEnCours;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/game/drop/{i}")
    public ModelAndView drop(@PathVariable("i") Integer numColonne) {
        ModelAndView mv = new ModelAndView("game");
        GameModel gameModel = partieEnCours.getGameModel();
        // la 1er colonne a pour numéro 1, dans le gameModel c'est 0
        int index = numColonne - 1;
        gameModel.add(index);
        mv.addObject("game", gameModel);
        return mv;
    }
}
