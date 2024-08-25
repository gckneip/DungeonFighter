package dungeonfighter.batalha;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.*;

public class PainelAcoes extends JPanel {
    private final JButton botaoAtacar;
    private final JButton botaoFugir;
    private final JButton botaoUsarItem;
    private final JButton botaoEspecial;

    public PainelAcoes() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        botaoAtacar = new JButton("Atacar");
        botaoEspecial = new JButton("Especial");
        botaoUsarItem = new JButton("Usar Item");
        botaoFugir = new JButton("Fugir");

        botaoAtacar.setFont(botaoAtacar.getFont().deriveFont(20.0f));
        botaoEspecial.setFont(botaoEspecial.getFont().deriveFont(20.0f));
        botaoUsarItem.setFont(botaoUsarItem.getFont().deriveFont(20.0f));
        botaoFugir.setFont(botaoFugir.getFont().deriveFont(20.0f));


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(botaoAtacar, gbc);

        gbc.gridx = 1;
        add(botaoEspecial, gbc);

        gbc.gridx = 2;
        add(botaoUsarItem, gbc);

        gbc.gridx = 3;
        add(botaoFugir, gbc);
    }
    
}
