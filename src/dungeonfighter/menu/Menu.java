package dungeonfighter.menu;

import dungeonfighter.DungeonFighter;
import java.awt.*;
import javax.swing.*;

public class Menu extends JPanel {

    private final ImageIcon imageMenu;
    private final BotoesIniciais botoesIniciais;
    private final CriarHeroiMenu criarHeroiMenu;

    public Menu() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        imageMenu = new ImageIcon("assets/gatomenuFinal.jpg");

        botoesIniciais = new BotoesIniciais(
                e -> comecarJogo(),
                e -> debug(),
                e -> System.exit(0));

        criarHeroiMenu = new CriarHeroiMenu();
        criarHeroiMenu.setVisible(false);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 0;

        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTH;
        add(botoesIniciais, gbc);

        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        criarHeroiMenu.setVisible(false);

        gbc.gridx = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 0;

        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.SOUTH;
        add(botoesIniciais, gbc);

        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        add(criarHeroiMenu, gbc);
    }

    private void comecarJogo() {
        botoesIniciais.setVisible(false);
        criarHeroiMenu.setVisible(true);

        revalidate();
        repaint();
    }

    public void novoJogo() {
        DungeonFighter.getInstanceDungeonFighter().setDebug();
        botoesIniciais.setVisible(true);
        criarHeroiMenu.setVisible(false);

        DungeonFighter.getInstanceDungeonFighter().setHeroi(null);

        revalidate();
        repaint();
    }

    private void debug() {
        DungeonFighter.getInstanceDungeonFighter().setDebug();
        comecarJogo();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image scaledImage = imageMenu.getImage();
        g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), this);

    }
}
