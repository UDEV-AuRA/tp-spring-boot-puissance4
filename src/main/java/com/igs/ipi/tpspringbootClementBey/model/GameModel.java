package com.igs.ipi.tpspringbootClementBey.model;

public class GameModel {
	
	// propriété de gameModel
	private String nomJoueur1;
	private String nomJoueur2;
	
	private static final int LARGEUR = 7;
	private static final int HAUTEUR = 6;
	
	private Jeton[][] tableauJetons = new Jeton[HAUTEUR][LARGEUR];
	
	// constructeurs
	public GameModel() {
		
		this.nomJoueur1 = "Chuck Norris";
		this.nomJoueur2 = "Vladimir Poutine";
		
		// initialise le tableau avec des jetons type Vide
		for (int i=0; i<tableauJetons.length; i++) {
			for (int j=0; j<tableauJetons[i].length; j++) {
				tableauJetons[i][j] = Jeton.VIDE;
			}
		}
	}
	
	// setters et getters nom1 et 2
	public String getNomJoueur1() {
		return nomJoueur1;
	}
	public void setNomJoueur1(String nomJoueur1) {
		this.nomJoueur1 = nomJoueur1;
	}
	public String getNomJoueur2() {
		return nomJoueur2;
	}
	public void setNomJoueur2(String nomJoueur2) {
		this.nomJoueur2 = nomJoueur2;
	}
	

	
}