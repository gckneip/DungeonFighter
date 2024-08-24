package dungeonfighter.menu;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BotoesIniciais extends JPanel {
    private final JButton botaoComecarJogo;
    private final JButton botaoDebugger;
    private final JButton botaoSair;

    public BotoesIniciais(ActionListener startGameListener, ActionListener debuggerListener, ActionListener exitListener) {
        setLayout(new FlowLayout());
        botaoComecarJogo = new JButton("Começar Jogo");
        botaoDebugger = new JButton("Debugger");
        botaoSair = new JButton("Sair");

        botaoComecarJogo.addActionListener(startGameListener);
        botaoDebugger.addActionListener(debuggerListener);
        botaoSair.addActionListener(exitListener);

        add(botaoComecarJogo);
        add(botaoDebugger);
        add(botaoSair);
    }
}
