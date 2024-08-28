package dungeonfighter.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class BotaoAtributo extends JPanel {
    private int valor;
    private int valorInicial;
    private final JButton botaoMais;
    private final JButton botaoMenos;
    private final JLabel labelValor;

    public BotaoAtributo(String nome, int v, AtributosMenu atributosMenu) {
        this.valor = v;
        setLayout(new FlowLayout());
        setOpaque(false);

        JLabel labelNome = new JLabel(nome);
        labelValor = new JLabel(String.valueOf(valor));
        botaoMais = new JButton("+");
        botaoMenos = new JButton("-");

        botaoMais.addActionListener((ActionEvent e) -> {
            if (atributosMenu.getAtributosExtras() > 0) {
                valor++;
                atributosMenu.decrementAtributosIniciais();
                updateValor();
            }
        });

        botaoMenos.addActionListener((ActionEvent e) -> {
            if (valor > valorInicial) {
                valor--;
                atributosMenu.incrementAtributosIniciais();
                updateValor();
            }
        });

        add(labelNome);
        add(labelValor);
        add(botaoMenos);
        add(botaoMais);
    }

    public void setValorInicial(int valorInicial) {
        valor = valorInicial;
        this.valorInicial = valorInicial;
        updateValor();
    }

    private void updateValor() {
        labelValor.setText(String.valueOf(valor));
    }

    public int getValor() {
        return valor;
    }
}