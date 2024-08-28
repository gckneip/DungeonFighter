package dungeonfighter;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Chefao extends JPanel {

    public Chefao(ImageIcon imageIcon) {
        setLayout(new GridBagLayout());

        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image scaledImage = imageIcon.getImage();
                g.drawImage(scaledImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;

        add(imagePanel, gbc);
    }
}