package com.igs.ipi.tpspringboot.yvesrafaralahy.Model;

public class GameModel {

    private String nomGamer1;
    private String nomGamer2;
    private Integer tableau[][] = new Integer[6][7];
    private Integer tour = 0;
    private String message;
    private String style = "base";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getNomGamer1() {
        return nomGamer1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTour() {
        return tour;
    }

    public void setTour(Integer tour) {
        this.tour = tour;
    }

    public void setNomGamer1(String nomGamer1) {
        this.nomGamer1 = nomGamer1;
    }

    public String getNomGamer2() {
        return nomGamer2;
    }

    public void setNomGamer2(String nomGamer2) {
        this.nomGamer2 = nomGamer2;
    }

    public Integer[][] getTableau() {
        return tableau;
    }

    public void setTableau(Integer[][] tableau) {
        this.tableau = tableau;
    }

    public void ajouter(Integer index){
        for (int i = tableau.length-1 ; i >= 0 ; i--){
            if (this.tableau[i][index] ==0) {
                this.tableau[i][index] =1;
                return;
            }
        }
        tour++;
    }
}
