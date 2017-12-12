package com.igs.ipi.tpspringbootpetrillo.service;

import com.igs.ipi.tpspringbootpetrillo.model.GameModel;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public GameModel newGame() {
        GameModel gameModel = new GameModel();
        gameModel.setNom1("Gérard");
        gameModel.setNom2("TERA100");
        return gameModel;
    }
}
