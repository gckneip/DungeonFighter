package menu;
import javax.swing.*;

public class AtributosMenu extends JPanel {
    private int atributosIniciais;
    private final BotaoAtributo botaoAtaque;
    private final BotaoAtributo botaoDefesa;
    private final BotaoAtributo botaoVida;
    private final JLabel atributosIniciaisLabel;

    public AtributosMenu() {
        atributosIniciais = 10;
        botaoAtaque = new BotaoAtributo("Ataque", 0, this);
        botaoDefesa = new BotaoAtributo("Defesa", 0, this);
        botaoVida = new BotaoAtributo("Vida", 0, this);

        atributosIniciaisLabel = new JLabel("Atributos Iniciais: " + atributosIniciais);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(atributosIniciaisLabel);
        add(botaoAtaque);
        add(botaoDefesa);
        add(botaoVida);
    }

    public int getAtributosIniciais() {
        return atributosIniciais;
    }

    public void decrementAtributosIniciais() {
        atributosIniciais--;
        updateAtributosIniciaisLabel();
    }
    
    public void incrementAtributosIniciais() {
        atributosIniciais++;
        updateAtributosIniciaisLabel();
    }

    private void updateAtributosIniciaisLabel() {
        atributosIniciaisLabel.setText("Atributos Iniciais: " + atributosIniciais);
    }
}