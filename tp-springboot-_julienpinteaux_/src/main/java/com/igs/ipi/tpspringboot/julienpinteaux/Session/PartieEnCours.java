package com.igs.ipi.tpspringboot.julienpinteaux.Session;

import com.igs.ipi.tpspringboot.julienpinteaux.Model.GameModel;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value="session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class PartieEnCours {

    private GameModel game;

    public GameModel getGame() {
        return game;
    }

    public void setGame(GameModel game) {
        this.game = game;
    }
}
