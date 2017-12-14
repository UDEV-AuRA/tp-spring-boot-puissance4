package com.igs.ipi.tpspringboot.julienpinteaux.Controller;

import com.igs.ipi.tpspringboot.julienpinteaux.Model.GameModel;
import com.igs.ipi.tpspringboot.julienpinteaux.Service.GameService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/new")
    public ModelAndView newGame() {
        GameModel gamer1 = gameService.newGame();
        ModelAndView mav = new ModelAndView("game");
        mav.addObject("gamer1" ,gamer1.getNom());
        return mav;
    }
}