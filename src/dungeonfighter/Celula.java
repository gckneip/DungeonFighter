
import java.awt.Dimension;

import javax.swing.JPanel;

import entidades.Entidade;

public class Celula extends JPanel {

    private Entidade entidade;

    public Celula() {
        super();
        setPreferredSize(new Dimension(20, 20));
    }

}