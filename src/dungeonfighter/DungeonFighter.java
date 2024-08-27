package dungeonfighter;

import dungeonfighter.batalha.*;
import dungeonfighter.entidades.personagens.Heroi;
import dungeonfighter.entidades.personagens.Inimigo;
import dungeonfighter.entidades.armadilhas.Armadilha;
import dungeonfighter.entidades.armadilhas.FilaBanco;
import dungeonfighter.entidades.personagens.Balsa;
import dungeonfighter.entidades.personagens.Bruxo;
import dungeonfighter.entidades.personagens.ImpostoDeRenda;
import dungeonfighter.entidades.itens.*;

import dungeonfighter.menu.Menu;
import java.awt.*;
import javax.swing.*;

public class DungeonFighter extends JFrame {

    private final Menu menu;
    private Batalha batalha;
    private final Tabuleiro tabuleiro;
    private Heroi heroi;
    private static DungeonFighter instanciaDungeonFighter;
    private final Inimigo[] inimigos;
    private final Armadilha[] armadilhas;
    private final Item[] itens;

    private DungeonFighter() {
        super("Dungeon Fighter");
        inimigos = gerarInimigos();
        armadilhas = gerarArmadilhas();
        itens = gerarItens();

        menu = new Menu();
        tabuleiro = new Tabuleiro(inimigos, armadilhas, itens);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        getContentPane().add(menu, gbc);
        getContentPane().add(tabuleiro, gbc);

        menu.setVisible(true);
        tabuleiro.setVisible(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static DungeonFighter getInstanceDungeonFighter() {
        if (instanciaDungeonFighter == null) {
            instanciaDungeonFighter = new DungeonFighter();
        }
        return instanciaDungeonFighter;
    }

    public void setHeroi(Heroi heroi) {
        getInstanceDungeonFighter().heroi = heroi;
    }

    public Heroi getHeroi() {
        return getInstanceDungeonFighter().heroi;
    }

    public void iniciarJogo() {
        menu.setVisible(false);
        tabuleiro.carregarHeroi();
        tabuleiro.setVisible(true);
    }

    public Inimigo[] gerarInimigos() {
        Inimigo[] inimigos = new Inimigo[8];
        inimigos[0] = new Balsa();
        inimigos[1] = new Balsa();
        inimigos[2] = new Balsa();
        inimigos[3] = new ImpostoDeRenda();
        inimigos[4] = new ImpostoDeRenda();
        inimigos[5] = new ImpostoDeRenda();
        inimigos[6] = new ImpostoDeRenda();
        inimigos[7] = new ImpostoDeRenda();
        return inimigos;
    }

    public Armadilha[] gerarArmadilhas() {
        Armadilha[] armadilhas = new Armadilha[6];
        armadilhas[0] = new FilaBanco();
        armadilhas[1] = new FilaBanco();
        armadilhas[2] = new FilaBanco();
        armadilhas[3] = new FilaBanco();
        armadilhas[4] = new FilaBanco();
        armadilhas[5] = new FilaBanco();
        return armadilhas;
    }

    public Item[] gerarItens() {
        Item[] itens = new Item[8];
        itens[0] = new Elixir(true, 5);
        itens[1] = new Elixir(true, 5);
        itens[2] = new Elixir(true, 5);
        itens[3] = new Elixir(true, 5);
        itens[4] = new Elixir(true, 5);
        itens[5] = new Elixir(true, 5);
        itens[6] = new Elixir(true, 5);
        itens[7] = new Elixir(true, 5);
        return itens;
    }

    public static void main(String[] args) {
        JFrame jogo = getInstanceDungeonFighter();
        jogo.setVisible(true);
    }

    public void iniciarBatalha(Inimigo inimigo) {
        menu.setVisible(false);
        tabuleiro.setVisible(false);

        batalha = new Batalha(this.heroi, inimigo);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        getContentPane().add(batalha, gbc);
        batalha.setVisible(true);

        revalidate();
        repaint();
    }

    public void finalizarBatalha(boolean ganhou) {
        if (ganhou) {
            System.err.println("sexo");
        } else {
            tabuleiro.fugir();
        }
        batalha.setVisible(false);
        tabuleiro.setVisible(true);
    }

    public void gameOver() {
        System.exit(0);
    }
}
