import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DungeonFighter {

    private JFrame menu;
    private Tabuleiro tabuleiro;

    public DungeonFighter() {
        menu = new JFrame("Menu");
        tabuleiro = new Tabuleiro();
        tabuleiro.setVisible(false);

        // Create the button
        JButton button1 = new JButton("Go to Tabuleiro");

        // Add action listener to the button
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Remove the button from the menu
                menu.remove(button1);

                // Add the Tabuleiro to the menu
                menu.add(tabuleiro);

                // Make Tabuleiro visible
                tabuleiro.setVisible(true);

                // Adjust the size of the Tabuleiro and the menu frame
                tabuleiro.setSize(new Dimension(400, 400));
                menu.setSize(new Dimension(400, 400));

                // Revalidate and repaint the menu to apply the changes
                menu.revalidate();
                menu.repaint();
            }
        });

        // Add the button to the menu frame
        menu.add(button1);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set frame size
        menu.setSize(300, 200);

        // Make menu visible initially
        menu.setVisible(true);
    }

    public static void main(String[] args) {
        new DungeonFighter();
    }
}
