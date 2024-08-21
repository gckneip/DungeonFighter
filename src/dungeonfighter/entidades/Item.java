package dungeonfighter.entidades;

import dungeonfighter.entidades.personagens.Personagem;
import javax.swing.ImageIcon;

public abstract class Item extends Entidade {

    public Item(String nome, ImageIcon imagem, boolean visivel) {
        super(nome, imagem, visivel);
    }

    public abstract void efeito(Personagem personagem);
}
