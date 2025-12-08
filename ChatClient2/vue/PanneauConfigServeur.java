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
        JTextField tAdresse = new JTextField(20);
        tAdresse.setText(adr);

        JLabel lPort = new JLabel("Port :");
        JTextField tPort = new JTextField(20);
        tPort.setText(String.valueOf(port));
        lPort.setHorizontalAlignment(SwingConstants.RIGHT);

        pLabel.add(lAdresse);
        pLabel.add(lPort);
        pTexte.add(tAdresse);
        pTexte.add(tPort);

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
