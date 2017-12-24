package model;

public class GameModel {
	
	private String nom1; 
	private String nom2;
	private boolean tourJoueur1 = true ;
	private boolean tourJoueur2 = false; 
	public static final int valeurpuissance = 4;
	private int idGagnant = 0;
	
	// ----------------------------------------- getters et setters du gagnant -------------------------------------------------
	public int getIdGagnant() {
		return idGagnant;
	}

	public void setIdGagnant(int idGagnant) {
		this.idGagnant = idGagnant;
	}

	// ----------------------------------------- Constructeurs -------------------------------------------------
	public GameModel(String nom1, String nom2) {
		this.nom1=nom1; 
		this.nom2=nom2;
	}
	
    public GameModel() {
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[i].length; j++) {
            	// initialisation du tableau 
                tableau[i][j] = 0;
            }
        }
        // joueur 1 premier a jouer et joueur 2 deuxieme a jouer
        tourJoueur1=true; 
        tourJoueur2=false; 
}

    // ----------------------------------------- getters et setters de TourJoueur -------------------------------------------------
	public boolean isTourJoueur1() {
		return tourJoueur1;
	}

	public void setTourJoueur1(boolean tourJoueur1) {
		this.tourJoueur1 = tourJoueur1;
	}

	public boolean isTourJoueur2() {
		return tourJoueur2;
	}

	public void setTourJoueur2(boolean tourJoueur2) {
		this.tourJoueur2 = tourJoueur2;
	}
	
	// ----------------------------------------- getters et setters de Nom -------------------------------------------------

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
	
	// ----------------------------------------- definition de notre plateau de jeu -------------------------------------------------
	
	private static final int LARGEUR=7; 
	private static final int HAUTEUR=6; 
	
	public int[][] tableau = new int[HAUTEUR][LARGEUR];
	
	// ----------------------------------------- getter et setter de notre plateau de jeu -------------------------------------------------

	public int[][] getTableau() {
		return tableau;
	}

	public void setTableau(int[][] tableau) {
		this.tableau = tableau;
	} 
	
	// ----------------------------------------- Pour le rajout d un jeton -------------------------------------------------
	
	public void addJeton(Integer index) {
		// verification de l etat de la partie 
		if (idGagnant != 0) {
			throw new IllegalStateException("La partie est terminée. Veuillez en recommencer une nouvelle svp");
		}
		// h=0 est la ligne du haut, on va itérer sur la hateur en sens inverse pour cherche une place libre en bas
		for (int h = tableau.length - 1; h >= 0; h--) {
			if (tableau[h][index] == 0) {
				// Joueur 1 = rouge = 1
				// Joueur 2 = jaune = 2 
				// pas de jeton = vide = 0
				if (tourJoueur1==true) {
					tableau[h][index] = 1;
					tourJoueur1=false;
					tourJoueur2=true; 
					}
				else if (tourJoueur2==true) {
					tableau[h][index] = 2;
					tourJoueur2=false;
					tourJoueur1=true; 
					}
				else {
					System.out.println("Oops, quelque chose n'est pas correct, vous ne devriez pas avoir ce message");
					}
				checkWinnerHorizontal();
				checkWinnerVertical();
				checkWinnerDiagonalDroite();  
				checkWinnerDiagonalGauche();
				return;
			}
		}
		throw new IllegalArgumentException("La colonne " + index+ " est déjà pleine. Veuillez en choisir une autre svp");
		}

	// i = hauteur
	// j = largeur 
	// verification en horizontal 
	public int checkWinnerHorizontal() {
		int colorstart = 0; 
		int colorcurrent = 0;
		int compteur=0; 
        for (int i = 0; i < tableau.length; i++) {
        	compteur=0;    	
        	colorstart=tableau[i][0];
            for (int j = 0; j < tableau[i].length; j++) {
            	// on ne verifie que si la valeur n'est pas égale à 0 (case vide)
            	if (tableau[i][j]!=0) {   		
            		colorcurrent=tableau[i][j];
            		if (colorstart==colorcurrent) {
            			compteur=compteur+1; 
            			System.out.println(compteur);
            			if (compteur==4 && colorstart!=0) {
            				return this.idGagnant=colorstart; 
            			}
            		} 
            		else {
            			compteur=1;
            			colorstart=colorcurrent;
            		}
                }
            }
        }
        return idGagnant;
	}
	
	// verification en vertical 
	public int checkWinnerVertical() {
		int colorstart = 0; 
		int colorcurrent = 0;
		int compteur=0; 
        for (int i = 0; i < tableau[0].length; i++) {   
        	compteur=0;    	
        	colorstart=tableau[0][i];
            for (int j = 0; j < tableau.length; j++) {
            	// on ne verifie que si la valeur n'est pas égale à 0 (case vide)
            	if (tableau[j][i]!=0) {   		
            		colorcurrent=tableau[j][i];
            		if (colorstart==colorcurrent) {
            			compteur=compteur+1; 
            			System.out.println(compteur);
            			if (compteur==4 && colorstart!=0) {
            				return this.idGagnant=colorstart; 
            			}
            		} 
            		else {
            			compteur=1;
            			colorstart=colorcurrent;
            		}
                }
            }
        }
        return idGagnant;
	}
	
	// verification diagonale droite 
		public int checkWinnerDiagonalDroite() {
			int colorstart = 0; 
			int colorcurrent = 0;
			int compteur=0; 
	        for (int i = 0; i < tableau.length-valeurpuissance+1; i++) {	
	            for (int j = 0; j < tableau[i].length-valeurpuissance+1; j++) {
	            	// on ne verifie que si la valeur n'est pas égale à 0 (case vide)
	            	if (tableau[i][j]!=0) {  
	            		colorstart=tableau[i][j];
	            		compteur=1; 
	            		for (int k = 1; k<valeurpuissance; k++) {
	            			colorcurrent=tableau[i+k][j+k];
	            			if (colorstart==colorcurrent) {
	            				compteur=compteur+1; 
	            				System.out.println(compteur);
	            				if (compteur==4 && colorstart!=0) {
	            					return this.idGagnant=colorstart; 
	            				}
	            			} 
	            			else {
	            				compteur=1;
	            				colorstart=colorcurrent;
	            			}
	            		}
	                }
	            }
	        }
	        return idGagnant;
		}
		
	// verification diagonale gauche
		public int checkWinnerDiagonalGauche() {
			int colorstart = 0; 
			int colorcurrent = 0;
			int compteur=0; 
			for (int i = 0; i < tableau.length-valeurpuissance+1; i++) {		
				for (int j = tableau[i].length-1; j >=valeurpuissance-1; j--) {
					System.out.println(j);
					// on ne verifie que si la valeur n'est pas égale à 0 (case vide)
					if (tableau[i][j]!=0) {  
						colorstart=tableau[i][j];
						compteur=1; 
						for (int k = 1; k<valeurpuissance; k++) { 
							colorcurrent=tableau[i+k][j-k];
							if (colorstart==colorcurrent) {
								compteur=compteur+1; 
								System.out.println(compteur);
								if (compteur==4 && colorstart!=0) {
									return this.idGagnant=colorstart; 
									}
								} 
							else {
								compteur=1;
								colorstart=colorcurrent;
								}
							}
						}
					}
				}
			return idGagnant;
			}

}
