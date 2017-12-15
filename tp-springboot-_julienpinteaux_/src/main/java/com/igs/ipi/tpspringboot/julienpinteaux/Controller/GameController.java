package com.igs.ipi.tpspringboot.julienpinteaux.Controller;

import com.igs.ipi.tpspringboot.julienpinteaux.Model.GameModel;
import com.igs.ipi.tpspringboot.julienpinteaux.Service.GameService;
import com.igs.ipi.tpspringboot.julienpinteaux.Session.PartieEnCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private PartieEnCours partieEnCours;

    @GetMapping("/new")
    public ModelAndView newGame() {
        GameModel game = gameService.newGame();
        ModelAndView mav = new ModelAndView("game");
        mav.addObject("game",game);
        partieEnCours.setGame(game);
        return mav;
    }

    @GetMapping
    public ModelAndView continueGame(){
        GameModel game = partieEnCours.getGame();
        ModelAndView mav = new ModelAndView("game");
        mav.addObject("game",game);
        return mav;
    }

    @GetMapping ("/drop/{i}")
    public ModelAndView dropIn(){
        GameModel game = partieEnCours.getGame();
        ModelAndView mav = new ModelAndView("game");
        mav.addObject("game",game);
        return mav;
    }
}