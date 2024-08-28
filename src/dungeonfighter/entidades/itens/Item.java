package dungeonfighter.entidades.itens;

import dungeonfighter.entidades.Entidade;
import dungeonfighter.entidades.personagens.Heroi;
import javax.swing.ImageIcon;

public abstract class Item extends Entidade {

    public Item(String nome, ImageIcon imagem, boolean visivel) {
        super(nome, imagem, visivel);
    }

    public abstract void efeito(Heroi heroi);

    public ImageIcon getIcone() {
        return super.getIcone();
    }
}
