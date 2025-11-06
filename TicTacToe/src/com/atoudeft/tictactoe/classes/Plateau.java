package com.atoudeft.tictactoe.classes;

import com.atoudeft.tictactoe.MethodeNonImplementeeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class Plateau {
    private final Symbole[][] grille = new Symbole[3][3];
    private int casesRemplies = 0;
    public Symbole get(int ligne, int colonne) { return grille[ligne][colonne]; }
    public boolean estVide(Position p) { return grille[p.getLigne()][p.getColonne()] == null; }
    public int getNombreCasesRemplies() { return casesRemplies; }
    public boolean estPlein() { return casesRemplies == 9; }
    public boolean placer(Coup coup) {
        if (!estVide(coup.getPosition())) {
            return false;
        }
        else {
            Position pos = coup.getPosition();
            grille[pos.getLigne()][pos.getColonne()]=coup.getSymbole();
            GrilleInitiale[pos.getLigne()][pos.getColonne()]= String.valueOf(coup.getSymbole());
            casesRemplies++;
            return true;
        }
    }
    public List<Position> ligneGagnante() {
        Symbole x1, x2, x3;
        int[][][] lignes = {
            {{0,0},{0,1},{0,2}}, {{1,0},{1,1},{1,2}}, {{2,0},{2,1},{2,2}},
            {{0,0},{1,0},{2,0}}, {{0,1},{1,1},{2,1}}, {{0,2},{1,2},{2,2}},
            {{0,0},{1,1},{2,2}}, {{0,2},{1,1},{2,0}}
        };
        for (int i = 0; i<lignes.length;i++) {
            int[][] ligne = lignes[i];

            int l1 = ligne[0][0];
            int col1 = ligne[0][1];
            int l2 = ligne[1][0];
            int col2 = ligne[1][1];
            int l3 = ligne[2][0];
            int col3 = ligne[2][1];

            x1 = grille[l1][col1];
            x2 = grille[l2][col2];
            x3 = grille[l3][col3];

            if (x1 != null && x1.equals(x2) && x2.equals(x3)) {
                List<Position> posGagnante = new ArrayList<>(3);
                posGagnante.add(new Position(l1, col1));
                posGagnante.add(new Position(l2, col2));
                posGagnante.add(new Position(l3, col3));
                return posGagnante;
            }
        }
        return Collections.emptyList();
    }
    private final String[][] GrilleInitiale = new String[3][3]; {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GrilleInitiale[i][j] = ".";
            }
        }
    }

    @Override
    public String toString() {
        return GrilleInitiale[0][0] + " " + GrilleInitiale[0][1]+ " " + GrilleInitiale[0][2] + "\n" +
                GrilleInitiale[1][0] + " " + GrilleInitiale[1][1] + " " + GrilleInitiale[1][2] +"\n" +
                GrilleInitiale[2][0] + " " + GrilleInitiale[2][1] + " " + GrilleInitiale[2][2];
    }
}