package dungeonfighter.entidades.itens;

import javax.swing.ImageIcon;

public class Elixir extends ItemDeCura {

    public Elixir(boolean visivel, int cura) {
        super("Elixir", new ImageIcon("elixir.jpg"), visivel, 5);
    }

}
