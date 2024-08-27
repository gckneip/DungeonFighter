package dungeonfighter;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import dungeonfighter.entidades.Entidade;

public class Celula extends JPanel {

    private Entidade entidade;

    private MouseAdapter mouseAdapter;

    public Celula() {
        super();
        setPreferredSize(new Dimension(20, 20));

        // Define the MouseAdapter that handles mouse events
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        };
    }

    public void activateMouseListener() {
        this.addMouseListener(mouseAdapter);
    }

    // Method to deactivate the mouse listener
    public void deactivateMouseListener() {
        this.removeMouseListener(mouseAdapter);
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public Entidade getEntidade() {
        return entidade;
    }
}
