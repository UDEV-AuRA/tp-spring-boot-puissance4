package com.igs.ipi.tpspringbootpetrillo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

    @RequestMapping("/game/new")
    public ModelAndView newGame() {
        ModelAndView mv = new ModelAndView("game");
        return mv;
    }
}
