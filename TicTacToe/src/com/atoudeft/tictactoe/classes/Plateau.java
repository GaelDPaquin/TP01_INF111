package com.atoudeft.tictactoe.classes;

import com.atoudeft.tictactoe.MethodeNonImplementeeException;

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
            return true;
        }
    }
    public List<Position> ligneGagnante() {
        int[][][] lignes = {
            {{0,0},{0,1},{0,2}}, {{1,0},{1,1},{1,2}}, {{2,0},{2,1},{2,2}},
            {{0,0},{1,0},{2,0}}, {{0,1},{1,1},{2,1}}, {{0,2},{1,2},{2,2}},
            {{0,0},{1,1},{2,2}}, {{0,2},{1,1},{2,0}}
        };
        throw new MethodeNonImplementeeException("***** Vous n'avez pas encore implemente la methode : "
                +Thread.currentThread().getStackTrace()[1].getMethodName()
                +"() de la classe "+this.getClass().getName());
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