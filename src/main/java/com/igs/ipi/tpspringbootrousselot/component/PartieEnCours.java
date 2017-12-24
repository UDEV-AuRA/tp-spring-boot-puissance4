package com.igs.ipi.tpspringbootrousselot.component;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import model.GameModel;

@Component 
//@SessionScope
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PartieEnCours {
	
	public GameModel partieEnCours; 
	
	public PartieEnCours() {
	}

	public GameModel getPartieEnCours() {
		return partieEnCours;
	}

	public void setPartieEnCours(GameModel partieEnCours) {
		this.partieEnCours = partieEnCours;
	}
	
	
}
