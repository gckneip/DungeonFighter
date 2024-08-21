package dungeonfighter.menu;

import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel {

    private final ImageIcon imageMenu;
    private final JLabel image;
    private final BotoesIniciais botoesIniciais;
    private final CriarHeroiMenu criarHeroiMenu;

    public Menu() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        String imagePath = "src/dungeonfighter/assets/dungeonFighterLogo2.jpg";
        imageMenu = new ImageIcon(imagePath);
        image = new JLabel(imageMenu);
        image.setHorizontalAlignment(JLabel.CENTER);

        // Create button panel
        botoesIniciais = new BotoesIniciais(
            e -> comecarJogo(),
            e -> debug(),
            e -> System.exit(0)
        );
        botoesIniciais.setBackground(Color.GREEN);

        // Create side-by-side panel
        criarHeroiMenu = new CriarHeroiMenu();
        criarHeroiMenu.setBackground(Color.ORANGE);
        criarHeroiMenu.setVisible(false); // Initially hidden

        // Add image at the top
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.NORTH;
        add(image, gbc);

        // Add botoesIniciais
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        add(botoesIniciais, gbc);

        // Add criarHeroiMenu
        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(100, 500, 100, 500);
        add(criarHeroiMenu, gbc);
    }

    private void comecarJogo() {
        image.setVisible(false);
        botoesIniciais.setVisible(false);
        criarHeroiMenu.setVisible(true);
        // Additional start game logic
    }

    private void debug() {
        // Debugging logic
    }
}
