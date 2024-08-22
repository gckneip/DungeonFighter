import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tabuleiro extends JFrame {
    private Celula[][] celulas; // 2D array to store the grid of Celula objects
    private ImageIcon imageIcon;

    public Tabuleiro() {
        // Initialize the 2D array with dimensions 8x8
        celulas = new Celula[8][8];

        // Set up the JFrame
        setTitle("8x8 Grid Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8)); // 8x8 grid layout
        setSize(400, 400);

        // Create the 8x8 grid of Celula objects
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                celulas[row][col] = new Celula();
                celulas[row][col].setBackground(Color.RED); // Set background color
                celulas[row][col].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

                // Add a MouseListener to each cell
                int finalRow = row;
                int finalCol = col;
                celulas[row][col].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // Action when a cell is clicked
                        JOptionPane.showMessageDialog(null,
                                "Cell clicked at row " + finalRow + ", column " + finalCol);
                        moverPersonagem(finalRow, finalCol);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        celulas[finalRow][finalCol].setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor on hover
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        celulas[finalRow][finalCol].setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Revert cursor when
                                                                                                  // exiting
                    }
                });

                // Add the cell to the grid layout
                add(celulas[row][col]);
            }
        }

        // Load an image and set it in the first cell
        imageIcon = new ImageIcon("src/dungeonfighter/entidades/personagens/guerreiro.jpeg"); // Replace with
                                                                                              // the correct
                                                                                              // image
        // path
        JLabel imageLabel = new JLabel(imageIcon);
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);

        // Add the image panel to the first cell
        celulas[0][0].setLayout(new BorderLayout());
        celulas[0][0].add(imagePanel, BorderLayout.CENTER);

        setVisible(true); // Make the JFrame visible
    }

    public void moverPersonagem(int row, int col) {
        // Remove the image from the current cell
        celulas[0][0].removeAll();
        celulas[0][0].revalidate();
        celulas[0][0].repaint();

        // Add the image to the new cell
        JLabel imageLabel = new JLabel(imageIcon);
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);

        celulas[row][col].setLayout(new BorderLayout());
        celulas[row][col].add(imagePanel, BorderLayout.CENTER);
        celulas[row][col].revalidate();
        celulas[row][col].repaint();
    }

    public static void main(String[] args) {
        // Instantiate and display the Tabuleiro JFrame
        new Tabuleiro();
    }
}
