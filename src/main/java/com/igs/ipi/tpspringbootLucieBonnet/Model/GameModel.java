package com.igs.ipi.tpspringbootLucieBonnet.Model;

// infos de la partie

import java.util.List;

public class GameModel {

    // constantes du plateau de jeu
    private static final int LARGEUR = 7;
    private static final int HAUTEUR = 6;
    public static final int NB_A_ALIGNER = 4;

    // attributs
    private String joueur1;
    private String joueur2;
    private Jeton[][] jetons = new Jeton[HAUTEUR][LARGEUR];
    private boolean tourJoueur1;

    private int numJoueurGagnant;

    // constructeur
    public GameModel(){
        for(int i = 0; i < jetons.length; i++) {
            for (int j = 0; j < jetons[i].length; j++) {
                jetons[i][j] = Jeton.VIDE;
            }
        }
        //après construction du plateau, le premier tour commence
        tourJoueur1 = true;
    }

    // Getter Setter
    public void setJoueur1(String joueur1) {
        this.joueur1 = joueur1;
    }

    public void setJoueur2(String joueur2) {
        this.joueur2 = joueur2;
    }

    public String getJoueur1() {
        return joueur1;
    }

    public String getJoueur2() {
        return joueur2;
    }

    public Jeton[][] getJetons() {
        return jetons;
    }

    public void setJetons(Jeton[][] jetons) {
        this.jetons = jetons;
    }

    public boolean isTourJoueur1() {
        return tourJoueur1;
    }

    public void setTourJoueur1(boolean tourJoueur1) {
        this.tourJoueur1 = tourJoueur1;
    }

    public int getNumJoueurGagnant() {
        return numJoueurGagnant;
    }


    // méthode add
    public void add(Integer index) {
        if (numJoueurGagnant != 0){
            throw new IllegalArgumentException("La partie est déjà finie.");
        }
        for (int h = jetons.length - 1; h >=0; h--){
            if(jetons[h][index] == Jeton.VIDE){
                Jeton jeton = tourJoueur1 ? Jeton.JAUNE : Jeton.ROUGE;
                jetons[h][index] = jeton;
                boolean coupGagnant = isCoupGagnant(index, h);
                if(coupGagnant){
                    numJoueurGagnant = tourJoueur1 ? 1 :2;
                }
                tourJoueur1 = !tourJoueur1;
                return;
            }
        }
        throw new IllegalArgumentException("Il n'y pas de place pour un jeton ici.");
    }

    private boolean isCoupGagnant(int x, int y){
        Jeton jeton = jetons[x][y];
        Coord init = new Coord(x,y);
        List<List<Coord>> alignementsPossibles = init.getAlignementsPossibles(NB_A_ALIGNER, LARGEUR, HAUTEUR);
        for (List<Coord> alignement : alignementsPossibles){
            int nbAlignes = 0;

            for (Coord c : alignement){

                if(jetons[c.y][c.x] == jeton){
                    nbAlignes++;
                } else {
                    nbAlignes = 0;
                }

                if(nbAlignes == NB_A_ALIGNER){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isJoueur1Gagnant(){
        return numJoueurGagnant == 1;
    }

    public boolean isJoueur2Gagnant(){
        return numJoueurGagnant == 2;
    }

}