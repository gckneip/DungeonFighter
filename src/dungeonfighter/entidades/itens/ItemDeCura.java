package dungeonfighter.entidades.itens;

import dungeonfighter.entidades.personagens.Heroi;
import javax.swing.ImageIcon;

public class ItemDeCura extends Item {

    private int cura;

    public ItemDeCura(String nome, ImageIcon imagem, int cura) {
        super(nome, imagem);
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

    @Override
    public ItemDeCura clone() {
        return new ItemDeCura(this.getNome(), this.getIcone(), this.getCura());
    }
}
