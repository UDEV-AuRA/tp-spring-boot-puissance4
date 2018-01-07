package com.igs.ipi.tpspringbootLucieBonnet.Controller;

import com.igs.ipi.tpspringbootLucieBonnet.Model.GameModel;
import com.igs.ipi.tpspringbootLucieBonnet.Service.GameService;
import com.igs.ipi.tpspringbootLucieBonnet.Service.PartieEnCours;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class GameController {

    //injection GameService
    private GameService gameService;

    //injection bean PartieEnCours
    private PartieEnCours partieEnCours;

    //constructeur GameController, construction avec GameService, PartieEnCours
    public GameController(GameService gameService, PartieEnCours partieEnCours){
        this.gameService = gameService;
        this.partieEnCours = partieEnCours;
    }

    //vue a utiliser
    @RequestMapping("/game/new")
    public ModelAndView newGame(){
        ModelAndView viewGame = new ModelAndView("game");
        viewGame.setViewName("game");
        viewGame.addObject("title","New game");

        GameModel gameModel = gameService.newGame();
        partieEnCours.setGameModel(gameModel);
        viewGame.addObject("game", gameModel);

        return viewGame;
    }

    //méthode pour gérer la session
    @RequestMapping("/game")
    public ModelAndView game(){
        ModelAndView viewGame = new ModelAndView("game");
        viewGame.setViewName("game");
        viewGame.addObject("title","Game");

        GameModel gameModel = partieEnCours.getGameModel();
        viewGame.addObject("game", gameModel);

        return viewGame;
    }

    //méthode ajout de jeton
    @RequestMapping("/game/drop/{i}")
    public ModelAndView drop(@PathVariable("i") Integer numColonne){
        ModelAndView viewGame = new ModelAndView("game");
        viewGame.addObject("title","Game");

        GameModel gameModel = partieEnCours.getGameModel();

        int index = numColonne - 1;
        gameModel.add(index);
        viewGame.addObject("game",gameModel);

        return viewGame;
    }
}
