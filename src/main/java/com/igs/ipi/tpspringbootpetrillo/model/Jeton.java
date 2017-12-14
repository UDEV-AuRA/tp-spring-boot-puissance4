package com.igs.ipi.tpspringbootpetrillo.model;

public enum Jeton {
    ROUGE, JAUNE, VIDE;

    public String getCode() {

        switch (this) {
            case ROUGE:
                return "rouge.png";
            case JAUNE:
                return "bleu.png";
            default:
                return null;
        }
    }
}
