package dungeonfighter;

import dungeonfighter.entidades.personagens.Heroi;
import dungeonfighter.menu.Menu;
import java.awt.*;
import javax.swing.*;

public class DungeonFighter extends JFrame {

    private final Menu menu;
    private final Batalha batalha;
    private final Tabuleiro tabuleiro;
    private Heroi heroi;
    private static DungeonFighter instanciaDungeonFighter;

    private DungeonFighter() {
        super("Dungeon Fighter");

        menu = new Menu();
        batalha = new Batalha();
        tabuleiro = new Tabuleiro();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        getContentPane().add(menu, gbc);
        getContentPane().add(batalha, gbc);
        getContentPane().add(tabuleiro, gbc);

        menu.setVisible(true);
        batalha.setVisible(false);
        tabuleiro.setVisible(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
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
        batalha.setVisible(false);
        tabuleiro.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame jogo = getInstanceDungeonFighter();
        jogo.setVisible(true);
    }
}
