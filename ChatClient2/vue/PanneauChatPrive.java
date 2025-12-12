package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauChatPrive extends PanneauChat {
    private JButton bAccepterOuInviter, bRefuser;
    private FenetreTicTacToe fenetreTicTacToe;
    public PanneauChatPrive() {
        bAccepterOuInviter = new JButton("Inviter TTT");
        bRefuser = new JButton("Refuser");

        bAccepterOuInviter.setActionCommand("INVITER");
        bRefuser.setActionCommand("REFUSER");

        bRefuser.setVisible(false);

        JPanel panneauBoutons = new JPanel();
        panneauBoutons.add(bAccepterOuInviter);
        panneauBoutons.add(bRefuser);

        this.add(panneauBoutons, BorderLayout.NORTH);

    }


    @Override
    public void setEcouteur(ActionListener ecouteur) {
        super.setEcouteur(ecouteur);
        bAccepterOuInviter.addActionListener(ecouteur);
        bRefuser.addActionListener(ecouteur);
    }
    public void invitationAJouerRecue() {
        bAccepterOuInviter.setText("Accepter");
        bAccepterOuInviter.setActionCommand("ACCEPTER");
        bRefuser.setVisible(true);
    }
    public void invitationAJouerAnnulee() {
        bAccepterOuInviter.setText("Inviter TTT");
        bAccepterOuInviter.setActionCommand("INVITER");
        bRefuser.setVisible(false);
    }

    public void setFenetreJeu(FenetreTicTacToe fenetreTicTacToe) {
        if (this.fenetreTicTacToe !=null){
            this.fenetreTicTacToe.setVisible(false);
            this.fenetreTicTacToe.dispose();
        }
        this.fenetreTicTacToe = fenetreTicTacToe;
    }
    public FenetreTicTacToe getFenetreJeu() {
        return this.fenetreTicTacToe;
    }
}