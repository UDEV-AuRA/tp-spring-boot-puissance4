package com.igs.ipi.tpspringboot.yvesrafaralahy.Model;

public enum Jeton {
    RED, BLUE, EMPTY;

    public String getCode() {

        switch (this) {
            case RED:
                return "rouge.png";
            case BLUE:
                return "bleu.png";
            case EMPTY:
                return "vide.png";
            default:
                return null;
        }
    }
}