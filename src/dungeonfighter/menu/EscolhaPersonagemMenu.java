package menu;

import javax.swing.JPanel;

public class EscolhaPersonagemMenu extends JPanel {
    private final EscolhaPersonagemBotao bruxoButton;
    private final EscolhaPersonagemBotao guerreiroButton;
    private final EscolhaPersonagemBotao arqueiroButton;

    public EscolhaPersonagemMenu() {
        bruxoButton = new EscolhaPersonagemBotao("Bruxo", "src/dungeonfighter/assets/bruxo.png");
        guerreiroButton = new EscolhaPersonagemBotao("Guerreiro", "src/dungeonfighter/assets/guerreiro.png");
        arqueiroButton = new EscolhaPersonagemBotao("Arqueiro", "src/dungeonfighter/assets/arqueiro.jpg");

        
        add(bruxoButton);
        add(guerreiroButton);
        add(arqueiroButton);
    }
}
