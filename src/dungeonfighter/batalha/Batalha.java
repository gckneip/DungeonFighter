package dungeonfighter.batalha;

import dungeonfighter.DungeonFighter;
import dungeonfighter.Tabuleiro;
import dungeonfighter.entidades.itens.Item;
import dungeonfighter.entidades.itens.ItemDeCura;
import dungeonfighter.entidades.personagens.*;
import dungeonfighter.exceptions.OutOfSpecialsException;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.FlowLayout;

public class Batalha extends JPanel {

    private final PainelPersonagens painelPersonagens;
    private final PainelAcoes painelAcoes;
    private final Heroi heroi;
    private final Inimigo inimigo;
    private final Tabuleiro tabuleiro;
    private int especialBuffer = 0;
    private final String nomeJogador;

    public Batalha(Heroi heroi, Inimigo inimigo) {

        this.heroi = heroi;
        this.inimigo = inimigo;
        this.tabuleiro = DungeonFighter.getInstanceDungeonFighter().getTabuleiro();
        this.nomeJogador = DungeonFighter.getInstanceDungeonFighter().getNomeJogador();

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
                    nomeJogador + " atacou " + inimigo.getNome() + " com " + danoHeroi + " de dano.\n");
        } else {
            JOptionPane.showMessageDialog(null,
                    heroi.getNome() + " errou o ataque e sofreu " + danoHeroi * (-1) + " de dano.\n");

        }

        if (danoInimigo > 0) {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " atacou " + heroi.getNome() + " com " + danoInimigo + " de dano.\n");
        } else {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " errou o ataque e sofreu " + danoInimigo * (-1) + " de dano.\n");
        }
        atualizarVida();
    }

    public void especial() throws OutOfSpecialsException {
        int danoHeroi = heroi.especial(inimigo);
        int danoInimigo = inimigo.atacar(heroi);

        if (this.especialBuffer > 0) {
            throw new OutOfSpecialsException(
                    "Aguarde mais " + (especialBuffer) + " turnos para usar o especial novamente.");
        } else {
            this.especialBuffer = 4;
        }

        if (heroi instanceof Guerreiro) {
            JOptionPane.showMessageDialog(null,
                    nomeJogador + " usou ataque especial e aumentou sua defesa para " + danoHeroi + ".\n");
        } else {
            JOptionPane.showMessageDialog(null,
                    nomeJogador + " usou seu ataque especial e atacou" + inimigo.getNome() + " com " + danoHeroi
                            + " de dano.\n");
        }

        if (danoInimigo > 0) {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " atacou " + nomeJogador + " com " + danoInimigo + " de dano.\n");
        } else {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " errou o ataque e sofreu " + danoInimigo * (-1) + " de dano.\n");
        }
        atualizarVida();
    }

    public void usarItem() {
        ArrayList<Item> bolsa = heroi.getBolsa();
        if (!bolsa.isEmpty()) {
            Item item = bolsa.get(0);
            if (item instanceof ItemDeCura itemDeCura) {
                heroi.curar(itemDeCura.getCura());
                JOptionPane.showMessageDialog(null, nomeJogador + " usou " + item.getNome() + " e curou "
                        + itemDeCura.getCura() + " pontos de vida.");
                bolsa.remove(item);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Bolsa vazia");
        }
        int danoInimigo = inimigo.atacar(heroi);
        if (danoInimigo > 0) {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " atacou " + nomeJogador + " com " + danoInimigo + " de dano.\n");
        } else {
            JOptionPane.showMessageDialog(null,
                    inimigo.getNome() + " errou o ataque e sofreu " + danoInimigo * (-1) + " de dano.\n");
        }
        atualizarVida();
        tabuleiro.updateInventario();

    }

    public void fugir() {
        DungeonFighter.getInstanceDungeonFighter().finalizarBatalha(false);
    }

    public void atualizarVida() {
        if (heroi.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, "Você morreu. Game Over :(");

            JDialog dialog = new JDialog(DungeonFighter.getInstanceDungeonFighter(), "Sair", true);
            dialog.setSize(200, 100);
            dialog.setLayout(new FlowLayout());

            // Create two buttons
            JButton button1 = new JButton("Reiniciar jogo");
            JButton button2 = new JButton("Novo jogo");

            dialog.add(button1);
            dialog.add(button2);

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                    DungeonFighter.getInstanceDungeonFighter().reiniciarJogo();
                }
            });

            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DungeonFighter.getInstanceDungeonFighter().novoJogo();
                    dialog.dispose();
                }
            });

            // Position the dialog in the center of the parent frame
            dialog.setLocationRelativeTo(DungeonFighter.getInstanceDungeonFighter());

            // Make the dialog visible
            dialog.setVisible(true);

        } else if (inimigo.getVida() <= 0) {
            JOptionPane.showMessageDialog(null, inimigo.getNome() + " derrotado! Parabéns!");
            DungeonFighter.getInstanceDungeonFighter().finalizarBatalha(true);
        }
        painelPersonagens.atualizarVida(heroi, inimigo);
        this.especialBuffer = Math.max(0, this.especialBuffer - 1);
    }
}