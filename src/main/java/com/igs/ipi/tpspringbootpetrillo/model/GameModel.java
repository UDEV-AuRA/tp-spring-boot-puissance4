package com.igs.ipi.tpspringbootpetrillo.model;

public class GameModel {

    private static final int LARGEUR = 7;
    private static final int HAUTEUR = 6;

    private String nom1;
    private String nom2;
    private Jeton[][] jetons = new Jeton[HAUTEUR][LARGEUR];

    public GameModel() {
        for (int i = 0; i < jetons.length; i++) {
            for (int j = 0; j < jetons[i].length; j++) {
                jetons[i][j] = Jeton.VIDE;
            }
        }
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

    public Jeton[][] getJetons() {
        return jetons;
    }

    public void setJetons(Jeton[][] jetons) {
        this.jetons = jetons;
    }

    public void add(Integer index) {
        // h=0 est la ligne du haut, on va itérer sur la hateur en sens inverse pour cherche une place libre en bas
        for (int h = jetons.length - 1; h >= 0; h--) {
            if (jetons[h][index] == Jeton.VIDE) {
                jetons[h][index] = Jeton.ROUGE;
                return;
            }
        }
        throw new IllegalArgumentException("Aucune place disponible pour un jeton en index " + index);
    }
}
