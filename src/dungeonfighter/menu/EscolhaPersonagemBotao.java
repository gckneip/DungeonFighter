package dungeonfighter.menu;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class EscolhaPersonagemBotao extends JButton {

    private final Dimension originalSize;
    private final Dimension selectedSize;
    private final Color defaultBackground;
    private final Color hoverBackground;
    private final Color selectedBackground;
    private boolean selected = false;

    public EscolhaPersonagemBotao(String text, String imagePath) {
        super(text);
        setOpaque(true);

        ImageIcon originalImage = new ImageIcon(imagePath);
        Image scaledImage = originalImage.getImage().getScaledInstance(150, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        
        setIcon(scaledImageIcon);
        
        setVerticalTextPosition(SwingConstants.BOTTOM);
        setHorizontalTextPosition(SwingConstants.CENTER);
        
        originalSize = new Dimension(150, 300);
        selectedSize = new Dimension(160, 310);
        setPreferredSize(originalSize);
        
        defaultBackground = new Color(173, 216, 230);
        hoverBackground = new Color(100, 149, 237); 
        selectedBackground = new Color(255, 215, 0);
        
        setBorderPainted(true);
        setFocusPainted(false);
        setContentAreaFilled(true);
        setOpaque(true);
        setBackground(defaultBackground);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                if (selected) {
                    return; 
                }
                setPreferredSize(selectedSize);
                setBackground(hoverBackground); 
                revalidate(); 
                repaint(); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (selected) {
                    return; 
                }
                setPreferredSize(originalSize);
                setBackground(defaultBackground); 
                revalidate(); 
                repaint(); 
            }
        });

        addActionListener(e -> {
            setSelected(true);
        });
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
        if (selected) {
            setBackground(selectedBackground);
            setPreferredSize(selectedSize);
        } else {
            setBackground(defaultBackground);
            setPreferredSize(originalSize);
        }
        revalidate();
        repaint();
    }

    @Override
    public boolean isSelected() {
        return selected;
    }
}
