package com.igs.ipi.tpspringboot.julienpinteaux.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game")
public class GameController {

    @GetMapping("/new")
    public ModelAndView newGame() {
        ModelAndView mav = new ModelAndView("game.html");
        return mav;
    }
}