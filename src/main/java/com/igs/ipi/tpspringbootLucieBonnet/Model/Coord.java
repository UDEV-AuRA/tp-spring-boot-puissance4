package com.igs.ipi.tpspringbootLucieBonnet.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Coord {

    public final int x;
    public final int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public List<List<Coord>> getAlignementsPossibles(int nbAAligner, int lengthX, int lengthY) {
        List<List<Coord>> alignements = new ArrayList<>();
        alignements.add(this.variations(nbAAligner - 1, lengthX, lengthY, (decalage) -> this.decalerEnVertical(decalage)));
        alignements.add(this.variations(nbAAligner - 1, lengthX, lengthY, (decalage) -> this.decalerEnHorizontal(decalage)));
        alignements.add(this.variations(nbAAligner - 1, lengthX, lengthY, (decalage) -> this.decalerEnDiagonal(decalage)));
        return alignements;
    }

    private List<Coord> variations(int decalageMax, int lengthX, int lengthY, Function<Integer, Coord> decaleur) {
        List<Coord> coords = new ArrayList<>();
        for (int d = -decalageMax; d < decalageMax; d++) {
            Coord coord = decaleur.apply(d);
            if (coord.isValide(lengthX, lengthY)) {
                coords.add(coord);
            }
        }
        return coords;
    }

    private boolean isValide(int lengthX, int lengthY) {
        return (x >= 0 && x < lengthX) && (y >= 0 && y < lengthY);
    }

    private Coord decalerEnVertical(int decallage) {
        return new Coord(x, y + decallage);
    }

    private Coord decalerEnHorizontal(int decallage) {
        return new Coord(x + decallage, y);
    }

    private Coord decalerEnDiagonal(int decallage) {
        return new Coord(x + decallage, y + decallage);
    }
}
