package dungeonfighter;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Jogador extends JPanel {
    private int posicaoX;
    private int posicaoY;
    private boolean podeMover = true;

    public Jogador(int posicaoX, int posicaoY, ImageIcon imageIcon) {
        setLayout(new GridBagLayout());

        setBackground(Color.MAGENTA);

        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;

        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image scaledImage = imageIcon.getImage();
                g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;

        add(imagePanel, gbc);
        // setSize(50, 50);
    }

    public int getPosicaoX() {
        return posicaoX;
    }

    public void setPosicaoX(int posicaoX) {
        this.posicaoX = posicaoX;
    }

    public int getPosicaoY() {
        return posicaoY;
    }

    public void setPosicaoY(int posicaoY) {
        this.posicaoY = posicaoY;
    }

    public void mover(int y, int x) {
        this.posicaoX = x;
        this.posicaoY = y;
    }

    public void setPodeMover(boolean podeMover) {
        this.podeMover = podeMover;
    }

    public boolean getPodeMover() {
        return podeMover;
    }
}
