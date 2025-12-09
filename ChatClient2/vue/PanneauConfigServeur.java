package vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;

    public PanneauConfigServeur(String adr, int port) {
        this.setLayout(new BorderLayout(10,10));

        JPanel pLabel = new JPanel(new GridLayout(2,1));
        JPanel pTexte = new JPanel(new GridLayout(2,1,5,5));

        JLabel lAdresse = new JLabel("Adresse IP :");
        txtAdrServeur = new JTextField(20);
        txtAdrServeur.setText(adr);

        JLabel lPort = new JLabel("Port :");
        txtNumPort = new JTextField(20);
        txtNumPort.setText(String.valueOf(port));
        lPort.setHorizontalAlignment(SwingConstants.RIGHT);

        pLabel.add(lAdresse);
        pLabel.add(lPort);
        pTexte.add(txtAdrServeur);
        pTexte.add(txtNumPort);

        this.add(pLabel, BorderLayout.WEST);
        this.add(pTexte, BorderLayout.CENTER);
    }
    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
