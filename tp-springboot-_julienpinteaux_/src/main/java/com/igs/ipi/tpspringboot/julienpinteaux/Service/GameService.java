package com.igs.ipi.tpspringboot.julienpinteaux.Service;


import com.igs.ipi.tpspringboot.julienpinteaux.Model.GameModel;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public GameModel newGame(){
        GameModel game1 = new GameModel();
        game1.setNom("Remi");
        return game1;
    }

    public GameModel newGame2(){
        GameModel game2 = new GameModel();
        game2.setNom("Julien");
        return game2;
    }

}
