package controleur;

import com.chat.client.ClientChat;
import vue.PanneauInvitations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EcouteurEvenement implements ActionListener {

    private final ClientChat clientChat;
    private final PanneauInvitations panneauInvitations;

    public EcouteurEvenement(ClientChat clientChat, PanneauInvitations panneauInvitations) {
        this.clientChat = clientChat;
        this.panneauInvitations = panneauInvitations;
    }

    @Override
    public void actionPerformed(ActionEvent evenement) {
        List<String> invitationsSelectionnees = panneauInvitations.getElementsSelectionnes();
        if (invitationsSelectionnees.isEmpty()) return;

        String actionBouton = evenement.getActionCommand();

        for (String aliasInvitation : invitationsSelectionnees) {
            switch (actionBouton) {
                case "ACCEPTER":
                    clientChat.envoyer("JOIN " + aliasInvitation);
                    panneauInvitations.retirerInvitationRecue(aliasInvitation);
                    break;
                case "REFUSER":
                    clientChat.envoyer("DECLINE " + aliasInvitation);
                    panneauInvitations.retirerInvitationRecue(aliasInvitation);
                    break;
            }
        }
    }
}
