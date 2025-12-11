package vue;

import controleur.EcouteurMenuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauChat extends JPanel  {
    protected JTextArea zoneChat;
    protected JTextField champDeSaisie;

    public PanneauChat() {
        //à compléter.
        zoneChat = new JTextArea(); zoneChat.setEditable(false); zoneChat.setColumns(100);
        JScrollPane zoneChatScrollPane = new JScrollPane(zoneChat);
        champDeSaisie = new JTextField(100);
        this.setLayout(new BorderLayout());
        this.add(zoneChatScrollPane, BorderLayout.CENTER);
        this.add(champDeSaisie, BorderLayout.SOUTH);

    }

    public JTextArea getZoneChat() {
        return zoneChat;
    }

    public void setZoneChat(JTextArea zoneChat) {
        this.zoneChat = zoneChat;
    }

    public JTextField getChampDeSaisie() {
        return champDeSaisie;
    }

    public void setChampDeSaisie(JTextField champDeSaisie) {
        this.champDeSaisie = champDeSaisie;
    }

    public void ajouter(String msg) {
        zoneChat.append("\n"+msg);
    }
    public void setEcouteur(ActionListener ecouteur) {
        champDeSaisie.addActionListener(ecouteur);
    }

    public void vider() {
        this.zoneChat.setText("");
    }
}