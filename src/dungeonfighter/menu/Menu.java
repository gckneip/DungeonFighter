package dungeonfighter.menu;

import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel {

    private final ImageIcon imageMenu;
    private final BotoesIniciais botoesIniciais;
    private final CriarHeroiMenu criarHeroiMenu;
    private final JPanel imagePanel;

    public Menu() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        String imagePath = "src/dungeonfighter/assets/dungeonFighterLogo2.jpg";
        imageMenu = new ImageIcon(imagePath);

        imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image scaledImage = imageMenu.getImage();
                g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        botoesIniciais = new BotoesIniciais(
            e -> comecarJogo(),
            e -> debug(),
            e -> System.exit(0)
        );

        criarHeroiMenu = new CriarHeroiMenu();
        criarHeroiMenu.setVisible(false); 

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.5; 
        add(imagePanel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1; 
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE; 
        gbc.weighty = 0; 
        add(botoesIniciais, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.CENTER;     
        add(criarHeroiMenu, gbc); 
    }

    private void comecarJogo() {
        imagePanel.setVisible(false);
        botoesIniciais.setVisible(false);
        criarHeroiMenu.setVisible(true);

        revalidate();
        repaint();
    }

    private void debug() {
    }
}
