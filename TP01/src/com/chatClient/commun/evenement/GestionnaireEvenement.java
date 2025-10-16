package com.chatClient.commun.evenement;

/**
 * Cette interface repr�sente un gestionnaire d'�v�nement.
 *
 * @author Abdelmoum�ne Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-09-01
 */
@FunctionalInterface
public interface GestionnaireEvenement {
	/**
	* M�thode de gestion de l'�v�nement.
	*
	* @param evenement L'�v�nement � g�rer.
	*/
	void traiter(Evenement evenement);
}
