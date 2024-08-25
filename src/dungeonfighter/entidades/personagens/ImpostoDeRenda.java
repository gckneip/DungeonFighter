package dungeonfighter.entidades.personagens;

import javax.swing.ImageIcon;

import dungeonfighter.entidades.itens.Elixir;

public class ImpostoDeRenda extends Inimigo {
    public ImpostoDeRenda() {
        super("Imposto de Renda", 15, 5, 3, new ImageIcon("receita_federal.jpeg"), true, new Elixir(true, 10));
    }

    public int getDano() {
        return 5;
    }
}
