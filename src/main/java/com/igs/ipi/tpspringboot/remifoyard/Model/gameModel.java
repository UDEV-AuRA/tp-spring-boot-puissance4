package com.igs.ipi.tpspringboot.remifoyard.Model;

public class gameModel{
    private String nom1;
    private String nom2;
    private int tab[][] = new int[6][7];

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

    public int[][] getTab() {
        return tab;
    }

    public void setTab(int[][] tab) {
        this.tab = tab;
    }
}
