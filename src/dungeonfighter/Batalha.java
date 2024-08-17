
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Batalha extends JFrame {

    private final JButton botaoAtacar;
    private final JButton botaoFugir;
    private final JButton botaoUsarItem;

    public Batalha() {
        super("Batalha");

        botaoAtacar = new JButton("Atacar");
        botaoFugir = new JButton("Fugir");
        botaoUsarItem = new JButton("Usar Item");

        JPanel painel = new JPanel();
        painel.add(botaoAtacar);
        painel.add(botaoFugir);
        painel.add(botaoUsarItem);

        add(painel);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
