package dungeonfighter.menu;

import dungeonfighter.DungeonFighter;
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

        // Adding action listeners
        bruxoButton.addActionListener(this);
        guerreiroButton.addActionListener(this);
        arqueiroButton.addActionListener(this);

        // Adding buttons to the panel
        add(bruxoButton);
        add(guerreiroButton);
        add(arqueiroButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the singleton instance of DungeonFighter
        DungeonFighter jogo = DungeonFighter.getInstanceDungeonFighter();

        // Determine which button was clicked and create the appropriate Heroi
        // if (e.getSource() == bruxoButton) {
        //     Heroi bruxo = new Heroi("Bruxo", 100, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        //     jogo.setHeroi(bruxo);
        // } else if (e.getSource() == guerreiroButton) {
        //     Heroi guerreiro = HeroiFactory.createHeroi("Guerreiro");
        //     jogo.setHeroi(guerreiro);
        // } else if (e.getSource() == arqueiroButton) {
        //     Heroi arqueiro = HeroiFactory.createHeroi("Arqueiro");
        //     jogo.setHeroi(arqueiro);
        // }
    }
}
