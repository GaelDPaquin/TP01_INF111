package controleur;

import com.chat.client.ClientChat;
import vue.PanneauChat;
import vue.PanneauChatPrive;

import java.awt.event.ActionEvent;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurChatPrive extends EcouteurChatPublic {
    private String alias;
    public EcouteurChatPrive(String alias, ClientChat clientChat, PanneauChat panneauChat) {
        super(clientChat, panneauChat);
        this.alias = alias;

    }
    public String getAlias() {
        return alias;
    }
    @Override
    public void actionPerformed(ActionEvent evenement) {
        String commande = evenement.getActionCommand();
        Object source = evenement.getSource();

        switch (commande) {
            case "INVITER":
                clientChat.envoyer("TTT " + alias);
                break;
            case "ACCEPTER":
                clientChat.envoyer("TTT " + alias);
                break;

            case "REFUSER":
                clientChat.envoyer("DECLINE " + alias);
                ((PanneauChatPrive)panneauChat).invitationAJouerAnnulee();
                break;

            default:
                String saisie = panneauChat.getChampDeSaisie().getText().trim();
                switch (saisie) {
                    case "QUIT":
                        clientChat.envoyer("QUIT " + alias);
                        break;
                    case "ABANDON":
                        clientChat.envoyer("ABANDON " + alias);
                        break;
                    default:
                        clientChat.envoyer("PRV " + alias + " " + saisie);
                        ((PanneauChatPrive)panneauChat).ajouter("Moi >> " + saisie);
                        break;
                }
                panneauChat.getChampDeSaisie().setText("");
                break;
        }
    }

}