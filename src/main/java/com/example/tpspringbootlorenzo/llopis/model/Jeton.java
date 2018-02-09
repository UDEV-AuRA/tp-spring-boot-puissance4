package com.example.tpspringbootlorenzo.llopis.model;

public enum Jeton {
    BLEU, JAUNE, RIEN;

    public String getCode() {

        switch (this) {
            case BLEU:
                return "bleu.png";
            case JAUNE:
                return "jaune.png";
            default:
                return null;


        }

    }
}