package dungeonfighter;

import dungeonfighter.batalha.*;
import dungeonfighter.entidades.armadilhas.Armadilha;
import dungeonfighter.entidades.armadilhas.BifeEnvenenado;
import dungeonfighter.entidades.itens.*;
import dungeonfighter.entidades.personagens.Arqueiro;
import dungeonfighter.entidades.personagens.Bruxo;
import dungeonfighter.entidades.personagens.Guerreiro;
import dungeonfighter.entidades.personagens.Heroi;
import dungeonfighter.entidades.personagens.Inimigo;
import dungeonfighter.entidades.personagens.MineDog;
import dungeonfighter.entidades.personagens.Muttley;
import dungeonfighter.entidades.personagens.Peludinho;
import dungeonfighter.entidades.personagens.scoobyLoo;
import dungeonfighter.entidades.armadilhas.AguaQuente;
import dungeonfighter.entidades.personagens.LetMeDoItForYou;
import dungeonfighter.menu.Menu;
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class DungeonFighter extends JFrame {

    private Menu menu;
    private Batalha batalha;
    private Tabuleiro tabuleiro;
    private Tabuleiro copiaTabuleiro;
    private Heroi heroi;
    private Heroi heroiCopia;
    private static DungeonFighter instanciaDungeonFighter;
    private Inimigo[] inimigos;
    private Armadilha[] armadilhas;
    private Item[] itens;
    private String nomeJogador;
    private boolean debug = false;

    private DungeonFighter() {
        super("Dungeon Fighter");
        inimigos = gerarInimigos();
        armadilhas = gerarArmadilhas();
        itens = gerarItens();

        menu = new Menu();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        getContentPane().add(menu, gbc);

        menu.setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        JFrame jogo = getInstanceDungeonFighter();
        jogo.setVisible(true);
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

    public void setHeroiCopia(Heroi heroi) {
        getInstanceDungeonFighter().heroiCopia = heroi;
    }

    public Heroi getHeroiCopia() {
        return getInstanceDungeonFighter().heroiCopia;
    }

    public void reiniciarJogo() {
        if (batalha != null) {
            batalha.setVisible(false);
            getContentPane().remove(batalha);
            batalha = null;
        }
        DungeonFighter jogo = DungeonFighter.getInstanceDungeonFighter();
        jogo.setHeroi(heroiCopia);

        if (jogo.getHeroi() instanceof Bruxo) {
            setHeroiCopia(new Bruxo());
        } else if (jogo.getHeroi() instanceof Guerreiro) {
            setHeroiCopia(new Guerreiro());
        } else if (jogo.getHeroi() instanceof Arqueiro) {
            setHeroiCopia(new Arqueiro());
        }

        tabuleiro.setVisible(false);
        getContentPane().remove(tabuleiro);
        tabuleiro = null;
        tabuleiro = copiaTabuleiro;
        tabuleiro.carregarHeroi();
        copiaTabuleiro = new Tabuleiro(tabuleiro);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        getContentPane().add(tabuleiro, gbc);
        tabuleiro.setVisible(true);
    }

    public void iniciarJogo() {
        menu.setVisible(false);
        remove(menu);
        gerarTabuleiro();
        tabuleiro.carregarHeroi();
        revalidate();
        repaint();
    }

    public void gerarTabuleiro() {
        tabuleiro = new Tabuleiro(inimigos, armadilhas, itens);
        copiaTabuleiro = new Tabuleiro(tabuleiro);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        getContentPane().add(tabuleiro, gbc);
        tabuleiro.setVisible(true);
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public Inimigo[] gerarInimigos() {
        Inimigo[] inimigos = new Inimigo[8];
        int qualInimigo;
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            qualInimigo = random.nextInt(4);
            switch (qualInimigo) {
                case 0:
                    inimigos[i] = new Muttley();
                    break;
                case 1:
                    inimigos[i] = new Peludinho();
                    break;
                case 2:
                    inimigos[i] = new scoobyLoo();
                    break;
                case 3:
                    inimigos[i] = new MineDog();
                    break;
            }
        }
        inimigos[7] = new LetMeDoItForYou();

        return inimigos;
    }

    public void setDebug() {
        this.debug = !this.debug;
    }

    public boolean getDebug() {
        return this.debug;
    }

    public Armadilha[] gerarArmadilhas() {
        Armadilha[] armadilhas = new Armadilha[7];
        armadilhas[0] = new BifeEnvenenado();
        armadilhas[1] = new AguaQuente();
        armadilhas[2] = new BifeEnvenenado();
        armadilhas[3] = new AguaQuente();
        armadilhas[4] = new BifeEnvenenado();
        armadilhas[5] = new AguaQuente();
        armadilhas[6] = new BifeEnvenenado();
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
            tabuleiro.inimigoDerrotado();
        } else {
            tabuleiro.fugir();
        }
        if (batalha != null) {
            batalha.setVisible(false);
            getContentPane().remove(batalha);
            batalha = null;
        }
        tabuleiro.setVisible(true);
    }

    public void novoJogo() {
        if (batalha != null) {
            batalha.setVisible(false);
            getContentPane().remove(batalha);
            batalha = null;
        }
        this.inimigos = gerarInimigos();
        this.armadilhas = gerarArmadilhas();
        this.itens = gerarItens();
        tabuleiro.setVisible(false);
        remove(menu);
        menu = new Menu();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        remove(tabuleiro);
        add(menu, gbc);
        menu.setVisible(true);
        revalidate();
        repaint();
        menu.novoJogo();
    }

    public void setNomeJogador(String nome) {
        nomeJogador = nome;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }
}
