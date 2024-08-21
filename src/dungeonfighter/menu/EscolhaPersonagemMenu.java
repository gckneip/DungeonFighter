package dungeonfighter.menu;

import dungeonfighter.DungeonFighter;
import dungeonfighter.entidades.personagens.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class EscolhaPersonagemMenu extends JPanel implements ActionListener {
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

    @Override
    public void actionPerformed(ActionEvent e) {
        DungeonFighter jogo =        // Determine which button was clicked and create the appropriate Heroi
        DungeonFighter.getInstanceDungeonFighter();
        Heroi heroi = null;

        if (e.getSource() == bruxoButton) {
            heroi = new Bruxo();
        } else if (e.getSource() == guerreiroButton) {
            heroi = new Guerreiro();
        } else if (e.getSource() == arqueiroButton) {
            heroi = new Arqueiro();
        }

        jogo.setHeroi(heroi);
    }
}
