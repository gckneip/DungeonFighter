
import entidades.Entidade;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tabuleiro extends JFrame {

    private Celula[][] celulas;

    public Tabuleiro() {
        super("Batalha");

        celulas = new Celula[8][8];

        Entidade heroi = new Heroi("Heroi", 100, 10, 10, 10);

        celulas[0][0] = new Celula(heroi);

        for (int i = 1; i < 7; i++) {
            int column = RandomUtils.randomInt(1, 7);
            Entidade inimigo = new Inimigo("Inimigo", 100, 10, 10, 10);
            celulas[i][column] = new Celula(inimigo);
        }
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
