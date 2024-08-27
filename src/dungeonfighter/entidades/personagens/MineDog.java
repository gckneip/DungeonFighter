package dungeonfighter.entidades.personagens;

import dungeonfighter.entidades.itens.Elixir;
import javax.swing.ImageIcon;

public class MineDog extends Inimigo {
    public MineDog() {
        super("MineDog", 20, 10, 0, new ImageIcon("src/dungeonfighter/assets/mineDog.png"), true, new Elixir(true, 5));
    }
}
