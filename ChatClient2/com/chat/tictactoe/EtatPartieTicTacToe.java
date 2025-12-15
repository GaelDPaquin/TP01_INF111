package com.chat.tictactoe;

import observer.Observable;


public class EtatPartieTicTacToe extends Observable {
    private char[][] etatPlateau = new char[3][3];

    public EtatPartieTicTacToe() {
        etatPlateau = new char[][]{
                {'.','.','.'},
                {'.','.','.'},
                {'.','.','.'}
        };
    }
    public boolean coup(String strCoup) {
        boolean res = false;
        int ligne, colonne;
        String[] t = strCoup.split(" ");
        if (t.length != 3)
            return res;

        ligne = Integer.parseInt(t[1]);
        colonne = Integer.parseInt(t[2]);

        if (ligne > 2 || colonne > 2 || ligne < 0 || colonne < 0)
            return res;

        if (etatPlateau[ligne][colonne] != '.')
            return res;

        etatPlateau[ligne][colonne] = t[0].charAt(0);
        notifierObservateurs();
        res = true;
        return res;

    }

    @Override
    public String toString() {
        String s = "";
        for (byte i=0;i<etatPlateau.length;i++) {
            for (int j=0;j<etatPlateau[i].length;j++)
                s+=etatPlateau[i][j]+" ";
            s+="\n";
        }
        return s;
    }

    public char[][] getEtatPlateau() {
        return etatPlateau;
    }

    public void setEtatPlateau(char[][] etatPlateau) {
        this.etatPlateau = etatPlateau;
    }
}
