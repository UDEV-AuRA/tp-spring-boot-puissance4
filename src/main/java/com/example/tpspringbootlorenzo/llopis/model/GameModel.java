package com.example.tpspringbootlorenzo.llopis.model;

public class GameModel {

	private static final int LARGEUR=7;//convention veut que ça soit en maj les constantes de classes
	private static final int HAUTEUR=6;
	private String nom2;
	private String nom1;
	private Jeton[][] piece = new Jeton[HAUTEUR][LARGEUR];
	private boolean tourJ1 = true;


	public GameModel(){
		for(int i=0;i<piece.length;i++){
			for(int j=0;j<piece[i].length;j++){
				piece[i][j]=Jeton.RIEN;

			}
		}
	}

	public void ajout(Integer ref){
		for (int ligne = piece.length - 1; ligne >= 0; ligne--) {
			if (piece[ligne][ref] == Jeton.RIEN) {
				Jeton jeton = tourJ1 ? Jeton.JAUNE : Jeton.BLEU;
				piece[ligne][ref] = jeton;
				tourJ1 = !tourJ1;
				return;
			}
		}
		throw new IllegalArgumentException("Aucune place disponible pour un jeton en index " + ref);
	}

	public Jeton[][] getPiece() {
		return piece;
	}

	public void setPiece(Jeton[][] piece) {
		this.piece = piece;
	}
	public String getNom1() {
		return nom1;
	}
	public void setNom1(String nom1) {
		this.nom1 = nom1;
	}
	public String getNom2() {
		return nom2;
	}
	public void setNom2(String nom2) {
		this.nom2 = nom2;
	}
	public boolean isTourJ1() {
		return tourJ1;
	}

	public void setTourJ1(boolean tourJ1) {
		this.tourJ1 = tourJ1;
	}



}
