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
    private Inimigo[] inimigos;
    private Armadilha[] armadilhas;
    private Item[] itens;
    private int xAnterior;
    private int yAnterior;
    private int dicas;

    public Tabuleiro(Tabuleiro original) {
        this.dicas = original.dicas;
        this.inimigos = original.inimigos;
        this.armadilhas = original.armadilhas;
        this.itens = original.itens;

        celulas = new Celula[8][8];
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel tabuleiro = new JPanel();
        tabuleiro.setLayout(new GridLayout(8, 8));
        tabuleiro.setPreferredSize(new Dimension(800, 800));

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                celulas[row][col] = new Celula();
                celulas[row][col].setBackground(original.celulas[row][col].getBackground());
                celulas[row][col].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
                celulas[row][col].setLayout(new BorderLayout());
                celulas[row][col].setEntidade(original.celulas[row][col].getEntidade());
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
        // this.dicas = original.dicas;
        // this.celulas = new
        // Celula[original.celulas.length][original.celulas[0].length];
        // for (int row = 0; row < original.celulas.length; row++) {
        // for (int col = 0; col < original.celulas[0].length; col++) {
        // this.celulas[row][col] = new Celula();
        // this.celulas[row][col].setBackground(original.celulas[row][col].getBackground());
        // this.celulas[row][col].setBorder(original.celulas[row][col].getBorder());
        // this.celulas[row][col].setLayout(new BorderLayout());
        // this.celulas[row][col].setEntidade(original.celulas[row][col].getEntidade());
        // }
        // }

        // this.jogador = original.jogador;
        // this.jogo = original.jogo;
        // this.menu = original.menu;
        // this.vidaLabel = original.vidaLabel;
        // this.ataqueLabel = original.ataqueLabel;
        // this.defesaLabel = original.defesaLabel;
        // this.imagePanel = original.imagePanel;
        // this.xAnterior = original.xAnterior;
        // this.yAnterior = original.yAnterior;

    }

    public Tabuleiro(Inimigo[] inimigos, Armadilha[] armadilhas, Item[] itens) {
        this.dicas = 3;
        this.inimigos = inimigos;
        this.armadilhas = armadilhas;
        this.itens = itens;
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

        posicionarEntidades(this.inimigos, this.armadilhas, this.itens);
        // -------------------------- TABULEIRO
        // --------------------------////////////////

        // -------------------------------- MENU ---------------------------
        menu = new JPanel();
        menu.setBackground(Color.BLUE);
        menu.setLayout(new GridBagLayout());
        menu.setPreferredSize(new Dimension(200, 800));

        JLabel nomeLabel = new JLabel("Nome: ");
        GridBagConstraints gbcNomeLabel = new GridBagConstraints();
        gbcNomeLabel.gridx = 0;
        gbcNomeLabel.gridy = 0;
        gbcNomeLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcNomeLabel.weightx = 1.0;
        gbcNomeLabel.weighty = 1.0;
        gbcNomeLabel.insets = new Insets(5, 5, 5, 5);

        JPanel inventario = new JPanel();
        inventario.setLayout(new GridBagLayout());
        inventario.setBorder(BorderFactory.createTitledBorder("Inventário"));
        inventario.setBackground(Color.CYAN);
        for (int i = 0; i < 5; i++) {
            JPanel item = new JPanel();
            item.setBackground(Color.white);
            item.setBorder(BorderFactory.createLineBorder(Color.black));
            item.setPreferredSize(new Dimension(30, 30));
            GridBagConstraints gbcItem = new GridBagConstraints();
            gbcItem.gridx = i;
            gbcItem.gridy = 0;
            gbcItem.fill = GridBagConstraints.BOTH;
            gbcItem.weightx = 1.0;
            inventario.add(item, gbcItem);
        }
        GridBagConstraints gbcInventario = new GridBagConstraints();
        gbcInventario.gridx = 0;
        gbcInventario.gridy = 1;
        gbcInventario.fill = GridBagConstraints.BOTH;
        gbcInventario.weightx = 1.0;
        gbcInventario.weighty = 2;

        JPanel inventarioPanel = new JPanel();
        inventarioPanel.setBackground(Color.white);
        inventarioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcInventarioPanel = new GridBagConstraints();
        gbcInventarioPanel.gridx = 0;
        gbcInventarioPanel.gridy = 0;
        gbcInventarioPanel.weightx = 1.0;
        gbcInventarioPanel.weighty = 1.0;
        gbcInventarioPanel.fill = GridBagConstraints.BOTH;

        inventarioPanel.add(nomeLabel, gbcNomeLabel);
        inventarioPanel.add(inventario, gbcInventario);
        menu.add(inventarioPanel, gbcInventarioPanel);

        imagePanel = new JPanel();
        imagePanel.setBackground(Color.black);
        imagePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcImagePanel = new GridBagConstraints();
        gbcImagePanel.gridx = 0;
        gbcImagePanel.gridy = 1;
        gbcImagePanel.weightx = 1.0;
        gbcImagePanel.weighty = 2.0;
        gbcImagePanel.fill = GridBagConstraints.BOTH;
        menu.add(imagePanel, gbcImagePanel);

        vidaLabel = new JLabel("Vida: ");
        GridBagConstraints gbcVidaLabel = new GridBagConstraints();
        gbcVidaLabel.gridx = 0;
        gbcVidaLabel.gridy = 0;
        gbcVidaLabel.fill = GridBagConstraints.CENTER;
        gbcVidaLabel.weightx = 1.0;
        gbcVidaLabel.weighty = 4;

        ataqueLabel = new JLabel("Ataque: ");
        GridBagConstraints gbcAtaqueLabel = new GridBagConstraints();
        gbcAtaqueLabel.gridx = 1;
        gbcAtaqueLabel.gridy = 0;
        gbcAtaqueLabel.anchor = GridBagConstraints.CENTER;
        gbcAtaqueLabel.fill = GridBagConstraints.CENTER;
        gbcAtaqueLabel.weightx = 1.0;
        gbcAtaqueLabel.weighty = 4;

        defesaLabel = new JLabel("Defesa: ");
        GridBagConstraints gbcDefesaLabel = new GridBagConstraints();
        gbcDefesaLabel.gridx = 2;
        gbcDefesaLabel.gridy = 0;
        gbcDefesaLabel.anchor = GridBagConstraints.CENTER;
        gbcDefesaLabel.fill = GridBagConstraints.CENTER;
        gbcDefesaLabel.weightx = 1.0;
        gbcDefesaLabel.weighty = 4;

        JButton dicaButton = new JButton("Dica");
        dicaButton.addActionListener(e -> {
            if (dicas > 0) {
                usarDica();
                dicas--;
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem mais dicas!");
            }
        });
        GridBagConstraints gbcDicaButton = new GridBagConstraints();
        gbcDicaButton.gridx = 0;
        gbcDicaButton.gridy = 1;
        gbcDicaButton.fill = GridBagConstraints.CENTER;
        gbcDicaButton.weightx = 1.0;
        gbcDicaButton.weighty = 1.0;

        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> {
            sair();
        });
        GridBagConstraints gbcSairButton = new GridBagConstraints();
        gbcSairButton.gridx = 2;
        gbcSairButton.gridy = 1;
        gbcSairButton.fill = GridBagConstraints.CENTER;
        gbcSairButton.weightx = 1.0;
        gbcSairButton.weighty = 1.0;

        JButton podeMover = new JButton("Mover");
        podeMover.addActionListener(e -> {
            jogador.setPodeMover(true);
        });
        GridBagConstraints gbcPodeMover = new GridBagConstraints();
        gbcPodeMover.gridx = 1;
        gbcPodeMover.gridy = 1;
        gbcPodeMover.fill = GridBagConstraints.CENTER;
        gbcPodeMover.weightx = 1.0;
        gbcPodeMover.weighty = 1.0;

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.PINK);
        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcInfoPanel = new GridBagConstraints();
        gbcInfoPanel.gridx = 0;
        gbcInfoPanel.gridy = 2;
        gbcInfoPanel.weightx = 1.0;
        gbcInfoPanel.weighty = 1.0;
        gbcInfoPanel.fill = GridBagConstraints.BOTH;

        infoPanel.add(vidaLabel, gbcVidaLabel);
        infoPanel.add(ataqueLabel, gbcAtaqueLabel);
        infoPanel.add(defesaLabel, gbcDefesaLabel);

        infoPanel.add(dicaButton, gbcDicaButton);
        infoPanel.add(sairButton, gbcSairButton);
        infoPanel.add(podeMover, gbcPodeMover);

        menu.add(infoPanel, gbcInfoPanel);

        gbc.gridx = 1;
        gbc.weightx = 0.3;
        add(menu, gbc);

        // -------------------------------- MENU ---------------------------

        setVisible(true);
    }

    public void sair() {
    }

    /*
     * ====================
     * fugir
     * 
     * Método que trata da situação em que o jogador decide fugir da batalha
     * Este método reseta as células clicáveis e move o jogador para a célula
     * anterior
     * ====================
     */
    public void fugir() {
        JOptionPane.showMessageDialog(null, "Você fugiu da batalha!");
        resetMouseListener(jogador.getPosicaoY(), jogador.getPosicaoX());
        celulas[jogador.getPosicaoY()][jogador.getPosicaoX()].remove(jogador);
        celulas[yAnterior][xAnterior].add(jogador, BorderLayout.CENTER);
        celulas[yAnterior][xAnterior].revalidate();
        celulas[yAnterior][xAnterior].repaint();
        jogador.setPodeMover(false);
        jogador.mover(yAnterior, xAnterior);
        setCelulasClicaveis(jogador.getPosicaoY(), jogador.getPosicaoX());
    }

    /*
     * ====================
     * carregarHeroi
     * 
     * Método que carrega o Herói no tabuleiro;
     * Este método é chamado pelo método iniciarJogo da classe DungeonFighter
     * ====================
     */
    public void carregarHeroi() {
        this.jogo = DungeonFighter.getInstanceDungeonFighter();
        this.jogador = new Jogador(0, 0, jogo.getHeroi().getIcone());
        celulas[0][0].add(jogador, BorderLayout.CENTER);
        atualizarMenu();
    }

    /*
     * ====================
     * atualizarMenu
     * 
     * Método que atualiza as informações do menu do jogo
     * ====================
     */
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
            GridBagConstraints gbcImagePanel = new GridBagConstraints();
            gbcImagePanel.gridx = 0;
            gbcImagePanel.gridy = 1;
            gbcImagePanel.weightx = 1.0;
            gbcImagePanel.weighty = 2.0;
            gbcImagePanel.fill = GridBagConstraints.BOTH;
            menu.add(imagePanel, gbcImagePanel);
        }
    }

    /*
     * ====================
     * moverPersonagem
     * 
     * Método que move o Herói para a célula na posição (row, col)
     * atualizando as células clicáveis e, ao final, chamando o método
     * verificarSituacaoJogo
     * ====================
     */
    public void moverPersonagem(int row, int col) {
        if (!jogador.getPodeMover()) {
            return;
        }
        int x = this.jogador.getPosicaoX();
        int y = this.jogador.getPosicaoY();

        celulas[y][x].remove(jogador);
        celulas[y][x].revalidate();
        celulas[y][x].repaint();
        celulas[y][x].setBackground(Color.white);
        resetMouseListener(y, x);

        this.xAnterior = x;
        this.yAnterior = y;

        this.jogador.mover(row, col);
        setCelulasClicaveis(row, col);

        celulas[row][col].add(this.jogador, BorderLayout.CENTER);
        celulas[row][col].revalidate();
        celulas[row][col].repaint();

        verificarSituacaoJogo(celulas[row][col]);
        jogador.setPodeMover(false);
        atualizarMenu();
    }

    /*
     * ====================
     * verificarSituacaoJogo
     * 
     * Método que verifica se o Herói se moveu para uma célula que já possui alguma
     * entidade
     * e trata a situação de acordo com o tipo de entidade
     * ====================
     */
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
                atualizarMenu();
            }
        }
    }

    /*
     * ====================
     * setCelulasClicaveis
     * 
     * Método que seta as células clicáveis ao redor da célula atual
     * ====================
     */
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

    /*
     * ====================
     * setMouseListener
     * 
     * Método que seta o MouseListener para a célula na posição (row, col);
     * Torna a célula clicável e modifica o ponteiro do mouse ao passar por cima
     * ====================
     */
    void setMouseListener(int row, int col) {
        celulas[row][col].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moverPersonagem(row, col);
            }
        });
        celulas[row][col].activateMouseListener();
    }

    /*
     * ====================
     * resetMouseListener
     * 
     * Método que remove o MouseListener da célula na posição (row, col) e
     * das células ao redor dela
     * ====================
     */
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

    /*
     * ====================
     * removeMouseListenerFromCell
     * 
     * Método que remove os Mouse listeners da célula na posição (row, col)
     * ====================
     */
    private void removeMouseListenerFromCell(int row, int col) {
        Celula cell = celulas[row][col];
        if (cell.getMouseListeners().length > 0) {
            cell.deactivateMouseListener();
            cell.removeMouseListener(cell.getMouseListeners()[0]);
        }
    }

    /*
     * ====================
     * posicionarEntidades
     * 
     * Posicionamento das ENTIDADES no tabuleiro
     * ====================
     */
    public void posicionarEntidades(Inimigo[] inimigos, Armadilha[] armadilhas, Item[] itens) {
        int[] xInimigos = new int[7];
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            if (i == 0) {
                xInimigos[i] = random.nextInt(7) + 1;
            } else {
                xInimigos[i] = random.nextInt(8);
            }
        }
        for (int i = 0; i < 7; i++) {
            celulas[i][xInimigos[i]].setEntidade(inimigos[i]);
            celulas[i][xInimigos[i]].setBackground(Color.black);
        }
        for (int i = 0; i < armadilhas.length; i++) {
            int x = random.nextInt(8);
            int y = random.nextInt(8);
            if (celulas[y][x].getEntidade() == null) {
                celulas[y][x].setEntidade(armadilhas[i]);
                celulas[y][x].setBackground(Color.gray);
            } else {
                i--;
            }
        }

        for (int i = 0; i < itens.length; i++) {
            int x = random.nextInt(8);
            int y = random.nextInt(8);
            if (celulas[y][x].getEntidade() == null) {
                celulas[y][x].setEntidade(itens[i]);
                celulas[y][x].setBackground(Color.green);
            } else {
                i--;
            }
        }
    }

    /*
     * ====================
     * Funcionamento da DICA
     * ====================
     */
    public void usarDica() {
        resetMouseListener(jogador.getPosicaoY(), jogador.getPosicaoX());

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                celulas[row][col].activateMouseListener();// modifica ponteiro do mouse
                int finalCol = col;
                celulas[row][col].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        verificarColuna(finalCol);
                    }
                });
            }
        }
    }

    public void verificarColuna(int col) {
        int nArmdilhas = 0;
        for (int row = 0; row < 8; row++) {
            if (celulas[row][col].getEntidade() != null) {
                if (celulas[row][col].getEntidade() instanceof Armadilha) {
                    nArmdilhas++;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Há " + nArmdilhas + " armadilhas na coluna " + col);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                removeMouseListenerFromCell(i, j);
            }
        }

        setCelulasClicaveis(jogador.getPosicaoY(), jogador.getPosicaoX());
    }
}