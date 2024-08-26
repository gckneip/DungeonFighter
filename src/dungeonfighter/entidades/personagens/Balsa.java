
package dungeonfighter.entidades.personagens;

import javax.swing.ImageIcon;

import dungeonfighter.entidades.itens.Elixir;

public class Balsa extends Inimigo {

    public Balsa() {
        super("Balsa", 20, 10, 10, new ImageIcon("balsa-anglo.jpg"), true, new Elixir(true, 5));
    }
}