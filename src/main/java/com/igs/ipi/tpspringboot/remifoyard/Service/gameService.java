package com.igs.ipi.tpspringboot.remifoyard.Service;
import org.springframework.stereotype.Service;
import com.igs.ipi.tpspringboot.remifoyard.Model.gameModel;

@Service
public class gameService {
    public gameModel  newGame(){
        gameModel gamemodel = new gameModel();
        gamemodel.setNom1("remi");
        gamemodel.setNom2("julien");
        int tab[][] = {{0,0,0,2,1,2,0},{2,2,1,2,1,0,2},{2,2,0,1,2,1,2},{2,0,2,1,2,1,2},{2,0,2,1,2,1,1},{2,2,0,1,2,1,1}};
        gamemodel.setTab(tab);
        return  gamemodel;
    }
}
