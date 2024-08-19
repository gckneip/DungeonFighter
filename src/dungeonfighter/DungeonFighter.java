
import java.awt.*;
import javax.swing.*;
import menu.Menu;

public class DungeonFighter extends JFrame {

    private final Menu menu;
    private final Batalha batalha;
    private final Tabuleiro tabuleiro;

    public DungeonFighter() {
        super("Dungeon Fighter");

        menu = new Menu();
        batalha = new Batalha();
        tabuleiro = new Tabuleiro();

        getContentPane().setLayout(new CardLayout());
        getContentPane().add(menu, "Menu");
        getContentPane().add(batalha, "Batalha");
        getContentPane().add(tabuleiro, "Tabuleiro");

        menu.setVisible(true);
        batalha.setVisible(false);
        tabuleiro.setVisible(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static void main(String[] args) {
        JFrame jogo = new DungeonFighter();
        jogo.setVisible(true);
    }
}
