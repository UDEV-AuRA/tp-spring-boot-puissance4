package com.igs.ipi.tpspringbootClementBey.service;

import org.springframework.stereotype.Service;

import com.igs.ipi.tpspringbootClementBey.model.GameModel;

@Service
public class GameService {
	
	public GameModel newGame() {
		
		GameModel gameMod = new GameModel();
		return gameMod;
		
	}
	
}