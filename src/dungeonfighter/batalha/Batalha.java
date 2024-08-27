package dungeonfighter.batalha;

import dungeonfighter.DungeonFighter;
import dungeonfighter.entidades.itens.Item;
import dungeonfighter.entidades.itens.ItemDeCura;
import dungeonfighter.entidades.personagens.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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

        painelAcoes = new PainelAcoes(this);

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

    public void atacar() {
        int danoHeroi = heroi.atacar(inimigo);
        int danoInimigo = inimigo.atacar(heroi);
        if (danoHeroi > 0) {
            JOptionPane.showMessageDialog(null,
                    heroi.getNome() + " atacou " + inimigo.getNome() + " com " + danoHeroi + " de dano.\n");
        } else {
            JOptionPane.showMessageDialog(null,
                    heroi.getNome() + " errou o ataque e sofreu" + danoHeroi * (-1) + "de dano.\n");
        }

        if (danoInimigo > 0) {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " atacou " + heroi.getNome() + " com " + danoInimigo + " de dano.\n");
        } else {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " errou o ataque e sofreu" + danoInimigo * (-1) + "de dano.\n");
        }
        atualizarVida();
    }

    public void especial() {
        int danoHeroi = heroi.especial(inimigo);
        int danoInimigo = inimigo.atacar(heroi);
        if (heroi instanceof Guerreiro) {
            JOptionPane.showMessageDialog(null,
                    heroi.getNome() + " usou ataque especial e aumentou sua defesa para " + danoHeroi + ".\n");
        } else {
            JOptionPane.showMessageDialog(null,
                    heroi.getNome() + " usou seu ataque especial e atacou" + inimigo.getNome() + " com " + danoHeroi
                            + " de dano.\n");
        }

        if (danoInimigo > 0) {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " atacou " + heroi.getNome() + " com " + danoInimigo + " de dano.\n");
        } else {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " errou o ataque e sofreu" + danoInimigo * (-1) + "de dano.\n");
        }
        atualizarVida();
    }

    public void usarItem() {
        ArrayList<Item> bolsa = heroi.getBolsa();
        if (!bolsa.isEmpty()) {
            Item item = bolsa.get(0);
            if (item instanceof ItemDeCura itemDeCura) {
                heroi.curar(itemDeCura.getCura());
                JOptionPane.showMessageDialog(null, heroi.getNome() + " usou " + item.getNome() + " e curou "
                        + itemDeCura.getCura() + " pontos de vida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bolsa vazia");
        }
        int danoInimigo = inimigo.atacar(heroi);
        if (danoInimigo > 0) {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " atacou " + heroi.getNome() + " com " + danoInimigo + " de dano.\n");
        } else {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " errou o ataque e sofreu" + danoInimigo * (-1) + "de dano.\n");
        }
        atualizarVida();

    }

    public void fugir() {
        DungeonFighter.getInstanceDungeonFighter().finalizarBatalha(false);
    }

    public void atualizarVida() {
        if (heroi.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, "Você morreu. Game Over :(");
            DungeonFighter.getInstanceDungeonFighter().reiniciarJogo();;
        } else if (inimigo.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, inimigo.getNome() + " derrotado! Parabéns!");
            DungeonFighter.getInstanceDungeonFighter().finalizarBatalha(true);
        }
        painelPersonagens.atualizarVida(heroi, inimigo);
    }
}
