package com.igs.ipi.tpspringbootrousselot.controller;

import org.springframework.stereotype.Service;

import model.GameModel;

@Service 
public class GameService {
	
	public GameModel newGame() {
		GameModel gm = new GameModel(); 
		gm.setNom1("Dupond");
		gm.setNom2("Dupont");
		//return new GameModel("Dupont", "Dupond"); 
		return gm; 		
	}


	
	

}
