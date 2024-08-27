package dungeonfighter;

import javax.swing.*;
import dungeonfighter.entidades.Entidade;
import dungeonfighter.entidades.armadilhas.Armadilha;
import dungeonfighter.entidades.itens.Elixir;
import dungeonfighter.entidades.itens.Item;
import dungeonfighter.entidades.personagens.Inimigo;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class Tabuleiro extends JPanel {
    private Celula[][] celulas;
    private Jogador jogador;
    private DungeonFighter jogo;
    private JPanel menu;
    private JLabel vidaLabel;
    private JLabel ataqueLabel;
    private JLabel defesaLabel;
    private JPanel imagePanel;
    private int xAnterior;
    private int yAnterior;

    public Tabuleiro(Inimigo[] inimigos, Armadilha[] armadilhas, Item[] itens) {
        celulas = new Celula[8][8];
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // -------------------------- TABULEIRO --------------------------
        // //////////////////

        JPanel tabuleiro = new JPanel();
        tabuleiro.setLayout(new GridLayout(8, 8));
        tabuleiro.setPreferredSize(new Dimension(800, 800));

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                celulas[row][col] = new Celula();
                celulas[row][col].setBackground(Color.RED);
                celulas[row][col].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
                celulas[row][col].setLayout(new BorderLayout());
                tabuleiro.add(celulas[row][col]);
            }
        }

        setCelulasClicaveis(0, 0);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.7;
        gbc.weighty = 1.0;
        add(tabuleiro, gbc);

        posicionarEntidades(inimigos, armadilhas, itens);
        // -------------------------- TABULEIRO
        // --------------------------////////////////

        menu = new JPanel();
        menu.setBackground(Color.BLUE);
        menu.setLayout(new GridBagLayout());

        menu.setPreferredSize(new Dimension(200, 800));

        GridBagConstraints menuGbc = new GridBagConstraints();
        menuGbc.gridx = 0;
        menuGbc.gridy = 0;
        menuGbc.fill = GridBagConstraints.HORIZONTAL;
        menuGbc.weightx = 1.0;
        menuGbc.insets = new Insets(5, 5, 5, 5);

        vidaLabel = new JLabel("Vida: 0");
        ataqueLabel = new JLabel("Ataque: 0");
        defesaLabel = new JLabel("Defesa: 0");
        menu.add(vidaLabel, menuGbc);
        menuGbc.gridy = 1;
        menu.add(ataqueLabel, menuGbc);
        menuGbc.gridy = 2;
        menu.add(defesaLabel, menuGbc);

        JPanel inventario = new JPanel();
        inventario.setLayout(new GridLayout(5, 1));
        inventario.setBorder(BorderFactory.createTitledBorder("Inventário"));
        menuGbc.gridy = 3;
        for (int i = 0; i < 5; i++) {
            JPanel item = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image scaledImage = new ImageIcon("src/dungeonfighter/assets/elixir.jpg").getImage();
                    g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), this);
                }
            };
            item.setBackground(Color.white);

            inventario.add(item);
        }
        menu.add(inventario, menuGbc);

        imagePanel = new JPanel();
        menuGbc.gridy = 1;
        menu.add(imagePanel, menuGbc);

        gbc.gridx = 1;
        gbc.weightx = 0.3;
        add(menu, gbc);

        setVisible(true);
    }

    // ----------------Métodos chamados pela BATALHA----------------

    public void fugir() {
        JOptionPane.showMessageDialog(null, "Você fugiu da batalha!");
        celulas[jogador.getPosicaoY()][jogador.getPosicaoX()].remove(jogador);
        celulas[yAnterior][xAnterior].add(jogador, BorderLayout.CENTER);
        moverPersonagem(yAnterior, xAnterior);
    }

    // ----------------Métodos chamados pela BATALHA----------------

    public void carregarHeroi() {
        this.jogo = DungeonFighter.getInstanceDungeonFighter();
        this.jogador = new Jogador(0, 0, jogo.getHeroi().getIcone());
        celulas[0][0].add(jogador, BorderLayout.CENTER);
        atualizarMenu();
    }

    private void atualizarMenu() {
        if (jogo != null && jogo.getHeroi() != null) {
            vidaLabel.setText("Vida: " + jogo.getHeroi().getVida());
            ataqueLabel.setText("Ataque: " + jogo.getHeroi().getAtaque());
            defesaLabel.setText("Defesa: " + jogo.getHeroi().getDefesa());
            menu.remove(imagePanel);
            imagePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    Image scaledImage = jogo.getHeroi().getIcone().getImage();
                    g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), this);
                }
            };
            imagePanel.setPreferredSize(new Dimension(100, 100));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = 1;
            gbc.gridx = 1;
            gbc.weightx = 1;
            gbc.weighty = 0.5;
            menu.add(imagePanel, gbc);
            menu.revalidate();
            menu.repaint();

        }
    }

    public void moverPersonagem(int row, int col) {
        int x = this.jogador.getPosicaoX();
        int y = this.jogador.getPosicaoY();

        celulas[y][x].remove(jogador);
        celulas[y][x].revalidate();
        celulas[y][x].repaint();
        celulas[y][x].setBackground(Color.white);
        resetMouseListener(y, x);
        // salva posição anterior do herói para o caso de ele fugir de uma eventual
        // batalha
        this.xAnterior = x;
        this.yAnterior = y;

        this.jogador.mover(row, col);
        setCelulasClicaveis(row, col);

        celulas[row][col].add(this.jogador, BorderLayout.CENTER);
        celulas[row][col].revalidate();
        celulas[row][col].repaint();

        verificarSituacaoJogo(celulas[row][col]);
        atualizarMenu(); // Update menu after moving
    }

    public void verificarSituacaoJogo(Celula celulaAtual) {
        Entidade entidade = celulaAtual.getEntidade();
        this.jogo = DungeonFighter.getInstanceDungeonFighter();

        if (entidade != null) {
            if (entidade instanceof Inimigo) {
                Inimigo inimigo = (Inimigo) entidade;
                jogo.iniciarBatalha(inimigo);
            }
            if (entidade instanceof Elixir) {
                Elixir elixir = (Elixir) entidade;
                JOptionPane.showMessageDialog(null, "Você encontrou um elixir! Cura: " + elixir.getCura());
                ArrayList<Item> bolsa = jogo.getHeroi().getBolsa();
                if (bolsa.size() < 5) {
                    bolsa.add(elixir);
                    jogo.getHeroi().setBolsa(bolsa);
                } else {
                    JOptionPane.showMessageDialog(null, "Sua bolsa está cheia! Descarte um item para pegar o elixir.");
                }
                celulaAtual.setEntidade(null);
            }
            if (entidade instanceof Armadilha) {
                Armadilha armadilha = (Armadilha) entidade;
                JOptionPane.showMessageDialog(null, "Você caiu em uma armadilha! Dano: 1 ");
                armadilha.darDano(jogo.getHeroi());
                celulaAtual.setEntidade(null);
                atualizarMenu(); // Update menu after taking damage
            }
        }
    }

    void setCelulasClicaveis(int row, int col) {
        if (row - 1 >= 0) {
            setMouseListener(row - 1, col);
        }
        if (row + 1 < 8) {
            setMouseListener(row + 1, col);
        }
        if (col - 1 >= 0) {
            setMouseListener(row, col - 1);
        }
        if (col + 1 < 8) {
            setMouseListener(row, col + 1);
        }
    }

    void setMouseListener(int row, int col) {
        celulas[row][col].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moverPersonagem(row, col);
            }
        });
        celulas[row][col].activateMouseListener();
    }

    void resetMouseListener(int row, int col) {
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

    public void posicionarEntidades(Inimigo[] inimigos, Armadilha[] armadilhas, Item[] itens) {
        int[] xInimigos = new int[7];
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                xInimigos[i] = (int) (Math.random() * 7) + 1;
            } else {
                xInimigos[i] = (int) (Math.random() * 8);
            }
        }
        for (int i = 0; i < 7; i++) {
            celulas[i][xInimigos[i]].setEntidade(inimigos[i]);
            celulas[i][xInimigos[i]].setBackground(Color.black);
        }
        for (int i = 0; i < armadilhas.length; i++) {
            int x = (int) (Math.random() * 8);
            int y = (int) (Math.random() * 8);
            if (celulas[y][x].getEntidade() == null) {
                celulas[y][x].setEntidade(armadilhas[i]);
                celulas[y][x].setBackground(Color.gray);
            } else {
                i--;
            }
        }

        for (int i = 0; i < itens.length; i++) {
            int x = (int) (Math.random() * 8);
            int y = (int) (Math.random() * 8);
            if (celulas[y][x].getEntidade() == null) {
                celulas[y][x].setEntidade(itens[i]);
                celulas[y][x].setBackground(Color.green);
            } else {
                i--;
            }
        }
    }
}
