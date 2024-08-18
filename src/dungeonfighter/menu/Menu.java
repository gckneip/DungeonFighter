package menu;
import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel {

    private final JButton botaoComecarJogo;
    private final JButton botaoDebugger;
    private final JButton botaoSair;
    private EscolhaPersonagemMenu escolhaPersonagemMenu;
    private AtributosMenu atributosMenu;
    private final ImageIcon imageMenu;

    public Menu() {

        setLayout(new BorderLayout());

        imageMenu = new ImageIcon(getClass().getResource("/assets/dungeonFighterLogo2.jpg"));
        JLabel image = new JLabel(imageMenu);
        image.setHorizontalAlignment(JLabel.CENTER); 

        botaoComecarJogo = new JButton("Começar Jogo");
        botaoDebugger = new JButton("Debugger");
        botaoSair = new JButton("Sair");
        escolhaPersonagemMenu = new EscolhaPersonagemMenu();
        atributosMenu = new AtributosMenu();

        atributosMenu.setVisible(false);
        escolhaPersonagemMenu.setVisible(false);

        botaoSair.addActionListener(e -> System.exit(0));

        botaoComecarJogo.addActionListener(e -> {
            escolhaPersonagemMenu.setVisible(true);
            atributosMenu.setVisible(true);
            botaoComecarJogo.setVisible(false);
            botaoDebugger.setVisible(false);
            botaoSair.setVisible(false);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(botaoComecarJogo);
        buttonPanel.add(botaoDebugger);
        buttonPanel.add(botaoSair);

        JPanel escolhaPersonagemMenuPanel = new JPanel();
        escolhaPersonagemMenuPanel.setLayout(new BoxLayout(escolhaPersonagemMenuPanel, BoxLayout.Y_AXIS));
        escolhaPersonagemMenuPanel.add(escolhaPersonagemMenu);
        escolhaPersonagemMenuPanel.add(atributosMenu);

        botaoComecarJogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoDebugger.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(image, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(escolhaPersonagemMenuPanel, BorderLayout.CENTER);
        // this.add(escolhaPersonagemMenu);
        // this.add(atributosMenu);
    }
}
