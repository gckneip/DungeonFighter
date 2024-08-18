package menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class BotaoAtributo extends JPanel {
    private int valor;
    private final JButton botaoMais;
    private final JButton botaoMenos;
    private final JLabel labelValor;

    public BotaoAtributo(String nome, int v, AtributosMenu atributosMenu) {
        this.valor = v;
        setLayout(new FlowLayout());

        JLabel labelNome = new JLabel(nome);
        labelValor = new JLabel(String.valueOf(valor));
        botaoMais = new JButton("+");
        botaoMenos = new JButton("-");

        botaoMais.addActionListener((ActionEvent e) -> {
            if (atributosMenu.getAtributosIniciais() > 0) {
                valor++;
                atributosMenu.decrementAtributosIniciais();
                updateValor();
            }
        });

        botaoMenos.addActionListener((ActionEvent e) -> {
            if (valor > 0) {
                valor--;
                atributosMenu.incrementAtributosIniciais();
                updateValor();
            }
        });

        add(labelNome);
        add(botaoMenos);
        add(labelValor);
        add(botaoMais);
    }

    private void updateValor() {
        labelValor.setText(String.valueOf(valor));
    }
}