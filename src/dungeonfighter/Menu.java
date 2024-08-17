
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menu extends JFrame {

    private final JButton botaoComecarJogo;
    private final JButton botaoDebugger;
    private final JButton botaoSair;

    public Menu() {
        super("Menu");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel painel = new JPanel();
        this.add(painel);

        this.botaoComecarJogo = new JButton("Começar Jogo");
        this.botaoDebugger = new JButton("Debugger");
        this.botaoSair = new JButton("Sair");

        botaoComecarJogo.addActionListener(e -> {

            this.dispose();
        });

        painel.add(this.botaoComecarJogo);
        painel.add(this.botaoDebugger);
        painel.add(this.botaoSair);

        this.setVisible(true);
    }
}
