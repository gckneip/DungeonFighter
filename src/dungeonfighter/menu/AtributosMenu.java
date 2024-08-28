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
        setOpaque(false);

        botaoAtaque = new BotaoAtributo("Ataque", 0, this);
        botaoDefesa = new BotaoAtributo("Defesa", 0, this);
        botaoVida = new BotaoAtributo("Vida", 0, this);

        atributosIniciaisLabel = new JLabel("Atributos Iniciais: " + atributosExtras);
        atributosIniciaisLabel.setFont(atributosIniciaisLabel.getFont().deriveFont(20.0f));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(atributosIniciaisLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; 
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        add(botaoAtaque, gbc);

        gbc.gridy = 2; 
        add(botaoDefesa, gbc);

        gbc.gridy = 3; 
        add(botaoVida, gbc);
    }

    public void setEscolhido(tipoHeroi escolhido) {
        switch (escolhido) {
            case BRUXO -> {
                botaoAtaque.setValorInicial(8);
                botaoDefesa.setValorInicial(5);
                botaoVida.setValorInicial(20);
            }
            case GUERREIRO -> {
                botaoAtaque.setValorInicial(5);
                botaoDefesa.setValorInicial(10);
                botaoVida.setValorInicial(30);
            }
            case ARQUEIRO -> {
                botaoAtaque.setValorInicial(6);
                botaoDefesa.setValorInicial(3);
                botaoVida.setValorInicial(25);
            }
            default -> throw new AssertionError();
        }

        this.atributosExtras = 10;
        updateAtributosIniciaisLabel();
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
