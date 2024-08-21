package dungeonfighter.entidades.personagens;

import dungeonfighter.entidades.itens.Item;
import javax.swing.ImageIcon;

public abstract class Inimigo extends Personagem {
    private Item espolio;

    public Inimigo(String nome, int vida, int ataque, int defesa, ImageIcon imagem, boolean visivel) {
        super(vida, defesa, ataque, nome, imagem, visivel);
    }

    public void setEspolio(Item espolio) {
        this.espolio = espolio;
    }

    public Item dropEspolio() {
        return espolio;
    }

    public void morrer() {
        this.dropEspolio();
        super.setVisivel(false);
    }
}