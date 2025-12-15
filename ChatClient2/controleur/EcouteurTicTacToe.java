package controleur;

import com.chat.client.ClientChat;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurTicTacToe implements ActionListener {

    private ClientChat clientChat;

    public EcouteurTicTacToe(ClientChat clientChat) {
        this.clientChat = clientChat;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton bouton =(JButton) e.getSource();
        String position = bouton.getActionCommand();
        int ligne = Character.getNumericValue(position.charAt(0));
        int colone = Character.getNumericValue(position.charAt(1));
        String symbole = (String) ((JComponent) bouton.getParent()).getClientProperty("symbole");
        clientChat.envoyer("COUP "+ symbole + " " + ligne +" " + colone );
    }
}
