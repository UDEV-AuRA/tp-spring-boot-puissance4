package com.igs.ipi.tpspringbootsalyndiaye.modele;

public class GameModele{
	public String Joueur1;
	public String Joueur2;
	private boolean tourJoueur1;

	public String getJoueur1() {
		return Joueur1;
	}

	public void setJoueur1(String joueur1) {
		Joueur1 = joueur1;
	}

	public String getJoueur2() {
		return Joueur2;
	}

	public void setJoueur2(String joueur2) {
		Joueur2 = joueur2;
	}
	
	public GameModele(String Joueur1, String Joueur2) {
		this.Joueur1=Joueur1;
		this.Joueur2=Joueur2;
	}
	
	private static final int largeur = 7;
	private static final int hauteur = 6;
	private final static int VIDE = 0;
	private final static int JAUNE = 1;
	private final static int ROUGE = 2;
	
	public static int getVide() {
		return VIDE;
	}

	public static int getJaune() {
		return JAUNE;
	}

	public static int getRouge() {
		return ROUGE;
	}

	public int[][] getTableau() {
		return tableau;
	}

	public void setTableau(int[][] tableau) {
		this.tableau = tableau;
	}

	public static int getLargeur() {
		return largeur;
	}

	public static int getHauteur() {
		return hauteur;
	}

	public Jeton[][] jetons = new Jeton [hauteur][largeur];
	
	
	public GameModele() {
		         for (int i = 0; i < jetons.length; i++) {
		             for (int j = 0; j < jetons[i].length; j++) {
		                 jetons[i][j] = jeton.VIDE;
		             }
		         }tourJoueur1 = true;
		         
	        }

	public void add(Integer index) {
		for (int l = tableaux.length - 1; l >= 0; l--) {
			if (jetons[l][index] == Jeton.VIDE) {
				//tableau[l][index] = tableau.ROUGE;
				Jeton jeton = tourJoueur1 ? Jeton.ROUGE : Jeton.JAUNE;
				jetons [l][index] = jeton;
				tourJoueur1 = !tourJoueur1;
				return;
		  }
		}
	throw new IllegalArgumentException("Aucune place disponible pour un jeton en index " + index);

	}
	public boolean isTourJoueur1(){
		return tourJoueur1;
	}

}
