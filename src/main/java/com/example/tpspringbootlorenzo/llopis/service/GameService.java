package com.example.tpspringbootlorenzo.llopis.service;
import org.springframework.stereotype.Service;

import com.example.tpspringbootlorenzo.llopis.model.GameModel;
@Service
public class GameService {

	public GameModel newGame() {
		GameModel a = new GameModel();
		a.setNom2("pepito");
		a.setNom1("jose");
		return a ;
	}
}



