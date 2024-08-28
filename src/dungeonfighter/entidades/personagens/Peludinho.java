package dungeonfighter.entidades.personagens;

import dungeonfighter.entidades.itens.Elixir;
import javax.swing.ImageIcon;

public class Peludinho extends Inimigo {
    public Peludinho() {
        super("Peludinho", 15, 5, 10, new ImageIcon("assets/peludinho.jpg"),
                new Elixir(true, 8));
    }
}
