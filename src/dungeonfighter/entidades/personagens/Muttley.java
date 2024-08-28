package dungeonfighter.entidades.personagens;

import dungeonfighter.entidades.itens.Elixir;
import javax.swing.ImageIcon;

public class Muttley extends Inimigo {
    public Muttley() {
        super("Muttley", 7, 3, 6, new ImageIcon("assets/muttley.jpg"), new Elixir(true, 2));
    }
}
