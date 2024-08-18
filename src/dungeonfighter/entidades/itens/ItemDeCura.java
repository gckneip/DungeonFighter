package entidades.itens;

import entidades.personagens.Heroi;
import javax.swing.ImageIcon;

public class ItemDeCura extends Item {

    private int cura;

    public ItemDeCura(String nome, ImageIcon imagem, boolean visivel, int cura) {
        super(nome, imagem, visivel);
        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }

    @Override
    public void efeito(Heroi heroi) {
        heroi.curar(this.cura);
    }
}
