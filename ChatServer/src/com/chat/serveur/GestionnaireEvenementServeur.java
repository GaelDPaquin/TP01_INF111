package com.chat.serveur;

import com.commun.evenement.Evenement;
import com.commun.evenement.GestionnaireEvenement;
import com.commun.net.Connexion;

import java.util.ArrayList;

/**
 * Cette classe représente un gestionnaire d’événement d’un serveur. Lorsqu’un serveur reçoit un texte d’un client,
 * il crée un événement à partir du texte reçu et alerte ce gestionnaire qui réagit en gérant l’événement.
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-09-01
 */
public class GestionnaireEvenementServeur implements GestionnaireEvenement {
    private Serveur serveur;

    /**
     * Construit un gestionnaire d’événements pour un serveur.
     *
     * @param serveur Serveur Le serveur pour lequel ce gestionnaire gère des événements
     */
    public GestionnaireEvenementServeur(Serveur serveur) {
        this.serveur = serveur;
    }

    /**
     * Méthode de gestion d’événements. Cette méthode contiendra le code qui gère les réponses obtenues d’un client.
     *
     * @param evenement L’événement à gérer.
     */
    ArrayList<Invitation> inviteList = new ArrayList<>();

    @Override
    public void traiter(Evenement evenement) {
        Object source = evenement.getSource();
        Connexion cnx;
        String msg, typeEvenement, aliasExpediteur;
        ServeurChat serveur = (ServeurChat) this.serveur;
        if (source instanceof Connexion) {
            cnx = (Connexion) source;
            System.out.println("SERVEUR-Reçu : " + evenement.getType() + " " + evenement.getArgument());
            typeEvenement = evenement.getType();
            switch (typeEvenement) {
                case "JOIN":
                    Invitation invite = new Invitation(cnx, evenement.getArgument());
                    inviteList.add(invite);
                    boolean roomCreated = false;
                        for (int i = 0; i < inviteList.size(); i++) {
                            if (inviteList.get(i).getAliasGuest().equals(cnx.getAlias())) {
                                SalonPrive salonPrive = new SalonPrive(cnx, invite.getAliasGuest());
                                for(Connexion c: serveur.connectes){
                                    if(c.getAlias().equals(evenement.getArgument())){
                                        c.envoyer("JOINOK " + cnx.getAlias());
                                    }
                                }
                                cnx.envoyer("JOINOK " + evenement.getArgument());
                                roomCreated = true;
                                inviteList.remove(i);
                                break;
                            }
                        }
                        if(!roomCreated) {
                            for(Connexion c : serveur.connectes){
                                if(c.getAlias().equals(evenement.getArgument())){
                                    c.envoyer("JOIN " + cnx.getAlias());
                                }
                            }
                        }



                    break;
                case "DECLINE":
                    for(Connexion c : serveur.connectes){
                        if(c.getAlias().equals(evenement.getArgument())){
                            c.envoyer("DECLINE " + cnx.getAlias());
                            for(int i=0; i < inviteList.size(); i++){
                                if(inviteList.get(i).getAliasGuest().equals(cnx.getAlias())){
                                    inviteList.remove(i);
                                }
                            }
                        }
                    }

                    break;
                case "EXIT": // Ferme la connexion avec le client qui a envoyé "EXIT" :
                    cnx.envoyer("END");
                    serveur.enlever(cnx);
                    cnx.close();
                    break;
                case "LIST": // Envoie la liste des alias des personnes connectées :
                    cnx.envoyer("LIST " + serveur.list());
                    break;
                case "MSG":
                    serveur.ajouterHistorique(evenement.getArgument(), cnx.getAlias());
                    serveur.envoyerATousSauf(evenement.getArgument(), cnx.getAlias());
                    break;
                // Ajoutez ici d’autres case pour gérer d’autres commandes.

                default: // Renvoyer le texte reçu converti en majuscules :
                    msg = (evenement.getType() + " " + evenement.getArgument()).toUpperCase();
                    cnx.envoyer(msg);
            }
        }
    }
}
