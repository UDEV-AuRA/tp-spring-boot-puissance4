package com.igs.ipi.tpspringboot.yvesrafaralahy.Controller;

import com.igs.ipi.tpspringboot.yvesrafaralahy.Model.GameModel;
import com.igs.ipi.tpspringboot.yvesrafaralahy.Service.GameService;
import com.igs.ipi.tpspringboot.yvesrafaralahy.Session.PartieEnCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private PartieEnCours partieEnCours;

    @GetMapping
    public ModelAndView continueGame(){
        GameModel game = partieEnCours.getGame();
        ModelAndView mav = new ModelAndView("game");
        mav.addObject("game",game);
        return mav;
    }

    @GetMapping("/new")
    public ModelAndView newGame() {
        GameModel game = gameService.newGame();
        ModelAndView mav = new ModelAndView("game");
        mav.addObject("game",game);
        partieEnCours.setGame(game);
        return mav;
    }

    @GetMapping("/drop/{id}")
    public ModelAndView dropOn(@PathVariable ("id") Integer id) {
        Integer index = id-1;
        ModelAndView mav = new ModelAndView("game");
        GameModel game = partieEnCours.getGame();
        Integer tour = game.getTour();
        tour++;
        if (tour%2 != 0 ) {
            game.setMessage("Au tour de " + game.getNomGamer2());
            game.setStyle("bleu");
        }
        else {
            game.setMessage("Au tour de " + game.getNomGamer1());
            game.setStyle("bleu");
        }

        game.setTour(tour);
        game.ajouter(index);
        partieEnCours.setGame(game);
        mav.addObject("game",game);
        return mav;
    }
}