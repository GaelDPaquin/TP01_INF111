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
        String[] t = strCoup.split(" ");
        if (t.length < 3)
            return res;
        if (!t[0].equalsIgnoreCase("X") || t[0].equalsIgnoreCase("O"))
            return res;
        try {
            int i = Integer.parseInt(t[1]);
            int j = Integer.parseInt(t[2]);
            if (etatPlateau[i][j] !=' ')
                return res;
            etatPlateau[i][j] = t[0].charAt(0);
            notifierObservateurs();
            return true;

        }
        catch (Exception exc) {
            System.out.println("Mauvaise saisie");
        }
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
