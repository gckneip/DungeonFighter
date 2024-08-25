import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Jogador extends JPanel {
    private int posicaoX;
    private int posicaoY;

    public Jogador(int posicaoX, int posicaoY, ImageIcon imageIcon) {
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
        add(new JLabel(imageIcon));
        setSize(50, 50);
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
}
