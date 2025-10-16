package com.chatServer.commun.evenement;

/**
 * Classe utilitaire fournissant des m�thodes pour manipuler des �v�nements.
 */
public class EvenementUtil {
    /*
      Contructeur priv� pour emp�cher l'instanciation (inutile) de la classe.
    */
    private EvenementUtil() {
    }
    /**
     * M�thode utilitaire qui extrait � partir d'une chaine de caract�res le type et l'argument d'un �v�nement.
     *
     * @param str chaine de caract�res d�crivant l'�v�nement
     * @return String[] tableau de taille 2 contenant le type et l'argument de l'�v�nement
     */
    public static String[] extraireInfosEvenement(String str) {

        str = str.trim();

        if ("".equals(str))
            return new String[]{"", ""};
        else {
            int i = str.indexOf(' ');
            if (i == -1)
                return new String[]{str, ""};
            else
                return new String[]{str.substring(0, i), str.substring(i).trim()};
        }
    }
}