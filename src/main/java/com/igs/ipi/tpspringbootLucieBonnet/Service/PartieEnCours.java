package com.igs.ipi.tpspringbootLucieBonnet.Service;

import com.igs.ipi.tpspringbootLucieBonnet.Model.GameModel;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PartieEnCours {

    // propriété GameModel
    private GameModel gameModel;

    //Getter Setter
    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }
}
