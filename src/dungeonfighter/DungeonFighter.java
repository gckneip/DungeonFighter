
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DungeonFighter {

    private JFrame menu;
    private JFrame batalha;
    private JFrame tabuleiro;

    public DungeonFighter() {
        // Initialize the frames
        menu = new Menu();
        batalha = new JFrame("Frame 2");
        tabuleiro = new JFrame("Frame 3");

        batalha.setLayout(new FlowLayout());
        tabuleiro.setLayout(new FlowLayout());

        // Create the buttons
        JButton button1 = new JButton("Go to Frame 2");
        JButton button2 = new JButton("Go to Frame 3");
        JButton button3 = new JButton("Go to Frame 1");

        // Add action listeners to the buttons
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu.setVisible(false);
                batalha.setVisible(true);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                batalha.setVisible(false);
                tabuleiro.setVisible(true);
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabuleiro.setVisible(false);
                menu.setVisible(true);
            }
        });

        // Add the buttons to the frames
        menu.add(button1);
        batalha.add(button2);
        tabuleiro.add(button3);

        // Set default close operation
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        batalha.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabuleiro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set frame sizes
        menu.setSize(300, 200);
        batalha.setSize(300, 200);
        tabuleiro.setSize(300, 200);

        // Make menu visible initially
        menu.setVisible(true);
    }

    public static void main(String[] args) {
        new DungeonFighter();
    }
}
