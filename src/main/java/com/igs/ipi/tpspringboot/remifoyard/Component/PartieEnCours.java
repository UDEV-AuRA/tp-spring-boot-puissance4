package com.igs.ipi.tpspringboot.remifoyard.Component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import com.igs.ipi.tpspringboot.remifoyard.Model.gameModel;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PartieEnCours {
    private gameModel gamemodel;

    public gameModel getGamemodel() {
        return gamemodel;
    }

    public void setGamemodel(gameModel gamemodel) {
        this.gamemodel = gamemodel;
    }
}
