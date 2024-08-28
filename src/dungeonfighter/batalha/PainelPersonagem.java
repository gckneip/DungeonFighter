package dungeonfighter.batalha;

import dungeonfighter.entidades.personagens.Personagem;
import java.awt.*;
import javax.swing.*;

public class PainelPersonagem extends JPanel {
    private int vida;
    private final JLabel vidaLabel;
    private final JLabel ataqueLabel;
    private final JLabel defesaLabel;
    private final JLabel nomeLabel;
    private final JPanel imagePanel;
    
    public PainelPersonagem(Personagem personagem, String nome) {
        vida = personagem.getVida();

        setLayout(new GridBagLayout());

        imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image scaledImage = personagem.getIcone().getImage();
                g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 4.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 50, 10, 50);

        add(imagePanel, gbc);

        JPanel informacoes = new JPanel();
        informacoes.setLayout(new GridBagLayout());
        informacoes.setBackground(Color.GRAY);
        informacoes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        GridBagConstraints gbcInfo = new GridBagConstraints();
        gbcInfo.fill = GridBagConstraints.BOTH;
        gbcInfo.weightx = 1.0;
        gbcInfo.weighty = 1.0;
        gbcInfo.anchor = GridBagConstraints.CENTER;
        gbcInfo.insets = new Insets(10, 20, 10, 20);

        nomeLabel = new JLabel(nome);
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        nomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        vidaLabel = new JLabel("Vida: " + this.vida);
        vidaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        ataqueLabel = new JLabel("Ataque: " + personagem.getAtaque());
        ataqueLabel.setHorizontalAlignment(SwingConstants.CENTER);

        defesaLabel = new JLabel("Defesa: " + personagem.getDefesa());
        defesaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        gbcInfo.gridy = 1;
        gbcInfo.gridx = 2;
        informacoes.add(nomeLabel, gbcInfo);

        gbcInfo.gridy = 2;
        gbcInfo.gridx = 1;
        informacoes.add(vidaLabel, gbcInfo);

        gbcInfo.gridy = 2;
        gbcInfo.gridx = 2;
        informacoes.add(ataqueLabel, gbcInfo);

        gbcInfo.gridy = 2;
        gbcInfo.gridx = 3;
        informacoes.add(defesaLabel, gbcInfo);

        gbc.weighty = 1.0;
        gbc.gridy = 1;
        add(informacoes, gbc);

    }

    public void atualizarVida(int vida) {
        this.vida = vida;
        vidaLabel.setText("Vida: " + this.vida);
    }
    
}
