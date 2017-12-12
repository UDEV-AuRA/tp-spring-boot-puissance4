package com.igs.ipi.tpspringbootpetrillo.controller;

import com.igs.ipi.tpspringbootpetrillo.model.GameModel;
import com.igs.ipi.tpspringbootpetrillo.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping("/game/new")
    public ModelAndView newGame() {
        ModelAndView mv = new ModelAndView("game");
        GameModel gameModel = gameService.newGame();
        mv.addObject("game", gameModel);
        return mv;
    }
}
