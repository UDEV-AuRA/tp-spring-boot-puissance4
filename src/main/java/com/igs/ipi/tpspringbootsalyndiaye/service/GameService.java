package com.igs.ipi.tpspringbootsalyndiaye.service;

import org.springframework.stereotype.Service;

import com.igs.ipi.tpspringbootsalyndiaye.modele.GameModele;

@Service
public class GameService {

	public GameModele newGame() {
	 GameModele gameModele = new GameModele("Udev1", "Udev2");
	 return gameModele;
	}

	

	
}
