
import entidades.Entidade;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Random;

public class Tabuleiro extends JFrame {

    private Celula[][] celulas;

    public Tabuleiro() {
        super("Batalha");

        celulas = new Celula[8][8];

        Entidade heroi = new Heroi("Heroi", 100, 10, 10, 10);

        celulas[0][0] = new Celula(heroi);
        Random random = new Random();

        for (int i = 1; i < 7; i++) {
            int column = random.nextInt(8);
              
      
                  }
            setSize(300, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
    }
}
