package dungeonfighter;

import javax.swing.*;

import dungeonfighter.entidades.Entidade;
import dungeonfighter.entidades.armadilhas.Armadilha;
import dungeonfighter.entidades.itens.Elixir;
import dungeonfighter.entidades.itens.Item;
import dungeonfighter.entidades.personagens.Heroi;
import dungeonfighter.entidades.personagens.ImpostoDeRenda;
import dungeonfighter.entidades.personagens.Inimigo;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Tabuleiro extends JPanel {
    private Celula[][] celulas; // 2D array to store the grid of Celula objects
    private Jogador jogador;
    // private DungeonFighter jogo = DungeonFighter.getInstanceDungeonFighter();
    private Heroi heroi = DungeonFighter.getInstanceDungeonFighter().getHeroi();

    public Tabuleiro(Inimigo[] inimigos, Armadilha[] armadilhas, Item[] itens) {
        // Initialize the 2D array with dimensions 8x8
        celulas = new Celula[8][8];
        setLayout(new GridBagLayout()); // 8x8 grid layout
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel tabuleiro = new JPanel();
        tabuleiro.setLayout(new GridLayout(8, 8));
        tabuleiro.setPreferredSize(new Dimension(800, 800));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 8;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(tabuleiro, gbc);

        // Create the 8x8 grid of Celula objects
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                celulas[row][col] = new Celula();
                celulas[row][col].setBackground(Color.RED); // Set background color
                celulas[row][col].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

                // Add the cell to the grid layout
                tabuleiro.add(celulas[row][col]);
                // celulas[row][col].activateMouseListener();
                this.jogador = new Jogador(0, 0,
                        new ImageIcon("src/dungeonfighter/entidades/personagens/guerreiro.jpeg"));
            }
        }

        // Add the image panel to the first cell
        celulas[0][0].setLayout(new BorderLayout());
        celulas[0][0].add(jogador);
        // setMouseListener(0, 0);
        setCelulasClicaveis(0, 0);

        celulas[0][(int) (Math.random() * 7) + 1].setEntidade(inimigos[0]);
        celulas[1][(int) (Math.random() * 8)].setEntidade(inimigos[1]);
        celulas[2][(int) (Math.random() * 8)].setEntidade(inimigos[2]);
        celulas[3][(int) (Math.random() * 8)].setEntidade(inimigos[3]);
        celulas[4][(int) (Math.random() * 8)].setEntidade(inimigos[4]);
        celulas[5][(int) (Math.random() * 8)].setEntidade(inimigos[5]);
        celulas[6][(int) (Math.random() * 8)].setEntidade(inimigos[6]);
        celulas[7][(int) (Math.random() * 8)].setEntidade(inimigos[7]);

        // while (celulas[0][(int) (Math.random() * 7) + 1].getEntidade() != null) {
        // celulas[0][(int) (Math.random() * 7) + 1].setEntidade(null);
        // }
        // while (celulas[1][(int) (Math.random() * 8)].getEntidade() != null) {
        // celulas[1][(int) (Math.random() * 8)].setEntidade(null);
        // }
        // while (celulas[2][(int) (Math.random() * 8)].getEntidade() != null) {
        // celulas[2][(int) (Math.random() * 8)].setEntidade(null);
        // }
        // while (celulas[3][(int) (Math.random() * 8)].getEntidade() != null) {
        // celulas[3][(int) (Math.random() * 8)].setEntidade(null);
        // }
        // while (celulas[4][(int) (Math.random() * 8)].getEntidade() != null) {
        // celulas[4][(int) (Math.random() * 8)].setEntidade(null);
        // }
        // while (celulas[5][(int) (Math.random() * 8)].getEntidade() != null) {
        // celulas[5][(int) (Math.random() * 8)].setEntidade(null);
        // }
        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(100, 100));
        menuPanel.setBackground(Color.BLUE);
        // menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        // JLabel vidaLabel = new JLabel("Vida: " + heroi.getVida());
        // menuPanel.add(vidaLabel);

        gbc.gridx = 1;
        gbc.weightx = 1;
        add(menuPanel, gbc);

        setVisible(true); // Make the JFrame visible
    }

    public void moverPersonagem(int row, int col) {
        // Remove the image from the current cell
        int x = this.jogador.getPosicaoX();
        int y = this.jogador.getPosicaoY();

        celulas[y][x].removeAll();
        celulas[y][x].revalidate();
        celulas[y][x].repaint();
        celulas[y][x].setBackground(Color.white);
        resetMouseListener(y, x);

        // Add the image to the new cell
        this.jogador.mover(row, col);
        setCelulasClicaveis(row, col);
        // calcular as células clicáveis

        celulas[row][col].add(this.jogador);
        celulas[row][col].setLayout(new BorderLayout());
        // celulas[row][col].add(jogador, BorderLayout.CENTER);
        celulas[row][col].revalidate();
        celulas[row][col].repaint();

        verificarSituacaoJogo(celulas[row][col]);
    }

    public void verificarSituacaoJogo(Celula celulaAtual) {
        Entidade entidade = celulaAtual.getEntidade();
        // this.jogo = DungeonFighter.getInstanceDungeonFighter();

        if (entidade != null) {
            // if (entidade instanceof Inimigo) {
            // jogo.iniciarBatalha(Inimigo.class.cast(entidade));
            // }
            if (entidade instanceof Elixir) {
                Elixir elixir = (Elixir) entidade;
                JOptionPane.showMessageDialog(null, "Você encontrou um elixir! Cura: " + elixir.getCura());
                ArrayList<Item> bolsa = this.heroi.getBolsa();
                if (bolsa.size() < 5) {
                    bolsa.add(elixir);
                    this.heroi.setBolsa(bolsa);
                } else {
                    JOptionPane.showMessageDialog(null, "Sua bolsa está cheia! Descarte um item para pegar o elixir.");
                }
                celulaAtual.setEntidade(null);
            }
            if (entidade instanceof Armadilha) {
                Armadilha armadilha = (Armadilha) entidade;
                JOptionPane.showMessageDialog(null, "Você caiu em uma armadilha! Dano: 1 ");
                // jogo.getHeroi().setVida(jogo.getHeroi().getVida() - armadilha.getDano());
                armadilha.darDano(this.heroi);
                celulaAtual.setEntidade(null);
            }
        }
    }

    void setCelulasClicaveis(int row, int col) {
        if (row - 1 >= 0) {
            // celulas[row - 1][col].activateMouseListener();
            setMouseListener(row - 1, col);
        }
        if (row + 1 < 8) {
            // celulas[row + 1][col].activateMouseListener();
            setMouseListener(row + 1, col);
        }
        if (col - 1 >= 0) {
            // celulas[row][col - 1].activateMouseListener();
            setMouseListener(row, col - 1);
        }
        if (col + 1 < 8) {
            // celulas[row][col + 1].activateMouseListener();
            setMouseListener(row, col + 1);
        }

    }

    void setMouseListener(int row, int col) {
        celulas[row][col].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Action when a cell is clicked
                moverPersonagem(row, col);
            }
        });
        celulas[row][col].activateMouseListener();
    }

    void resetMouseListener(int row, int col) {
        // Deactivate and remove the mouse listener from the current cell
        removeMouseListenerFromCell(row, col);

        if (row - 1 >= 0) {
            removeMouseListenerFromCell(row - 1, col);
        }
        if (row + 1 < 8) {
            removeMouseListenerFromCell(row + 1, col);
        }
        if (col - 1 >= 0) {
            removeMouseListenerFromCell(row, col - 1);
        }
        if (col + 1 < 8) {
            removeMouseListenerFromCell(row, col + 1);
        }
    }

    private void removeMouseListenerFromCell(int row, int col) {
        Celula cell = celulas[row][col];
        if (cell.getMouseListeners().length > 0) {
            cell.deactivateMouseListener();
            cell.removeMouseListener(cell.getMouseListeners()[0]);
        }
    }

}
