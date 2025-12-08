package com.chat.tictactoe;

public class EtatPartieTicTacToe {
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
        //à compléter

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
