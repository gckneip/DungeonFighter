import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tabuleiro extends JPanel {
    private Celula[][] celulas; // 2D array to store the grid of Celula objects
    private Jogador jogador;

    public Tabuleiro() {
        // Initialize the 2D array with dimensions 8x8
        celulas = new Celula[8][8];
        setLayout(new GridLayout(8, 8)); // 8x8 grid layout
        setSize(400, 400);

        // Create the 8x8 grid of Celula objects
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                celulas[row][col] = new Celula();
                celulas[row][col].setBackground(Color.RED); // Set background color
                celulas[row][col].setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));

                // Add the cell to the grid layout
                add(celulas[row][col]);
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
        moverPersonagem(0, 0);
        // celulas[0][0].add(imagePanel, BorderLayout.CENTER);

        setVisible(true); // Make the JFrame visible
    }

    public void moverPersonagem(int row, int col) {
        // Remove the image from the current cell
        int x = this.jogador.getPosicaoX();
        int y = this.jogador.getPosicaoY();

        celulas[y][x].removeAll();
        celulas[y][x].revalidate();
        celulas[y][x].repaint();
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
                JOptionPane.showMessageDialog(null, "Cell clicked at row " + row + ", column " + col);
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

    public static void main(String[] args) {
        // Instantiate and display the Tabuleiro JFrame
        new Tabuleiro();

    }
}
