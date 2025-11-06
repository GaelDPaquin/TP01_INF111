package com.atoudeft.tictactoe.classes;

import com.atoudeft.tictactoe.MethodeNonImplementeeException;

import java.util.List;

public final class Partie {
    private final Plateau plateau = new Plateau();
    private Symbole joueurCourant;
    private StatutPartie statut;

    public Plateau getPlateau()       {
        return plateau;
    }
    public Symbole getJoueurCourant() {
       return joueurCourant;
    }
    public StatutPartie getStatut()   {
        return statut;
    }

    public Partie(Symbole joueurCourant) {
        this.joueurCourant = joueurCourant;
        statut = StatutPartie.EN_COURS;
    }
    public Partie() {
        this(Symbole.X);
    }

    public boolean jouer(Symbole symbole, Position position) {
        throw new MethodeNonImplementeeException("***** Vous n'avez pas encore implemente la methode : "
                +Thread.currentThread().getStackTrace()[1].getMethodName()
                +"() de la classe "+this.getClass().getName());
    }
    public boolean isPartieEnCours() {
        if (statut != StatutPartie.EN_COURS) {
            return false;
        }
        return true;
    }
    private void mettreAJourStatutApresCoup() {
        if (!plateau.ligneGagnante().isEmpty()) {
            List<Position> gagnant = plateau.ligneGagnante();
            Position pos = gagnant.get(0);
            Symbole symboleGagnant = plateau.get(pos.getLigne(),pos.getColonne());
            if(symboleGagnant.equals(Symbole.X)) {
                statut = StatutPartie.X_GAGNE;
            }
            else {
                statut = StatutPartie.O_GAGNE;
            }
        } else if (plateau.ligneGagnante().isEmpty() && plateau.estPlein()) {
            statut = StatutPartie.NULLE;
        }
    }

    @Override
    public String toString() {
        String str = "";
        str = plateau +"\n"
                +"Joueur Courant : " + joueurCourant +"\n"
                +"Etat : " + statut + "\n";
        return str;
    }
}