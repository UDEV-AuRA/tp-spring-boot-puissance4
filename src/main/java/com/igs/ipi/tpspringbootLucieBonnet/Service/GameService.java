package com.igs.ipi.tpspringbootLucieBonnet.Service;

import com.igs.ipi.tpspringbootLucieBonnet.Model.GameModel;
import org.springframework.stereotype.Service;


@Service
public class GameService {

    // constructeur de GameService
    public GameService(){

    }

    // methode newGame retourne instance de GameModel contenant nom des joueurs
    public GameModel newGame(){
        GameModel gameModel = new GameModel();
        gameModel.setJoueur1("Toto");
        gameModel.setJoueur2("Jojo");
        return gameModel;
    }
}
