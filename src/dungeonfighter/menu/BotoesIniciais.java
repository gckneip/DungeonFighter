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

        String imagePath = "assets/botao.png";
        
        botaoComecarJogo = new JButton("Começar Jogo");
        botaoDebugger = new JButton("Debugger");
        botaoSair = new JButton("Sair");

        botaoComecarJogo.setForeground(Color.WHITE);
        botaoDebugger.setForeground(Color.WHITE);
        botaoSair.setForeground(Color.WHITE);

        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        botaoComecarJogo.setFont(buttonFont);
        botaoDebugger.setFont(buttonFont);
        botaoSair.setFont(buttonFont);

        botaoComecarJogo.setOpaque(false);
        botaoComecarJogo.setContentAreaFilled(false);
        botaoComecarJogo.setBorderPainted(false);

        botaoDebugger.setOpaque(false);
        botaoDebugger.setContentAreaFilled(false);
        botaoDebugger.setBorderPainted(false);

        botaoSair.setOpaque(false);
        botaoSair.setContentAreaFilled(false);
        botaoSair.setBorderPainted(false);
        botaoComecarJogo.setIcon(new ImageIcon(imagePath));
        botaoDebugger.setIcon(new ImageIcon(imagePath));
        botaoSair.setIcon(new ImageIcon(imagePath));

        botaoComecarJogo.setHorizontalTextPosition(SwingConstants.CENTER);
        botaoComecarJogo.setVerticalTextPosition(SwingConstants.CENTER);

        botaoDebugger.setHorizontalTextPosition(SwingConstants.CENTER);
        botaoDebugger.setVerticalTextPosition(SwingConstants.CENTER);

        botaoSair.setHorizontalTextPosition(SwingConstants.CENTER);
        botaoSair.setVerticalTextPosition(SwingConstants.CENTER);

        botaoComecarJogo.addActionListener(startGameListener);
        botaoDebugger.addActionListener(debuggerListener);
        botaoSair.addActionListener(exitListener);

        botaoComecarJogo.setPreferredSize(new Dimension(200, 66));
        botaoDebugger.setPreferredSize(new Dimension(200, 66));
        botaoSair.setPreferredSize(new Dimension(200, 66));

        botaoComecarJogo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoComecarJogo.setBackground(Color.YELLOW);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoComecarJogo.setBackground(UIManager.getColor("control"));
            }
        });

        botaoDebugger.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoDebugger.setBackground(Color.YELLOW);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoDebugger.setBackground(UIManager.getColor("control"));
            }
        });

        botaoSair.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoSair.setBackground(Color.YELLOW);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoSair.setBackground(UIManager.getColor("control"));
            }
        });
        

        add(botaoComecarJogo);
        add(botaoDebugger);
        add(botaoSair);

        setOpaque(false);
    }
}
