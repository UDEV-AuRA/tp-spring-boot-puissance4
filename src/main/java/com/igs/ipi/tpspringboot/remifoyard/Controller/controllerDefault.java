package com.igs.ipi.tpspringboot.remifoyard.Controller;

import com.igs.ipi.tpspringboot.remifoyard.Component.PartieEnCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.igs.ipi.tpspringboot.remifoyard.Service.gameService;
import com.igs.ipi.tpspringboot.remifoyard.Model.gameModel;

@Controller
@RequestMapping("/game")
public class controllerDefault {
    @Autowired
    private gameService gameservice;

    @Autowired
    private PartieEnCours partiencours;

    @GetMapping("/new")
    public ModelAndView newGame(){
        ModelAndView mav  = new ModelAndView("game");
        gameModel game = gameservice.newGame();
        mav.addObject("game",game);
        partiencours.setGamemodel(game);
        return mav;
    }

    @GetMapping
    public ModelAndView continueGame(){
        ModelAndView mav  = new ModelAndView("game");
        gameModel game = partiencours.getGamemodel();
        mav.addObject("game",game);
        return mav;
    }
}
