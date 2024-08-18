package menu;
import java.awt.*;
import javax.swing.*;


public class EscolhaPersonagemBotao extends JButton {

    public EscolhaPersonagemBotao(String text, String imagePath) {
        super(text);
        ImageIcon originalImage = new ImageIcon(imagePath);
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        setIcon(scaledImageIcon);
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setPreferredSize(new Dimension(150, 300));
    }
}
