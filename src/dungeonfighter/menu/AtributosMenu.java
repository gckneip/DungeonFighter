package dungeonfighter.menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class AtributosMenu extends JPanel {
    private int atributosExtras;
    private final BotaoAtributo botaoAtaque;
    private final BotaoAtributo botaoDefesa;
    private final BotaoAtributo botaoVida;
    private final JLabel atributosIniciaisLabel;

    public AtributosMenu() {
        atributosExtras = 10;

        botaoAtaque = new BotaoAtributo("Ataque", 0, this);
        botaoDefesa = new BotaoAtributo("Defesa", 0, this);
        botaoVida = new BotaoAtributo("Vida", 0, this);

        atributosIniciaisLabel = new JLabel("Atributos Iniciais: " + atributosExtras);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding around components

        // Constraints for atributosIniciaisLabel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; // Span across 3 columns
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(atributosIniciaisLabel, gbc);

        // Constraints for botaoAtaque
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Span only 1 column
        gbc.fill = GridBagConstraints.HORIZONTAL; // Ensure the button spans the full width of the column
        add(botaoAtaque, gbc);

        // Constraints for botaoDefesa
        gbc.gridy = 2; // Move to the next row
        add(botaoDefesa, gbc);

        // Constraints for botaoVida
        gbc.gridy = 3; // Move to the next row
        add(botaoVida, gbc);
    }

    public int getAtributosExtras() {
        return atributosExtras;
    }

    public void decrementAtributosIniciais() {
        atributosExtras--;
        updateAtributosIniciaisLabel();
    }

    public void incrementAtributosIniciais() {
        atributosExtras++;
        updateAtributosIniciaisLabel();
    }

    private void updateAtributosIniciaisLabel() {
        atributosIniciaisLabel.setText("Atributos Iniciais: " + atributosExtras);
    }

    public int getAtaque() {
        return botaoAtaque.getValor();
    }

    public int getDefesa() {
        return botaoDefesa.getValor();
    }

    public int getVida() {
        return botaoVida.getValor();
    }
}
