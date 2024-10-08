package dungeonfighter.batalha;

import dungeonfighter.DungeonFighter;
import dungeonfighter.entidades.personagens.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class PainelPersonagens extends JPanel{
        private final PainelPersonagem painelHeroi;
        private final PainelPersonagem painelInimigo;    

        public PainelPersonagens(Heroi heroi, Inimigo inimigo) {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();

            painelHeroi = new PainelPersonagem(heroi,DungeonFighter.getInstanceDungeonFighter().getNomeJogador());
            painelInimigo = new PainelPersonagem(inimigo, inimigo.getNome());

            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(painelHeroi, gbc);

            gbc.gridx = 1;
            add(painelInimigo, gbc);
        }

        public void atualizarVida(Heroi heroi, Inimigo inimigo){
            int vidaHeroi = heroi.getVida();
            int vidaInimigo = inimigo.getVida();

            painelHeroi.atualizarVida(vidaHeroi);
            painelInimigo.atualizarVida(vidaInimigo);
        }
    
}
