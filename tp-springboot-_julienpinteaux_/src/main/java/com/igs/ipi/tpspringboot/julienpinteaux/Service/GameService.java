package com.igs.ipi.tpspringboot.julienpinteaux.Service;


import com.igs.ipi.tpspringboot.julienpinteaux.Model.GameModel;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public GameModel newGame(){
        GameModel game1 = new GameModel();
        game1.setNomGamer1("Remi");
        game1.setNomGamer2("Julien");
        Integer tab[][] = new Integer[6][7];
        for (int i = 0 ; i < 6 ; i++){
            for (int o = 0 ; o < 7 ; o++){
                tab[i][o] = 0;
            }
        }
        game1.setTableau(tab);
        return game1;
    }
}
