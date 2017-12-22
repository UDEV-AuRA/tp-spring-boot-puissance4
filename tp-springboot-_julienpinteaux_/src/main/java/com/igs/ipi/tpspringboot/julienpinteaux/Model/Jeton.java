package com.igs.ipi.tpspringboot.julienpinteaux.Model;

public enum Jeton {
    ROUGE, JAUNE, VIDE;

    public String getCode() {

        switch (this) {
            case ROUGE:
                return "rouge.png";
            case JAUNE:
                return "bleu.png";
            case VIDE:
                return "vide.png";
            default:
                return null;
        }
    }
}