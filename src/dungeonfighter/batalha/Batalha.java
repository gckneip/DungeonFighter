package dungeonfighter.batalha;

import dungeonfighter.entidades.personagens.*;
import java.awt.*;
import javax.swing.JPanel;

public class Batalha extends JPanel {

    private final PainelPersonagens painelPersonagens;
    private final PainelAcoes painelAcoes;
    private final Heroi heroi;
    private final Inimigo inimigo;

    public Batalha(Heroi heroi, Inimigo inimigo) {

        this.heroi = heroi;
        this.inimigo = inimigo;
        
        setLayout(new GridBagLayout());
        setBackground(Color.GREEN);

        GridBagConstraints gbc = new GridBagConstraints();

        painelPersonagens = new PainelPersonagens(this.heroi, this.inimigo);

        painelAcoes = new PainelAcoes();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 4.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        add(painelPersonagens, gbc);

        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        add(painelAcoes, gbc);


        setSize(300, 200);
        setVisible(true);
    }
}
