package dungeonfighter.entidades.personagens;

import dungeonfighter.entidades.itens.Elixir;
import javax.swing.ImageIcon;

public class scoobyLoo extends Inimigo {
    public scoobyLoo() {
        super("Scooby Loo", 20, 10, 0, new ImageIcon ("src/dungeonfighter/assets/scoobyLoo.png"), true, new Elixir(true, 5));
    }
}
