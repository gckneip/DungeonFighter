package entidades.itens;

import entidades.Entidade;
import entidades.personagens.Heroi;
import javax.swing.ImageIcon;

public abstract class Item extends Entidade {

    public Item(String nome, ImageIcon imagem, boolean visivel) {
        super(nome, imagem, visivel);
    }

    public abstract void efeito(Heroi heroi);
}
