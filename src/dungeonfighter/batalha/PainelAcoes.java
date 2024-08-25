package dungeonfighter.batalha;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PainelAcoes extends JPanel implements ActionListener {
    private final JButton botaoAtacar;
    private final JButton botaoFugir;
    private final JButton botaoUsarItem;
    private final JButton botaoEspecial;
    private final Batalha batalha;

    public PainelAcoes(Batalha batalha) {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        botaoAtacar = new JButton("Atacar");
        botaoEspecial = new JButton("Especial");
        botaoUsarItem = new JButton("Usar Item");
        botaoFugir = new JButton("Fugir");

        this.batalha = batalha;

        botaoAtacar.addActionListener(this);
        botaoEspecial.addActionListener(this);
        botaoUsarItem.addActionListener(this);
        botaoFugir.addActionListener(this);


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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoAtacar) {
            batalha.atacar();
        } else if (e.getSource() == botaoEspecial) {
            batalha.especial();
        } else if (e.getSource() == botaoUsarItem) {
            batalha.usarItem();
        } else if (e.getSource() == botaoFugir) {
            batalha.fugir();
        }
    }
    
}
