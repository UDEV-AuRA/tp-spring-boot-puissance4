package com.igs.ipi.tpspringboot.yvesrafaralahy.Service;


import com.igs.ipi.tpspringboot.yvesrafaralahy.Model.GameModel;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public GameModel newGame(){
        GameModel game1 = new GameModel();
        game1.setNomGamer1("PLAYER 1");
        game1.setNomGamer2("PLAYER 2");
        Integer tab[][] = new Integer[6][7];
        for (int i = 0 ; i < 6 ; i++){
            for (int o = 0 ; o < 7 ; o++){
                tab[i][o] = 0;
            }
        }
        game1.setTableau(tab);
        game1.setMessage(game1.getNomGamer1() + ", PLAY!");
        return game1;
    }
}
