package dungeonfighter.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EscolhaPersonagemMenu extends JPanel implements ActionListener {
    private final EscolhaPersonagemBotao bruxoButton;
    private final EscolhaPersonagemBotao guerreiroButton;
    private final EscolhaPersonagemBotao arqueiroButton;
    private tipoHeroi escolhido;
    private EscolhaPersonagemBotao botaoSelecionado;

    public EscolhaPersonagemMenu() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        bruxoButton = new EscolhaPersonagemBotao("Bruxo", "src/dungeonfighter/assets/bruxo.png");
        guerreiroButton = new EscolhaPersonagemBotao("Guerreiro", "src/dungeonfighter/assets/guerreiro.png");
        arqueiroButton = new EscolhaPersonagemBotao("Arqueiro", "src/dungeonfighter/assets/arqueiro.jpg");

        bruxoButton.addActionListener(this);
        guerreiroButton.addActionListener(this);
        arqueiroButton.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(bruxoButton, gbc);

        gbc.gridx = 1;
        add(guerreiroButton, gbc);

        gbc.gridx = 2; 
        add(arqueiroButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EscolhaPersonagemBotao clickedButton = null;

        if (e.getSource() == bruxoButton) {
            clickedButton = bruxoButton;
            setEscolhido(tipoHeroi.BRUXO);
        } else if (e.getSource() == guerreiroButton) {
            clickedButton = guerreiroButton;
            setEscolhido(tipoHeroi.GUERREIRO);
        } else if (e.getSource() == arqueiroButton) {
            clickedButton = arqueiroButton;
            setEscolhido(tipoHeroi.ARQUEIRO);
        }

        if (clickedButton != null) {
            setBotaoSelecionado(clickedButton);
        }
    }

    public tipoHeroi getEscolhido() {
        return escolhido;
    }

    public void setEscolhido(tipoHeroi escolhido) {
        this.escolhido = escolhido;
    }

    private void setBotaoSelecionado(EscolhaPersonagemBotao clickedButton) {
        if (botaoSelecionado != null) {
            botaoSelecionado.setSelected(false);
        }
        
        clickedButton.setSelected(true);
        botaoSelecionado = clickedButton;
    }
}
